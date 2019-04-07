
import javax.swing.*;
   public class suprise extends Card
   {
      public suprise()
      {
      
         this.name = "suprise";
         this.type = 6;
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
			return new ImageIcon("Cards/supriseZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/suprise.png");
		}
      public String command()
      {
         return "suprise";
      }
   }