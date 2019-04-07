
import javax.swing.*;
   public class kittens extends Card
   {
      public kittens()
      {
      
         this.name = "kittens";
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
			return new ImageIcon("Cards/kittensZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/kittens.png");
		}
      public String command()
      {
         return "kittens";
      }
   }