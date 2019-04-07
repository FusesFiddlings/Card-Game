
import javax.swing.*;
   public class numbersP extends Card
   {
      public numbersP()
      {
      
         this.name = "numbersP";
         this.type = 1;
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
			return new ImageIcon("Cards/numbersPZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/numbersP.png");
		}
      public String command()
      {
         return "FINGERS";
      }
   }