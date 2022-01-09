import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
public class Game
{
	// 全局变量
	ArrayList<Poker> pokerList = new ArrayList<Poker>();
	ArrayList<Player> playerList = new ArrayList<Player>();
	String[] color = {"红桃","黑桃","梅花","方块"};
	String[] points = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

	public static void main(String[] args){
		System.out.println("----欢迎进入游戏----");
		Game game = new Game();

		// 1、创建扑克牌组
		game.createPoker();
		// 2、创建玩家
		game.createPlayer();
		// 3、洗牌
		game.shuffle();
		// 4、发牌
		game.deal();
		// 5、排序
		game.sortPoker();
		// 6、出牌，一决胜负
		game.comparePoker();
		System.out.println("----游戏结束----");
	}

	// 创建扑克牌组
	public void createPoker(){
		System.out.println("-创建扑克牌-");
		// 创建扑克牌对象
		for (int i =0;i<color.length ;i++ )
		{
			for (int j=0;j<points.length ;j++ )
			{
				Poker p = new Poker(color[i], points[j]);
				pokerList.add(p);
			}
		}

		// 输出扑克牌
		for (int i=1;i<=pokerList.size() ;i++ )
		{
			System.out.print(pokerList.get(i-1).getColor() + pokerList.get(i-1).getPoints() + " ");
			if (i%13 == 0)
			{
				System.out.println();
			}
		}
		System.out.println();
	}

	// 创建玩家
	public void createPlayer(){
		System.out.println("-创建玩家-");
		
		Scanner sc = new Scanner(System.in);
		int id = 0;
		for (int i = 1;i<=2 ;i++ )
		{
			System.out.println("请输入玩家"+ i +"的id，id是整数");
			try
			{
				id = sc.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("你的输入有误，请重新输入");
				sc = new Scanner(System.in);
				i--;
				continue;
			}
			System.out.println("请输入玩家"+ i +"的name");
			String name = sc.next();

			Player p = new Player(id, name);
			playerList.add(p);
		}

		// 给定红蓝方
		System.out.println("红色持方\t蓝色持方");
		System.out.println(playerList.get(0).getName() +"\t"+playerList.get(1).getName());
	}

	// 洗牌
	public void shuffle(){
		System.out.println("-开始洗牌-");
		Collections.shuffle(pokerList);

		// 输出扑克牌
		for (int i=1;i<=pokerList.size() ;i++ )
		{
			System.out.print(pokerList.get(i-1).getColor() + pokerList.get(i-1).getPoints() + " ");
			if (i%13 == 0)
			{
				System.out.println();
			}
		}
		System.out.println();
	}

	// 发牌
	public void deal(){
		System.out.println("-开始发牌-");
		System.out.println(playerList.get(0).getName() + "拿牌");
		playerList.get(0).getHandCards().add(pokerList.get(0));
		System.out.println(playerList.get(1).getName() + "拿牌");
		playerList.get(1).getHandCards().add(pokerList.get(1));
		System.out.println(playerList.get(0).getName() + "拿牌");
		playerList.get(0).getHandCards().add(pokerList.get(2));
		System.out.println(playerList.get(1).getName() + "拿牌");
		playerList.get(1).getHandCards().add(pokerList.get(3));
	}

	// 排序
	public void sortPoker(){
		System.out.println("-对纸牌排序-");
		Collections.sort(playerList.get(0).getHandCards());
		Collections.sort(playerList.get(1).getHandCards());
		
		for (int i=0;i<2 ;i++ )
		{
			System.out.println(playerList.get(i).getName());
			for (int j = 0;j<2 ;j++ )
			{
				System.out.println(playerList.get(i).getHandCards().get(j).getColor() + 
					playerList.get(i).getHandCards().get(j).getPoints() +" ");
			}
			System.out.println();
		}
	}

	// 出牌，决胜
	public void comparePoker(){
		System.out.println("-出牌，一决胜负-");
		// 取两位玩家的牌
		Poker player1MaxPoker = playerList.get(0).getHandCards().get(0);
		Poker player1MinPoker = playerList.get(0).getHandCards().get(1);

		Poker player2MaxPoker = playerList.get(1).getHandCards().get(0);
		Poker player2MinPoker = playerList.get(1).getHandCards().get(1);

		// 数组转成list
		List<String> colorList = Arrays.asList(color);
		List<String> pointsList = Arrays.asList(points);

		// 取下标
		int player1MaxPointsIndex = pointsList.indexOf(player1MaxPoker.getPoints());
		int player1MinPointsIndex = pointsList.indexOf(player1MinPoker.getPoints());

		int player2MaxPointsIndex = pointsList.indexOf(player2MaxPoker.getPoints());
		int player2MinPointsIndex = pointsList.indexOf(player2MinPoker.getPoints());

		int player1MaxColorIndex = colorList.indexOf(player1MaxPoker.getColor());
		int player1MinColorIndex = colorList.indexOf(player1MinPoker.getColor());

		int player2MaxColorIndex = colorList.indexOf(player2MaxPoker.getColor());
		int player2MinColorIndex = colorList.indexOf(player2MinPoker.getColor());
		
		// 比较逻辑
		if (player1MaxPointsIndex == player2MaxPointsIndex)
		{
			// 比较最小的牌点数
			if (player1MinPointsIndex == player2MinPointsIndex)
			{
				// 比较最大牌花色
				if (player1MaxColorIndex > player2MaxColorIndex)
				{
					System.out.println(playerList.get(0).getName()+"赢了");
				}else{
					System.out.println(playerList.get(1).getName()+"赢了");
				}
			}else if(player1MaxPointsIndex > player2MaxPointsIndex){
				System.out.println(playerList.get(0).getName()+"赢了");
			}else{
				System.out.println(playerList.get(1).getName()+"赢了");
			}
		}else if(player1MaxPointsIndex > player2MaxPointsIndex){
			System.out.println(playerList.get(0).getName()+"赢了");
		}else{
			System.out.println(playerList.get(1).getName()+"赢了");
		}
	}
}