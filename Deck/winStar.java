
import javax.swing.*;
   public class winStar extends Card
   {
      public winStar()
      {
      
         this.name = "winStar";
         this.type = 3;
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
			return new ImageIcon("Cards/winStarZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/winStar.png");
		}
      public String command()
      {
         return "winStar";
      }
   }