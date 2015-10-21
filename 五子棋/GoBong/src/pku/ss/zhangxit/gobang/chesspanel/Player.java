/**
 * 玩家抽象接口
 */
package pku.ss.zhangxit.gobang.chesspanel;

import java.util.List;

/**
 * @author zhangxit
 *
 */
public interface Player {
	public void run(List<Point> enemyPoints, Point point);
	
	public boolean hasWin();
	
	public void setChessboard(ChessBoard chessboard);
	
	public List<Point> getMyPoints();
}
