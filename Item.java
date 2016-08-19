/**
 * @author Gregory Cremins
 * @version 3-28-2012
 * Class to define an Item with a few values.
 */
public class Item{
 public String name;
 public int pointValue;
 public boolean isOwned = false;
   
  public Item(String theName, int thePointValue)
  {
    this.name = theName;
    this.pointValue = thePointValue;
  }
 /**
  * Method to return the name of an item
  * @return the name of the item
  */
  public String getName()
  {
    return this.name;
  }
  /**
  * Method to return the point value of an item
  * @return the point value of the item
  */
  public int getPointValue()
  {
    return this.pointValue;
  }
}