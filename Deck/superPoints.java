
import javax.swing.*;
   public class superPoints extends Card
   {
      public superPoints()
      {
      
         this.name = "superPoints";
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
			return new ImageIcon("Cards/superPointsZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/superPoints.png");
		}
      public String command()
      {
         return "superPoints";
      }
   }