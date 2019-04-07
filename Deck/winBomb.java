
import javax.swing.*;
   public class winBomb extends Card
   {
      public winBomb()
      {
      
         this.name = "winBomb";
         this.type = 3;
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
			return new ImageIcon("Cards/winBombZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/winBomb.png");
		}
      public String command()
      {
         return "winBomb";
      }
   }