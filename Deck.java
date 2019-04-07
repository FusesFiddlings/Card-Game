   import java.util.ArrayList;
   import java.util.Collections;
   public class Deck
   {
      ArrayList<Card> deck = new ArrayList<Card>();
      public Deck(int i)
      {
         if(i==0)
         {
            deck.add(new arrowed());
            deck.add(new numbersP());
				deck.add(new noob());
            deck.add(new numbersP());
				deck.add(new blankCard());
            deck.add(new ninjas());
         }
         else
         {
         }
         Collections.shuffle(deck);
      }
      public Card draw()
      {
         Card c = deck.get(0);
         deck.remove(0);
         return c;
      }
   }