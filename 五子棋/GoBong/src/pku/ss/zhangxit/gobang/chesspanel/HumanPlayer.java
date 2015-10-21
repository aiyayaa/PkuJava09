/**
 * 
 */
package pku.ss.zhangxit.gobang.chesspanel;

import java.util.List;

/**
 * @author zhangxit
 *
 */
public abstract class HumanPlayer extends BasePlayer {
	public void run(List<Point> enemyPoints, Point p) {
		// TODO 自动生成的方法存根
		allFreePoints.remove(p);
	}

}
