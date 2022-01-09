import java.util.ArrayList;
public class Player
{
	private int id;
	private String name;
	private ArrayList<Poker> handCards = new ArrayList<Poker>();

	public Player(int id, String name){
		this.id = id;
		this.name = name;
	}

	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setHandCards(ArrayList<Poker> handCards){
		this.handCards = handCards;
	}

	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public ArrayList<Poker> getHandCards(){
		return this.handCards;
	}
}