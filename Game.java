import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
public class Game
{
	// ȫ�ֱ���
	ArrayList<Poker> pokerList = new ArrayList<Poker>();
	ArrayList<Player> playerList = new ArrayList<Player>();
	String[] color = {"����","����","÷��","����"};
	String[] points = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

	public static void main(String[] args){
		System.out.println("----��ӭ������Ϸ----");
		Game game = new Game();

		// 1�������˿�����
		game.createPoker();
		// 2���������
		game.createPlayer();
		// 3��ϴ��
		game.shuffle();
		// 4������
		game.deal();
		// 5������
		game.sortPoker();
		// 6�����ƣ�һ��ʤ��
		game.comparePoker();
		System.out.println("----��Ϸ����----");
	}

	// �����˿�����
	public void createPoker(){
		System.out.println("-�����˿���-");
		// �����˿��ƶ���
		for (int i =0;i<color.length ;i++ )
		{
			for (int j=0;j<points.length ;j++ )
			{
				Poker p = new Poker(color[i], points[j]);
				pokerList.add(p);
			}
		}

		// ����˿���
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

	// �������
	public void createPlayer(){
		System.out.println("-�������-");
		
		Scanner sc = new Scanner(System.in);
		int id = 0;
		for (int i = 1;i<=2 ;i++ )
		{
			System.out.println("���������"+ i +"��id��id������");
			try
			{
				id = sc.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("���������������������");
				sc = new Scanner(System.in);
				i--;
				continue;
			}
			System.out.println("���������"+ i +"��name");
			String name = sc.next();

			Player p = new Player(id, name);
			playerList.add(p);
		}

		// ����������
		System.out.println("��ɫ�ַ�\t��ɫ�ַ�");
		System.out.println(playerList.get(0).getName() +"\t"+playerList.get(1).getName());
	}

	// ϴ��
	public void shuffle(){
		System.out.println("-��ʼϴ��-");
		Collections.shuffle(pokerList);

		// ����˿���
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

	// ����
	public void deal(){
		System.out.println("-��ʼ����-");
		System.out.println(playerList.get(0).getName() + "����");
		playerList.get(0).getHandCards().add(pokerList.get(0));
		System.out.println(playerList.get(1).getName() + "����");
		playerList.get(1).getHandCards().add(pokerList.get(1));
		System.out.println(playerList.get(0).getName() + "����");
		playerList.get(0).getHandCards().add(pokerList.get(2));
		System.out.println(playerList.get(1).getName() + "����");
		playerList.get(1).getHandCards().add(pokerList.get(3));
	}

	// ����
	public void sortPoker(){
		System.out.println("-��ֽ������-");
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

	// ���ƣ���ʤ
	public void comparePoker(){
		System.out.println("-���ƣ�һ��ʤ��-");
		// ȡ��λ��ҵ���
		Poker player1MaxPoker = playerList.get(0).getHandCards().get(0);
		Poker player1MinPoker = playerList.get(0).getHandCards().get(1);

		Poker player2MaxPoker = playerList.get(1).getHandCards().get(0);
		Poker player2MinPoker = playerList.get(1).getHandCards().get(1);

		// ����ת��list
		List<String> colorList = Arrays.asList(color);
		List<String> pointsList = Arrays.asList(points);

		// ȡ�±�
		int player1MaxPointsIndex = pointsList.indexOf(player1MaxPoker.getPoints());
		int player1MinPointsIndex = pointsList.indexOf(player1MinPoker.getPoints());

		int player2MaxPointsIndex = pointsList.indexOf(player2MaxPoker.getPoints());
		int player2MinPointsIndex = pointsList.indexOf(player2MinPoker.getPoints());

		int player1MaxColorIndex = colorList.indexOf(player1MaxPoker.getColor());
		int player1MinColorIndex = colorList.indexOf(player1MinPoker.getColor());

		int player2MaxColorIndex = colorList.indexOf(player2MaxPoker.getColor());
		int player2MinColorIndex = colorList.indexOf(player2MinPoker.getColor());
		
		// �Ƚ��߼�
		if (player1MaxPointsIndex == player2MaxPointsIndex)
		{
			// �Ƚ���С���Ƶ���
			if (player1MinPointsIndex == player2MinPointsIndex)
			{
				// �Ƚ�����ƻ�ɫ
				if (player1MaxColorIndex > player2MaxColorIndex)
				{
					System.out.println(playerList.get(0).getName()+"Ӯ��");
				}else{
					System.out.println(playerList.get(1).getName()+"Ӯ��");
				}
			}else if(player1MaxPointsIndex > player2MaxPointsIndex){
				System.out.println(playerList.get(0).getName()+"Ӯ��");
			}else{
				System.out.println(playerList.get(1).getName()+"Ӯ��");
			}
		}else if(player1MaxPointsIndex > player2MaxPointsIndex){
			System.out.println(playerList.get(0).getName()+"Ӯ��");
		}else{
			System.out.println(playerList.get(1).getName()+"Ӯ��");
		}
	}
}