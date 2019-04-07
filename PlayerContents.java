import java.util.ArrayList;
public class PlayerContents
{
	String name;
	ArrayList<Card> held = new ArrayList<Card>();
	ArrayList<Card> board = new ArrayList<Card>();

	public PlayerContents(String s)
	{
		name = s;
	}
}