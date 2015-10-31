package pku.ss.java.zhangxitao.gobanggame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	
	
	// ��������
	private Chessboard chessboard;
	
	
	//
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
			//System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
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
		//����
		int[] res = aiDefend();
		if(res!=null)
			return res;
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "ʮ") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;
	}
	
	
	/**
	 * �ж��Ƿ���Ҫ����,�����Ҫ�����ط�������
	 */
	public int[] aiDefend(){
		int[] res = new int[2];
		int ux = posX,dx = posX;
		
		//��ֱ����ɨ��
		while(((ux-1)>=0)&&Chessman.BLACK.getChessman().equals(chessboard.getBoard()[ux-1][posY])){
			ux--;
		}
		while(((dx+1)<=(Chessboard.BOARD_SIZE - 1))&&Chessman.BLACK.getChessman().equals(chessboard.getBoard()[dx+1][posY])){
			dx++;
		}
		if(dx-ux+1==3){
			if((ux!=0)&&(dx!=Chessboard.BOARD_SIZE - 1)){
				if(!Chessman.WHITE.getChessman().equals(chessboard.getBoard()[dx+1][posY])&&!Chessman.WHITE.getChessman().equals(chessboard.getBoard()[ux-1][posY])){
					if(ux==1){
						res[0]=dx+1;
					}else if(Chessboard.BOARD_SIZE-1-dx==1){
						res[0]=ux-1;
						
					}else{
						res[0]=dx+1;
					}
					res[1]=posY;
					
					return res;
				}
			}
		}else if(dx-ux+1==4){
			if(ux==0){
				if(!Chessman.WHITE.getChessman().equals(chessboard.getBoard()[dx+1][posY])){
					res[0]=dx+1;
					res[1]=posY;
					return res;
				}
			}
			else{
				res[0]=ux-1;
				res[1]=posY;
				return res;
			}
		}
		
		int ly = posY,ry=posY;
		//ˮƽ����ɨ��
		while(((ly-1)>=0)&&Chessman.BLACK.getChessman().equals(chessboard.getBoard()[posX][ly-1])){
			ly--;
		}
		while(((ry+1)<=(Chessboard.BOARD_SIZE - 1))&&Chessman.BLACK.getChessman().equals(chessboard.getBoard()[posX][ry+1])){
			ry++;
		}
		if(ry-ly+1==3){
			if((ly!=0)&&(ry!=Chessboard.BOARD_SIZE - 1)){
				if(Chessman.WHITE.getChessman().equals(chessboard.getBoard()[posX][ry+1])||Chessman.WHITE.getChessman().equals(chessboard.getBoard()[posX][ly-1])){
					return null;
				}else{
					res[0]=posX;
					if(ly==1){
						res[1]=ry+1;
					}else if(Chessboard.BOARD_SIZE-1-ry==1){
						res[1]=ly-1;
						
					}else{
						res[1]=ry+1;
					}
					
					return res;
				}
			}
		}else if(ry-ly+1==4){
			if(ly==0){
				if(!Chessman.WHITE.getChessman().equals(chessboard.getBoard()[posX][ry+1])){
					res[0]=posX;
					res[1]=ry+1;
					return res;
				}
			}
			else{
				res[0]=posX;
				res[1]=ly-1;
				return res;
			}
			return res;
		}
		
		//���ϵ����·���ɨ��
		ux = posX;dx=posX;ly=posY;ry=posY;
		while(((ux-1)>=0&&(ly-1)>=0)&&Chessman.BLACK.getChessman().equals(chessboard.getBoard()[ux-1][ly-1])){
			ux--;
			ly--;
		}
		while(((dx+1)<=(Chessboard.BOARD_SIZE - 1)&&(ry+1)<=(Chessboard.BOARD_SIZE - 1))&&Chessman.BLACK.getChessman().equals(chessboard.getBoard()[dx+1][ry+1])){
			dx++;
			ry++;
		}
		if(dx-ux+1==3){
			if((ux!=0)&&(dx!=Chessboard.BOARD_SIZE - 1)){
				if(!Chessman.WHITE.getChessman().equals(chessboard.getBoard()[dx+1][ry+1])&&!Chessman.WHITE.getChessman().equals(chessboard.getBoard()[ux-1][ly-1])){
					if(ux==1){
						res[0]=dx+1;
						res[1]=ry+1;
					}else if(Chessboard.BOARD_SIZE-1-dx==1){
						res[0]=ux-1;
						res[1]=ly-1;
						
					}else{
						res[0]=dx+1;
						res[1]=ry+1;
					}
					return res;
				}
			}
		}else if(dx-ux+1==4){
			if(ux==0){
				if(!Chessman.WHITE.getChessman().equals(chessboard.getBoard()[dx+1][ry+1])){
					res[0]=dx+1;
					res[1]=ry+1;
					return res;
				}
			}else{
				res[0]=ux-1;
				res[1]=ly-1;
				return res;
			}
			
		}
		//���µ����Ϸ���ɨ��
		ux = posX;dx=posX;ly=posY;ry=posY;
		while(((ux-1)>=0&&(ry+1)<=(Chessboard.BOARD_SIZE - 1))&&Chessman.BLACK.getChessman().equals(chessboard.getBoard()[ux-1][ry+1])){
			ux--;
			ry++;
		}
		while(((dx+1)<=(Chessboard.BOARD_SIZE - 1)&&(ly-1)>=0)&&Chessman.BLACK.getChessman().equals(chessboard.getBoard()[dx+1][ly-1])){
			dx++;
			ly--;
		}
		if(dx-ux+1==3){
			if((ux!=0)&&(dx!=Chessboard.BOARD_SIZE - 1)){
				if(!Chessman.WHITE.getChessman().equals(chessboard.getBoard()[dx+1][ly-1])&&!Chessman.WHITE.getChessman().equals(chessboard.getBoard()[ux-1][ry+1])){
					if(ux==1){
						res[0]=dx+1;
						res[1]=ly-1;
					}else if(Chessboard.BOARD_SIZE-1-dx==1){
						res[0]=ux-1;
						res[1]=ry+1;				
					}else{
						res[0]=dx+1;
						res[1]=ly-1;
					}
					return res;
				}
			}
		}else if(dx-ux+1==4){
			if(ux==0){
				if(!Chessman.WHITE.getChessman().equals(chessboard.getBoard()[dx+1][ly-1])){
					res[0]=dx+1;
					res[1]=ly-1;
					return res;
				}
			}else{
				res[0]=ux-1;
				res[1]=ry+1;
				return res;
			}
		}
		return null;
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
	/*public boolean isWon(int posX, int posY, String ico) {
		return false;
	}*/
	public boolean isWon(int posX, int posY, String ico) {
		// ֱ������X����
		int startX = 0;
		// ֱ�����Y����
		int startY = 0;
		// ֱ�߽���X����
		int endX = Chessboard.BOARD_SIZE - 1;
		// ֱ�߽���Y����
		int endY = endX;
		// ͬ��ֱ�������������ۻ���
		int sameCount = 0;
		int temp = 0;

		// ����������СX������Y����
		temp = posX - WIN_COUNT + 1;
		startX = temp < 0 ? 0 : temp;
		temp = posY - WIN_COUNT + 1;
		startY = temp < 0 ? 0 : temp;
		// �����յ�����X������Y����
		temp = posX + WIN_COUNT - 1;
		endX = temp > Chessboard.BOARD_SIZE - 1 ? Chessboard.BOARD_SIZE - 1
				: temp;
		temp = posY + WIN_COUNT - 1;
		endY = temp > Chessboard.BOARD_SIZE - 1 ? Chessboard.BOARD_SIZE - 1
				: temp;
		// �����ҷ��������ͬ�������ӵ���Ŀ
		String[][] board = chessboard.getBoard();
		for (int i = startY; i < endY; i++) {
			if (board[posX][i].equals(ico) && board[posX][i + 1].equals(ico)) {
				sameCount++;
			} else if (sameCount != WIN_COUNT - 1) {
				sameCount = 0;
			}
		}
		if (sameCount == 0) {
			// ���ϵ��¼�����ͬ�������ӵ���Ŀ
			for (int i = startX; i < endX; i++) {
				if (board[i][posY].equals(ico) && board[i + 1][posY].equals(ico)) {
					sameCount++;
				} else if (sameCount != WIN_COUNT - 1) {
					sameCount = 0;
				}
			}
		}
		if (sameCount == 0) {
			// �����ϵ����¼�����ͬ�������ӵ���Ŀ
			int j = startY;
			for (int i = startX; i < endX; i++) {
				if (j < endY) {
					if (board[i][j].equals(ico) && board[i + 1][j + 1].equals(ico)) {
						sameCount++;
					} else if (sameCount != WIN_COUNT - 1) {
						sameCount = 0;
					}
					j++;
				}
			}
		}
		if (sameCount == 0) {
			// �����µ����ϼ�����ͬ�������ӵ���Ŀ
			int j = startY;
			for (int i = endX; i > startX; i--) {
				if (j < endY) {
					if (board[i][j].equals(ico) && board[i - 1][j + 1].equals(ico)) {
						sameCount++;
					} else if (sameCount != WIN_COUNT - 1) {
						sameCount = 0;
					}
					j++;
				}
			}
		}
		return sameCount == WIN_COUNT - 1 ? true : false;
	}
	
	
	//�ж��Ƿ�Σ��
	private int[] isDangerous(){
		int posX = this.posX;
		int posY = this.posY;
		//while(posX)
		return null;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
