package pku.ss.java.zhangxitao.gobanggame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	
	
	// 定义棋盘
	private Chessboard chessboard;
	
	
	//
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
			//System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
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
		//防受
		int[] res = aiDefend();
		if(res!=null)
			return res;
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "十") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;
	}
	
	
	/**
	 * 判断是否需要防守,如果需要，返回防守坐标
	 */
	public int[] aiDefend(){
		int[] res = new int[2];
		int ux = posX,dx = posX;
		
		//垂直方向扫描
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
		//水平方向扫描
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
		
		//左上到右下方向扫描
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
		//左下到右上方向扫描
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
	/*public boolean isWon(int posX, int posY, String ico) {
		return false;
	}*/
	public boolean isWon(int posX, int posY, String ico) {
		// 直线起点的X坐标
		int startX = 0;
		// 直线起点Y坐标
		int startY = 0;
		// 直线结束X坐标
		int endX = Chessboard.BOARD_SIZE - 1;
		// 直线结束Y坐标
		int endY = endX;
		// 同条直线上相邻棋子累积数
		int sameCount = 0;
		int temp = 0;

		// 计算起点的最小X坐标与Y坐标
		temp = posX - WIN_COUNT + 1;
		startX = temp < 0 ? 0 : temp;
		temp = posY - WIN_COUNT + 1;
		startY = temp < 0 ? 0 : temp;
		// 计算终点的最大X坐标与Y坐标
		temp = posX + WIN_COUNT - 1;
		endX = temp > Chessboard.BOARD_SIZE - 1 ? Chessboard.BOARD_SIZE - 1
				: temp;
		temp = posY + WIN_COUNT - 1;
		endY = temp > Chessboard.BOARD_SIZE - 1 ? Chessboard.BOARD_SIZE - 1
				: temp;
		// 从左到右方向计算相同相邻棋子的数目
		String[][] board = chessboard.getBoard();
		for (int i = startY; i < endY; i++) {
			if (board[posX][i].equals(ico) && board[posX][i + 1].equals(ico)) {
				sameCount++;
			} else if (sameCount != WIN_COUNT - 1) {
				sameCount = 0;
			}
		}
		if (sameCount == 0) {
			// 从上到下计算相同相邻棋子的数目
			for (int i = startX; i < endX; i++) {
				if (board[i][posY].equals(ico) && board[i + 1][posY].equals(ico)) {
					sameCount++;
				} else if (sameCount != WIN_COUNT - 1) {
					sameCount = 0;
				}
			}
		}
		if (sameCount == 0) {
			// 从左上到右下计算相同相邻棋子的数目
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
			// 从左下到右上计算相同相邻棋子的数目
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
	
	
	//判断是否危险
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
