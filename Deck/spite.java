
import javax.swing.*;
   public class spite extends Card
   {
      public spite()
      {
      
         this.name = "spite";
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
			return new ImageIcon("Cards/spiteZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/spite.png");
		}
      public String command()
      {
         return "spite";
      }
   }