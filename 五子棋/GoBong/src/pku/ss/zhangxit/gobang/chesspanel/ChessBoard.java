/**
 * 棋盘抽象接口
 */
package pku.ss.zhangxit.gobang.chesspanel;

import java.util.List;

/**
 * @author zhangxit
 *
 */
public interface ChessBoard {
	public int getMaxX();//获取棋盘最大横坐标
	public int getMaxY();//获取棋盘最大纵坐标
	public List<Point> getFreePoints();
	//获取到所有可以下棋的位置（空白点）
}
