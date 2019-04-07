
import javax.swing.*;
   public class noob extends Card
   {
      public noob()
      {
      
         this.name = "noob";
         this.type = 6;
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
			return new ImageIcon("Cards/noobZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/noob.png");
		}
      public String command()
      {
         return "noob";
      }
   }