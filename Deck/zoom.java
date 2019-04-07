
import javax.swing.*;
   public class zoom extends Card
   {
      public zoom()
      {
      
         this.name = "zoom";
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
			return new ImageIcon("Cards/zoomZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/zoom.png");
		}
      public String command()
      {
         return "zoom";
      }
   }