
import javax.swing.*;
   public class drawFour extends Card
   {
      public drawFour()
      {
      
         this.name = "drawFour";
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
			return new ImageIcon("Cards/drawFourZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/drawFour.png");
		}
      public String command()
      {
         return "drawFour";
      }
   }