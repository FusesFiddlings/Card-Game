
import javax.swing.*;
   public class winBirthday extends Card
   {
      public winBirthday()
      {
      
         this.name = "winBirthday";
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
			return new ImageIcon("Cards/winBirthdayZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/winBirthday.png");
		}
      public String command()
      {
         return "winBirthday";
      }
   }