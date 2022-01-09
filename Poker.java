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

	// 重写compareTo方法
	public int compareTo(Poker p){
		// 定义纸牌比较规则，点数权重10 * 点数 + 花数权重1 * 花数
		//	= 纸牌面值 
		String[] color = {"红桃","黑桃","梅花","方块"};
		String[] points = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		
		// 数组转成list
		List<String> colorList = Arrays.asList(color);
		List<String> pointsList = Arrays.asList(points);
		// 使用indexOf
		// 第一个对象点数以及花色在list下标
		int colorIndex1 = colorList.indexOf(this)+1;
		int pointIndex1 = pointsList.indexOf(this)+1;

		// 第二个对象点数以及花色在list下标
		int colorIndex2 = colorList.indexOf(p)+1;
		int pointIndex2 = pointsList.indexOf(p)+1;

		int temp1 = pointIndex1 * 10 + colorIndex1 * 1;
		int temp2 = pointIndex2 * 10 + colorIndex2 * 1;

		return temp2 - temp1;
	}
}