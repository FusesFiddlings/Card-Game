import javax.swing.*;

   public class Card implements java.io.Serializable
   {
      String command;
      String name;
      int type;
		boolean star = false;
		boolean winState = true;
		ImageIcon generik;
		
      public Card()
      {
      }
   
      public String command()
      {
         return command;
      }
		
		public ImageIcon getIcon()
		{
			return generik;
		}
		
		public ImageIcon getRollIcon()
		{
			return generik;
		}
		
		public ImageIcon getRollZIcon()
		{
			return generik;
		}
		
		public ImageIcon getTextIcon()
		{
			return generik;
		}
   }