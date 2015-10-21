/**
 * 棋子类实现
 */
package pku.ss.zhangxit.gobang.chesspanel;

/**
 * @author zhangxit
 *
 */
public class Point {
	public int x;
	public int y;
	/**
	 * @return x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x 要设置的 x
	 */
	public Point setX(int x) {
		this.x = x;
		return this;
	}
	/**
	 * @return y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y 要设置的 y
	 */
	public Point setY(int y) {
		this.y = y;
		return this;
	}
	
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		// TODO 自动生成的方法存根
		return x+y;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO 自动生成的方法存根
		if(this == obj)
		return true;
		Point other = (Point) obj;
		if (x!=other.x)
			return false;
		if (y!=other.y) {
			return false;
		}
		return true;
	}
}
