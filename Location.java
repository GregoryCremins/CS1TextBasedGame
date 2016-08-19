/**
 * @author Gregory Cremins
 * @version 3-28-2012
 * Class to define a location and resolve the text outputs and events that occur at a location.
 */
import java.util.*;
public class Location{
 public String description;
 public int xPosn;
 public int yPosn;
 public boolean exit = false;
 public char roomType = 'v';
 public Item[] roomItems; 
 public ShopItem[] ShopItems;
 
   public Location(int XPOSN, int YPOSN, Item[] roomItems1, char roomType, String description)
  {
    roomItems = roomItems1;
    xPosn = XPOSN;
    yPosn = YPOSN;
    this.roomType = roomType;
    this.description = description;
   }
   public Location(int XPOSN, int YPOSN)
  {
    xPosn = XPOSN;
    yPosn = YPOSN;
    roomItems = new Item[]{}; 
    roomType = 'h';
    description = "A long corridor stretches before you. The lights blink on and off as if someone has damaged the power grid. The only thing that would make this setting more creepy would be ominous music. \nAll of the walls seem damaged. Paint is chipping off of them in random places. Occasionally, you see a dent in the wall.";
   }
  public Location(int XPOSN, int YPOSN, ShopItem[] shopItems1, String description)
  {
    ShopItems = shopItems1;
    xPosn = XPOSN;
    yPosn = YPOSN;
    this.roomType = 's';
    this.description = description;
   }
   
   public Item[] getItemList()
   {
     return roomItems;
   }
    public ShopItem[] getShop()
   {
     return ShopItems;
   }
   public void ownItem(int position)
   {
    roomItems[position].isOwned = true;     
   }
   public void getItems()
   {
     for(Item i: roomItems)
     System.out.println(i.name);
     return;
   }
   public void ownShopItem(int position)
   {
     ShopItems[position].isOwned = true;
   }
   
  public String getDesc(Location[] HallwayLocations, Location[] SpecialLocations)
  {
    //checks the hallway locations
    String temp;
    for(Location loc: HallwayLocations)
    {
      if(loc.xPosn == this.xPosn && loc.yPosn == this.yPosn)
      {
        return description;
      }
    }
    //checks the special event locations
     if(this.xPosn == SpecialLocations[0].xPosn && this.yPosn == SpecialLocations[0].yPosn)
      {
       return description;
      }
      if(this.xPosn == SpecialLocations[1].xPosn && this.yPosn == SpecialLocations[1].yPosn)
      {
        return description;
      }
      if(this.xPosn == SpecialLocations[2].xPosn && this.yPosn == SpecialLocations[2].yPosn)
      {
        return description;
      }
      if(this.xPosn == SpecialLocations[3].xPosn && this.yPosn == SpecialLocations[3].yPosn)
      {
        return description;
      }
      if(this.xPosn == SpecialLocations[4].xPosn && this.yPosn == SpecialLocations[4].yPosn)
      {
        return description;
      }
      if(this.xPosn == SpecialLocations[5].xPosn && this.yPosn == SpecialLocations[5].yPosn)
      {
        return description;
      }
      if(this.xPosn == SpecialLocations[6].xPosn && this.yPosn == SpecialLocations[6].yPosn)
      {
       return description;
      }
      //store is not finished yet
      if(this.xPosn == SpecialLocations[7].xPosn && this.yPosn == SpecialLocations[7].yPosn)
      {
       return description;
      }
      if(this.xPosn == SpecialLocations[8].xPosn && this.yPosn == SpecialLocations[8].yPosn)
      {
        return description;
      }
      if(this.xPosn == SpecialLocations[9].xPosn && this.yPosn == SpecialLocations[9].yPosn)
      {
        return description;
      }
      //otherwise, there is a wall
      else{
        temp = "You bonk your head against the wall. BONK! You think you hear a voice laughing at you.....";
        roomType = 'n';
        return temp;
      }
    }
  /**
   * Method to check if the player has reached the end.
   */
  public boolean checkEnd()
  {
    return exit;
  }
  public char getRoomType()
  {
   return roomType; 
  }
}