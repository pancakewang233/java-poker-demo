import java.util.Arrays;
import java.util.List;
public class Poker implements Comparable<Poker>
{
	private String color;
	private String points;

	public Poker(String color, String points){
		this.color = color;
		this.points = points;
	}

	public void setColor(String color){
		this.color = color;
	}
	public void setPoints(String points){
		this.points = points;
	}

	public String getColor(){
		return this.color;
	}
	public String getPoints(){
		return this.points;
	}

	// ��дcompareTo����
	public int compareTo(Poker p){
		// ����ֽ�ƱȽϹ��򣬵���Ȩ��10 * ���� + ����Ȩ��1 * ����
		//	= ֽ����ֵ 
		String[] color = {"����","����","÷��","����"};
		String[] points = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		
		// ����ת��list
		List<String> colorList = Arrays.asList(color);
		List<String> pointsList = Arrays.asList(points);
		// ʹ��indexOf
		// ��һ����������Լ���ɫ��list�±�
		int colorIndex1 = colorList.indexOf(this)+1;
		int pointIndex1 = pointsList.indexOf(this)+1;

		// �ڶ�����������Լ���ɫ��list�±�
		int colorIndex2 = colorList.indexOf(p)+1;
		int pointIndex2 = pointsList.indexOf(p)+1;

		int temp1 = pointIndex1 * 10 + colorIndex1 * 1;
		int temp2 = pointIndex2 * 10 + colorIndex2 * 1;

		return temp2 - temp1;
	}
}