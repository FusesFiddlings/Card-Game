
import javax.swing.*;
   public class end extends Card
   {
      public end()
      {
      
         this.name = "end";
         this.type = 3;
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
			return new ImageIcon("Cards/endZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/end.png");
		}
      public String command()
      {
         return "end";
      }
   }