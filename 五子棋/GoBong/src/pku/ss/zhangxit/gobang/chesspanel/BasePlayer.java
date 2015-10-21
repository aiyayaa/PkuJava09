/**
 * 
 */
package pku.ss.zhangxit.gobang.chesspanel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxit
 *
 */
public abstract class BasePlayer implements Player{
	protected List<Point> myPoints = new ArrayList<Point>(200);
	//已经下到棋盘中的棋子
	protected ChessBoard chessboard;
	//棋盘
	protected int maxX;//棋盘最大横坐标
	protected int maxY;//棋盘最大纵坐标
	
	protected List<Point> allFreePoints;//所有空白棋子
	
	public final List<Point> getMyPoints() {
		// TODO 自动生成的方法存根
		return myPoints;
	}
	
	public void setChessboard(ChessBoard chessboard) {
		// TODO 自动生成的方法存根
		this.chessboard = chessboard;
		allFreePoints = chessboard.getFreePoints();
		maxX = chessboard.getMaxX();
		maxY = chessboard.getMaxY();
		myPoints.clear();
	}
	
	private final Point temp = new Point(0,0);
	//判断我是否赢了
	public final boolean hasWin(){
		if (myPoints.size()<5) {
			return false;
		}
		Point point = myPoints.get(myPoints.size()-1);
		int count = 1;
		int x = point.getX(),y = point.getY();
		
		//横向
		temp.setX(x).setY(y);
		while (myPoints.contains(temp.setX(temp.getX()-1))
				&&count<5) {
			count++;
		}
		if (count>=5) {
			return true;
		}
		temp.setX(x).setY(y);
		while (myPoints.contains(temp.setX(temp.getX()+1))
				&&temp.getX()<maxX&&count<5) {
			count++;
		}
		//纵向
		count = 1;
		temp.setX(x).setY(y);
		while (myPoints.contains(temp.setY(temp.getY()-1))
				&&temp.getY()>=0) {
			count++;
			
		}
		if (count>=5) {
			return true;
			
		}
		
		//正斜向   /
		count = 1;
		temp.setX(x).setY(y);
		while (myPoints.contains(temp.setX(temp.getX()-1).setY(temp.getY()+1)) 
				&& temp.getX()>=0 && temp.getY()<maxY) {
			count++;
		}
		if(count>=5){  
            return true;  
        }  
        temp.setX(x).setY(y);  
        while (myPoints.contains(temp.setX(temp.getX()+1).setY(temp.getY()-1)) && temp.getX()<maxX && temp.getY()>=0 && count<6) {  
            count ++;  
        }  
        if(count>=5){  
            return true;  
        }
      //反斜 \  
        count = 1;  
        temp.setX(x).setY(y);  
        while (myPoints.contains(temp.setX(temp.getX()-1).setY(temp.getY()-1)) && temp.getX()>=0 && temp.getY()>=0) {  
            count ++;  
        }  
        if(count>=5){  
            return true;  
        }  
        temp.setX(x).setY(y);  
        while (myPoints.contains(temp.setX(temp.getX()+1).setY(temp.getY()+1)) && temp.getX()<maxX && temp.getY()<maxY && count<5) {  
            count ++;  
        }  
        if(count>=5){  
            return true;  
        }  
        return false;
	}
}
