
import javax.swing.*;
   public class science extends Card
   {
      public science()
      {
      
         this.name = "science";
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
			return new ImageIcon("Cards/scienceZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/science.png");
		}
      public String command()
      {
         return "science";
      }
   }