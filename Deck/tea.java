
import javax.swing.*;
   public class tea extends Card
   {
      public tea()
      {
      
         this.name = "tea";
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
			return new ImageIcon("Cards/teaZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/tea.png");
		}
      public String command()
      {
         return "tea";
      }
   }