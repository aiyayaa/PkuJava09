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
		// TODO �Զ����ɵķ������
		allFreePoints.remove(p);
	}

}
