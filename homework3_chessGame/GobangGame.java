package chessGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class GobangGame {
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo() {
		int max_computer = 0;
		int max_human = 0;
		int iMax=0,jMax=0;
		int max=0;
		String[][] board = chessboard.getBoard();
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 21; j++) {
				if(board[i][j] == "ʮ") {
					max_computer=countMax(i,j,"��");
					max_human=countMax(i,j,"��");
					if(max<Math.max(max_computer,max_human)){
						max=Math.max(max_computer,max_human);
						iMax=i;
						jMax=j;
					}
			}
		}							
	}
		int[] result = { iMax, jMax };	
		return result;
}	
	//�жϰ˸���������������
	public int countMax(int posX ,int posY ,String ico){
		int max=0;
		int [] count = countdir(posX,posY, ico);
		for(int i = 0;i<8;++i){
			if(max<count[i]) max=count[i];
		}
		return max;
	}
	/**
	 * ������������������Ŀ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ����һ������count����¼�˸����������ӵ���Ŀ
	 */
	public int [] countdir(int posX ,int posY ,String ico){
		//��������������Ӹ���
		int [] count = new int [8];		
		String[][] board = chessboard.getBoard();
		int x=posX,y=posY;
		//������������
		for(int i=1;i<5;++i){
						
			x = x-1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[0];
			else break;
		}
		 x=posX;y=posY;
		 
		//�������ϲ������
		for(int i=1;i<5;++i){
			
			x = x-1;
			y = y-1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[1];
			else break;
		}
		 x=posX;y=posY;
		 
		//�����ϲ������
		for(int i=1;i<5;++i){
			
			y = y-1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[2];
			else break;
		}
		 x=posX;y=posY;
		 
		//�������ϲ������
		for(int i=1;i<5;++i){
			
			x = x+1;
			y = y-1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[3];
			else break;
		}
		 x=posX;y=posY;
		 
		//�����Ҳ������
		for(int i=1;i<5;++i){
			
			x = x+1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[4];
			else break;
		}
		 x=posX;y=posY;
		 
		//�������²������
		for(int i=1;i<5;++i){
			
			x = x+1;
			y = y+1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[5];
			else break;
		}
		 x=posX;y=posY;
		 
		//�����²������
		for(int i=1;i<5;++i){
			
			y = y+1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[6];
			else break;
		}
		 x=posX;y=posY;
		 
		//�������²������
		for(int i=1;i<5;++i){
			
			x = x-1;
			y = y+1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[7];
			else break;
		}			
		return count;
	}
	
	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {		
		//�ж��Ƿ��ʤ
		int [] count = countdir(posX,posY,ico);
		for(int i = 0;i<4;++i){
			if(count[i]+count[i+4]>3) {
				return true;				
			}
		}		
		return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
