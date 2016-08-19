/**
 * @author Gregory Cremins
 * @version 3-28-2012
 * Class to define a ShopItem with a few values.
 */
public class ShopItem extends Item{
 public int price;
 
 public ShopItem(String name, int pointValue, int price)
 {
   super(name, pointValue);
  this.price = price; 
 }
  /**
   * Method to get the price of a ShopItem
   * @return the price of the item
   */
  public int getPrice()
  {
    return price;
  }
}