/**
 * ���̳���ӿ�
 */
package pku.ss.zhangxit.gobang.chesspanel;

import java.util.List;

/**
 * @author zhangxit
 *
 */
public interface ChessBoard {
	public int getMaxX();//��ȡ������������
	public int getMaxY();//��ȡ�������������
	public List<Point> getFreePoints();
	//��ȡ�����п��������λ�ã��հ׵㣩
}
