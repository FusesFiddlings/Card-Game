
import javax.swing.*;
   public class bombParty extends Card
   {
      public bombParty()
      {
      
         this.name = "bombParty";
         this.type = 2;
			this.star = false;
      }
		
		public ImageIcon getIcon()
		{
			return new ImageIcon("Cards/card.png");
		}
		
		public ImageIcon getRollIcon()
		{
			return new ImageIcon("Cards/cardRoll.png");
		}
		
		public ImageIcon getRollZIcon()
		{
			return new ImageIcon("Cards/bombPartyZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/bombParty.png");
		}
      public String command()
      {
         return "bombParty";
      }
   }