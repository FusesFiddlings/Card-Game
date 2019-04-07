
import javax.swing.*;
   public class spaceship extends Card
   {
      public spaceship()
      {
      
         this.name = "spaceship";
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
			return new ImageIcon("Cards/spaceshipZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/spaceship.png");
		}
      public String command()
      {
         return "spaceship";
      }
   }