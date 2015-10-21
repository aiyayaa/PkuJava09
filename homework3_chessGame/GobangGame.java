package chessGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class GobangGame {
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		int max_computer = 0;
		int max_human = 0;
		int iMax=0,jMax=0;
		int max=0;
		String[][] board = chessboard.getBoard();
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 21; j++) {
				if(board[i][j] == "十") {
					max_computer=countMax(i,j,"○");
					max_human=countMax(i,j,"●");
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
	//判断八个方向中最大的连子
	public int countMax(int posX ,int posY ,String ico){
		int max=0;
		int [] count = countdir(posX,posY, ico);
		for(int i = 0;i<8;++i){
			if(max<count[i]) max=count[i];
		}
		return max;
	}
	/**
	 * 计算各个方向的连子数目
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 返回一个数组count，记录了各个方向连子的数目
	 */
	public int [] countdir(int posX ,int posY ,String ico){
		//建立数组计算连子个数
		int [] count = new int [8];		
		String[][] board = chessboard.getBoard();
		int x=posX,y=posY;
		//计算左侧的连子
		for(int i=1;i<5;++i){
						
			x = x-1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[0];
			else break;
		}
		 x=posX;y=posY;
		 
		//计算左上侧的连子
		for(int i=1;i<5;++i){
			
			x = x-1;
			y = y-1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[1];
			else break;
		}
		 x=posX;y=posY;
		 
		//计算上侧的连子
		for(int i=1;i<5;++i){
			
			y = y-1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[2];
			else break;
		}
		 x=posX;y=posY;
		 
		//计算右上侧的连子
		for(int i=1;i<5;++i){
			
			x = x+1;
			y = y-1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[3];
			else break;
		}
		 x=posX;y=posY;
		 
		//计算右侧的连子
		for(int i=1;i<5;++i){
			
			x = x+1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[4];
			else break;
		}
		 x=posX;y=posY;
		 
		//计算右下侧的连子
		for(int i=1;i<5;++i){
			
			x = x+1;
			y = y+1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[5];
			else break;
		}
		 x=posX;y=posY;
		 
		//计算下侧的连子
		for(int i=1;i<5;++i){
			
			y = y+1;
			if(x<0||y<0||x>22||y>22) break;
			
			if(board[x][y]==ico) ++count[6];
			else break;
		}
		 x=posX;y=posY;
		 
		//计算左下侧的连子
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
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {		
		//判断是否获胜
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
