import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
public class previousCard
{
   JPanel previous = new JPanel();
   JLabel current;
   int bottomBound;
   double d = .7;
   public previousCard(int i)
   {
      bottomBound = i;
      LayoutManager overlay = new OverlayLayout(previous);
      previous.setLayout(overlay);
      previous.setBackground(Color.PINK);
      ImageIcon text = new ImageIcon(new ImageIcon("Cards/previous.png").getImage().getScaledInstance((int)(1.4*bottomBound*.44/.62),(int)(1.4*bottomBound),Image.SCALE_SMOOTH ));
      JLabel frame = new JLabel("", text, JLabel.CENTER);
      frame.setAlignmentX(0.5f);
      frame.setAlignmentY(0.5f);
      previous.add(frame);
      text = new ImageIcon(new ImageIcon("Cards/blank.png").getImage().getScaledInstance((int)(bottomBound*.6667),(int)(bottomBound),Image.SCALE_SMOOTH ));
      current = new JLabel("", text, JLabel.CENTER);
      current.setAlignmentX(0.5f);
      current.setAlignmentY(0.535f);
      previous.add(current);
      previous.setVisible(false);
   }
   public JPanel addPrevious()
   {
      return previous;
   }
   public void editPrevious(Card c)
   {
      ImageIcon temp = new ImageIcon(c.getRollZIcon().getImage().getScaledInstance((int)(bottomBound*.6667),(int)(bottomBound),Image.SCALE_SMOOTH ));
      current.setIcon(temp);
   }
}