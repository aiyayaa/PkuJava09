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
	//�Ѿ��µ������е�����
	protected ChessBoard chessboard;
	//����
	protected int maxX;//������������
	protected int maxY;//�������������
	
	protected List<Point> allFreePoints;//���пհ�����
	
	public final List<Point> getMyPoints() {
		// TODO �Զ����ɵķ������
		return myPoints;
	}
	
	public void setChessboard(ChessBoard chessboard) {
		// TODO �Զ����ɵķ������
		this.chessboard = chessboard;
		allFreePoints = chessboard.getFreePoints();
		maxX = chessboard.getMaxX();
		maxY = chessboard.getMaxY();
		myPoints.clear();
	}
	
	private final Point temp = new Point(0,0);
	//�ж����Ƿ�Ӯ��
	public final boolean hasWin(){
		if (myPoints.size()<5) {
			return false;
		}
		Point point = myPoints.get(myPoints.size()-1);
		int count = 1;
		int x = point.getX(),y = point.getY();
		
		//����
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
		//����
		count = 1;
		temp.setX(x).setY(y);
		while (myPoints.contains(temp.setY(temp.getY()-1))
				&&temp.getY()>=0) {
			count++;
			
		}
		if (count>=5) {
			return true;
			
		}
		
		//��б��   /
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
      //��б \  
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
