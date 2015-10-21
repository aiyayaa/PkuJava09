/**
 * ������ʵ��
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
	 * @param x Ҫ���õ� x
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
	 * @param y Ҫ���õ� y
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
		// TODO �Զ����ɵķ������
		return x+y;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO �Զ����ɵķ������
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
