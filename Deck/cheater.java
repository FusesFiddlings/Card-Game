
import javax.swing.*;
   public class cheater extends Card
   {
      public cheater()
      {
      
         this.name = "cheater";
         this.type = 2;
			this.star = true;
      }
		
		public ImageIcon getIcon()
		{
			return new ImageIcon("Cards/star.png");
		}
		
		public ImageIcon getRollIcon()
		{
			return new ImageIcon("Cards/starRoll.png");
		}
		
		public ImageIcon getRollZIcon()
		{
			return new ImageIcon("Cards/cheaterZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/cheater.png");
		}
      public String command()
      {
         return "cheater";
      }
   }