/**
 * @author Gregory Cremins
 * @version 3-28-2012
 * Class to create a player with items array of useful items and junk. also player has a number of coins, a score, and the number of steps they took.
 */

public class Player{
public static Item[] items = new Item[]{ new Item("Knife", 30), new Item("Nyan", 50), new Item("Key", 10), new Item("URL", 40), new Item("Statue", 20)};
public Item[] junk = new Item[5];
public static int numJunk = 0;
public static int numb_Coins = 0;
public static int score = 0; 
public static int steps = 0;
public Player(){}

/**
 * Method to display the inventory
 */
public void displayInventory()
{
System.out.println("You currently have: ");
  for(Item i: items)
  {
    if(i.isOwned)
    {
      System.out.print("A " + i.getName());
      System.out.println(".");
    }
}
  for(int j = 0; j < numJunk; j++)
  {
    if(junk[j].isOwned)
    {
      System.out.print("A " + junk[j].getName());
      System.out.println(".");
    }
}
}
/**
 * Method to return the current number of coins the player has.
 * @return the number of coins they have
 */
  public int getCoins()
  {
   return numb_Coins; 
  }
  
  public void subCoins(int subtraction)
  {
   numb_Coins = numb_Coins - subtraction; 
  }
  
  /**
   * Method to return the score of the player
   * @return the player's current score
   */
public void getScore(){
  score = 0;
  for(Item i: items)
         {
             if(i.isOwned)
             score = score + i.getPointValue();
         }
  for(Item j: junk)
         {
             score = score + j.getPointValue();
         }
         score = score + numb_Coins;
         System.out.println("Your score was: " + score + ".");
         System.out.println("You completed the game in " + steps + " steps.");
}
}