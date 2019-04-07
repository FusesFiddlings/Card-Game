
import javax.swing.*;
   public class extraLife extends Card
   {
      public extraLife()
      {
      
         this.name = "extraLife";
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
			return new ImageIcon("Cards/extraLifeZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/extraLife.png");
		}
      public String command()
      {
         return "extraLife";
      }
   }