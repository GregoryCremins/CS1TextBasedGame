/**
 * @author Gregory Cremins
 * @version 3-28-2012
 * Class GameApp to run the Game
 */

import java.util.*;

public class GameApp{
  public static Location tempLocation;
  static Player p1 = new Player();
  static boolean gameEnd = false;
  static Location currentLoc;
  //create two array of items. some of the items are junk, some are important.
  public static Item[] supplyItems = new Item[] {new Item("Knife", 30), new Item("Can of Soup", 5), new Item("Paint brush", 5), new Item("Mop", 0)};
  public static Item[] keyRoomItems = new Item[]{new Item("Graph", 10), new Item("Pen", 1), new Item("Key", 10), new Item("Picture of Two Guys", 10), new Item("Table of figures", 5)};
  public static Item[] noItems = new Item[]{};
  public static ShopItem[] shopItems = new ShopItem[]{new ShopItem("URL", 40, 50), new ShopItem("Statue", 20, 40), new ShopItem("Shiney Ball", 30, 10)};
//loads the map
  static Map map1 = new Map("J:/TextBasedGame/MAP.jpg");
  //adds all of the possible locations in arrays
  static Location[] SpecialLocations = new Location[] {new Location (4,3, noItems, 'n', "You are in a laboratory with glowing test tubes around you. A naked scientist now lies dead on the floor. You look again at the test tubes and see that they appear to look like you. \nYou notice that there are four doors leading out of the room……"), new Location (1,3, noItems, 'a', "You reach a fork in the road. There are pathways that lead to the north and south. \nAnother guard stands in front of you. He is in full body armor. He stares at you with pure disgust. Does he know that you're not a scientist? He holds what looks like a hallow tube with the letters NYAN on it....."), new Location (8,3, noItems, 'n',  "You notice some blood on the wall. You stare at it and it forms one word. \'YOU\'. Ominous... Below the message is a dead soldier. His chest has been ripped wide open and crimson blood slowly drips from the wound. \nThat would explain the messages. \nThere is a wall to your left and in front of you..."), new Location(6,5, supplyItems, 'w',"You find yourself in a small storage closet. \nThe only way out is the way you came in. \nThere is also a stack of bodies that is in the corner of the room. \nYou cannot remember if you made those because your memory is still fuzzy. There are lots of odds and ends in this room. Mostly janitorial objects."), new Location(6,6, noItems, 'c', "You are still in a dimly lit halway. You hear the sound of footsteps getting closer down the corridor. To the north, you see a door. \'STORAGE\' is the label that is on it."), new Location(4,6, noItems, 'n', "You notice some blood on the wall. You stare at it and it forms one word. \'LOSE\'. Ominous..... Haven't I seen another message like this already? You think silently to yourself.... Your memory is fuzzy, so you cannot remember exactly \nThere is a wall to your left and in front of you..."), new Location (0,1, noItems, 'e', "A steel door is in front of you. It says \'To Exit\'. You rejoice and you realize that there is an exit to this horrible laboratory. There is a keycard slot on the lock of the door. Do you have the key?"), new Location (0,6, shopItems, "You arrive in an odd storage area. An old man appears and waves at you. \nAgainst your better judgement, you hope to make a friend, so you go over to him. He shakes your hand and says:\" Ahh yes, mmmm. Welcome to my shop. I am Admiral Akenbukendukener. \nI scoured all of these containment units and found the best items to sell to you. Of course at a modest fee in DerpDollars. So, here is what we have currently: \""), new Location (3,0, keyRoomItems, 'k', "You enter a small room. In it, there is a table with lots of paperwork and pens on it. They do not appear of any serious value, but you notice that some of them have interesting numbers on them that may be useful if you get out of here \n There is also a key on the table. Who honestly would leave a key lying on a desk? You peek out the window shades and see a guard to your south struggling with a vending machine. \n There are two doors to the room: to the south and east."), new Location (3,1, noItems, 'b', "A guard is trying to use a vending machine with little success. He is punching and kicking it furiously as he yells that he wants his Trolol Bar. \n The vending maching does not oblige even with the consistant pummeling. \n He doesn't seem to take notice of you as you pass by.")};
  static Location[] HallwayLocations = new Location[] {new Location(0,5), new Location(1,1), new Location(1,2), new Location(1,4), new Location(1,5), new Location(1,6), new Location(2,3), new Location(3,3), new Location(4,0), new Location(4,1), new Location(4,2), 
    new Location(4,4), new Location(4,5), new Location(5,3), new Location(5,6), new Location(6,3), new Location(7,3), new Location(7,6), new Location(8,4), new Location(8,5), new Location(8,6)};
  /**
   *Method to run the game
   */
    public static void main(String[] args){
    GameApp.run();
  }
  /**
   * Method that runs the game. Including all of the inputs.
   */
  public static void run()
  {
    //starts with opening text and then loops
    String nextDesc = null;
    Location nextMove = null;
    currentLoc = SpecialLocations[0];
    Scanner sc1 = new Scanner(System.in); 
    String command;
    System.out.println("Welcome to The Game that Started It All..... THE UNKNOWN LABORATORY \n \n \n \n \n");
    System.out.println("You awake on the floor surrounded by gooey mystery fluid. Your body aches as if a syringe was just pulled out of every muscle of your body. \n It is dark. You begin to get up but feel the sting of crunching glass underneath the palms of your hands. You get to your feet and wince as you pull an inch-long piece of glass from your bleeding palm. \n You look around. Around you dozens of glowing tubes faintly illuminate the room.  You go up to one and notice the person inside looks exactly like you. \n Where am I? You ask yourself silently as you look around. A body of a scientist lay crumpled up on the floor. You read the tag. Instead of an ID, a message has been placed in there. (Type t for the message) \n You add the note to your inventory. You notice that there is no blood on the scientist. His neck is twisted the wrong direction. \n You decide to take his clothing to blend in. You feel something soft in his pocket. You reach in and find a map to the facility you are currently in (Type m to see map). \n Time to get moving before people notice the body.");
    System.out.println(currentLoc.getDesc(HallwayLocations, SpecialLocations));
    while(gameEnd != true)
    {
     command = sc1.nextLine();
     boolean flag = false;
     if(command.compareTo("n") == 0)
     {
      nextMove = findLocation(currentLoc.xPosn, currentLoc.yPosn - 1);
      nextDesc = nextMove.getDesc(HallwayLocations, SpecialLocations);   
      System.out.println(nextDesc);
      flag = true;
     }
     if(command.compareTo("s") == 0)
     {
     nextMove = findLocation(currentLoc.xPosn, currentLoc.yPosn + 1);
      nextDesc = nextMove.getDesc(HallwayLocations, SpecialLocations);      
      System.out.println(nextDesc);
      flag = true;
     }
      if(command.compareTo("e") == 0)
     {
      nextMove = findLocation(currentLoc.xPosn + 1, currentLoc.yPosn);
      nextDesc = nextMove.getDesc(HallwayLocations, SpecialLocations);
      System.out.println(nextDesc);
      flag = true;
     }
      if(command.compareTo("w") == 0)
     {
      nextMove = findLocation(currentLoc.xPosn - 1, currentLoc.yPosn);
      nextDesc = nextMove.getDesc(HallwayLocations, SpecialLocations);      
      System.out.println(nextDesc);
      flag = true;
     }
      if(command.compareTo("q") ==0)
      {
       System.out.println("You scream at the top of your lungs: HEEEEELP! Dozens of men in armor with NYAN launchers come in and surround you. A voice says: \"Oh come now, I thought you would make it this time....\" \n GAME OVER");
       break;
      } 
       if(command.compareTo("m") ==0)
      {
       System.out.println("You take a look at the map.");
       map1.show();
      flag = true;
      }
      if(command.compareTo("j") ==0)
      {
       System.out.println("The message is scribbled in ink and is barely legible. A few words have been crossed out. This is what you can make out: \n \n Escape while you can.\n They are watching us.\n I believe you can break the cycle.\n If you don’t have a weapon, run.\n If you don’t want to play anymore, simply yell “help”.\n I have already escaped.\n Find the key.\n If your brother comes....\n Running out of time.\n Don’t....\n Win……");
       flag = true;
      }
      if(nextDesc!= null && nextMove != null && nextDesc.compareTo("You bonk your head against the wall. BONK! You think you hear a voice laughing at you.....") != 0)
      {
       resolveEvent(nextMove, p1, sc1);
       nextMove = getSpecialLocation(nextMove);
       currentLoc = nextMove; 
       flag = true;
       p1.steps++; 
        if(currentLoc.getRoomType() == 'a' || currentLoc.getRoomType() == 'b')
       command = sc1.nextLine();
      }
      
      if(currentLoc.getRoomType() == 's')
      { boolean leaving = false;
        while(leaving == false)
        {
          leaving = shop(currentLoc, sc1, p1);
        }
        command = sc1.nextLine();
      }
      if(command.compareTo("h") == 0)
      {
        System.out.println("Use n,s,w,e for directionss, m for map, j for note, t for take, h for help, r for repeat, i for inventory, or q to quit.");
        flag = true;
      }
      if(command.compareTo("r") == 0)
      {
        System.out.println(currentLoc.getDesc(HallwayLocations, SpecialLocations));
           flag = true;
      }
      if(command.compareTo("t") == 0)
      {
        take(currentLoc, sc1, p1);
       flag = true; 
      }
      if(command.compareTo("i") == 0)
      {
        p1.displayInventory();
      }
      if(flag != true)
      {
        System.out.println("Unknown command. Try using n,s,w,e for directionss, m for map, j for note, t for take, h for help, r for repeat, i for inventory, or q to quit.");
      }
      
      if(currentLoc.checkEnd())
        break;
    }
 return;
  }
  
  
  /**
   *Method to take objects at a given location
   * @param location the current location
   * @param sc the current scanner being used
   * @param p1 the current player
   */
  public static void take(Location location, Scanner sc, Player p1)
  {
    //gets the array of items
    Item[] roomItems = location.getItemList();
      if(roomItems.length == 0)
      {
        System.out.println("There is nothing for you to take in this room.");
        return;
      }
      //lists the things that are still up for grabs
      System.out.println("Here are the things that you could take away from this room: ");
    for(int i = 0; i < roomItems.length; i++)
    { if(roomItems[i].isOwned == false)
      System.out.println((i + 1) + ") A " + roomItems[i].name);
    else
      System.out.println();
    }
    System.out.println("Which one would you like? Use corresponding numbers to answer, or 0 to quit");
    int choice = sc.nextInt();
    if(choice <= 0 || roomItems[choice - 1].isOwned || choice >= 5)
    {
      System.out.println("You decide to take nothing.");
      return;
    }
    //player has 5 junk spots. They can fill those with useless items that are worth a few points. if it's full, you can't take on any more junk.
    if(p1.numJunk >= 5)
    {
      System.out.println("You have too much useless junk already.");
      return;
    }
    //if its a special item, it goes to the player's items list
    for(int j = 0; j < p1.items.length; j++)
    {
     if(p1.items[j].name.compareTo(roomItems[choice - 1].name) == 0) 
     {
       System.out.println("You take the " + roomItems[choice - 1].name + ".");
       p1.items[j].isOwned = true;
       location.ownItem(choice - 1);
       return;
     }
    }
    //otherwise it goes to their junk list.
    System.out.println("You take the " + roomItems[choice - 1].name + ".");
    p1.junk[p1.numJunk] = roomItems[choice - 1];
    p1.junk[p1.numJunk].isOwned = true;
    p1.numJunk++;
    location.ownItem(choice - 1);
    return;
  }
  
  /**
   * Method for the shop. The user will remain at the shop until they quit. It will loop using the boolean return.
   * @param location, the current location of the shop, this is used because it has an array of shop items
   * @param sc the current scanner being used
   * @param p1 the current player
   */
  
   public static boolean shop(Location location, Scanner sc, Player p1)
  { 
    //gets the array of items
    ShopItem[] shopItems = location.getShop();
      if(shopItems.length == 0)
      {
        System.out.println("\"There is nothing for you to buy. YOU CLEANED ME OUT YOU YOUNG WIPPERSNAPPER!\"");
      }
      //lists the items that are for sale
      System.out.println("0) Leave.");
    for(int i = 0; i < shopItems.length; i++)
    { if(shopItems[i].isOwned == false)
      System.out.println((i + 1) + ") A " + shopItems[i].name + ". Price: " + + shopItems[i].getPrice() + ".");
    else
      System.out.println();
    }
    System.out.println("\"What would you like?\" The man says grinning. You realize he is missing many of his teeth.");
    int choice = sc.nextInt();
    //first checks if they want to leave
      if(choice <= 0 || choice >= 4 )
    {
      System.out.println("\"Come back again soon my friend!\"");
      return true;
    }
      //then checks if they have enough money
    if(p1.getCoins() < shopItems[choice - 1].getPrice())
    {
      System.out.println("\"Oh sorry, you don't have enough money my friend\"");
      return false;
    }
    //then makes sure they made the right choice
    if(shopItems[choice - 1].isOwned)
    {
     System.out.println("\"We are out of stock in that.\"");
     return false;
    }
    //player has 5 junk spots. They can fill those with useless items that are worth a few points. if it's full, you can't take on any more junk.
    if(p1.numJunk >= 5)
    {
      System.out.println("\" Looks like your out of inventory space, I cannot take money from you knowing that you can't carry the item.\"");
      return false;
    }
    //if its a special item, it goes to the player's items list
    for(int j = 0; j < p1.items.length; j++)
    {
     if(p1.items[j].name.compareTo(shopItems[choice - 1].name) == 0 && p1.getCoins() > shopItems[choice - 1].getPrice()) 
     {
       System.out.println("\" Ahh yes! The" + shopItems[choice - 1].name + ". Excellent choice\"");
       p1.items[j].isOwned = true;
       location.ownShopItem(choice - 1);
       p1.subCoins(shopItems[choice - 1].getPrice());
       return false;
     }
    }
    //otherwise it goes to their junk list.
    System.out.println("\" Ahh yes! The" + shopItems[choice - 1].name + ". Excellent choice\"");
    p1.junk[p1.numJunk] = shopItems[choice - 1];
    p1.junk[p1.numJunk].isOwned = true;
    p1.numJunk++;
    location.ownShopItem(choice - 1);
    p1.subCoins(shopItems[choice - 1].getPrice());
    return false;
  }
   
   
   /**
   * Method to set a special location to the current location. I realized I needed this when in the code, I was making new locations for each step and each location has a specific array of items.
   * Using this, it will keep track of the items at given locations.
   * @param loc the current location
   * @return the specific location that the player is at including the array of items if necessary.
   */
  public static Location getSpecialLocation(Location loc)
  {
    for(Location comploc: SpecialLocations)
    {
     if(comploc.xPosn == loc.xPosn && comploc.yPosn == loc.yPosn)
     {
       return comploc;
    }
  }
    return loc;
}
  
  /**
   * Method to resolve any event on a given location
   * @param location the location of the event
   * @param player the current player
   * @param sc the current scanner
   */
  public static void resolveEvent(Location location, Player player, Scanner sc)
  {
    char roomType = location.getRoomType();
    switch (roomType){
      case 'h':
      {
        Random r = new Random();
        int money = r.nextInt(20);
        if(money == 5 && player.numb_Coins < 100)
        {
          player.numb_Coins+= 5;
         System.out.println("You find 5 derp dollars on the floor crumpled up in a ball. It is as if someone wanted you to find this money....");
        break;
        }
         if(money == 10 && player.numb_Coins < 100)
        {
          player.numb_Coins+= 10;
         System.out.println("You find 10 derp dollars on the floor crumpled up in a ball. You feel as if someone is setting you up for something.....");
        }
        if(money != 5 && money != 10)
          System.out.println("There does not appear to be anything special about this hallway.");
         break;
     }  
      case 'k':
      {
        break;
      }
       case 'e':
      {
       if(player.items[2].isOwned)
       {
        System.out.println("You use the key and push your way through the door, expecting relief, but instead you are greeted with 100 armed soldiers with their guns pointed right at you. A single person is clapping in the room.\n\"Good, good. You will do just fine. \" He says in a mocking tone.\nYou realize only now what the message meant. You were never supposed to win. Losing was your only options. The men take you away screaming as the man who clapped now laughs meniacally.\nTo be continued....\n\n http://dl.dropbox.com/u/60900894/YOU%20WILL%20LOSE%20DIS%20GAME%21%20internetz1.html"); 
         location.exit = true;
         player.getScore();
         
       break;
       }
       else
        System.out.println("You bang on the door and furiously try to open it with no success. Perhaps you are missing something...");
       break;
       }
       case 'w':
      {
       break;
       }
      case 's':
      {
          
          break;
      }
        case 'c':
      {
        if(player.items[0].isOwned)
        {
          System.out.println("Guards are rushing around everywhere as you go near the closet. One of them stops you and asks for your ID. You instead cut his breathing tube and he goes limp. You stealthly hide the body in the closet.");
        }
        break;
      }
      //resolves the battle. if you have a knife, you get an additional option.
     case 'a':
      {
       System.out.print("He is comming towards you, his gun is raised. Uh-oh. Your options are (Use numbers): \n1) Sneak past. \n");
       if(player.items[0].isOwned)
       {
       System.out.println("2) Fight.");
       }
       boolean r = false;
       while(r != true)
       {int action = sc.nextInt();
                          
                           if(action == 1)
                            {
                              System.out.println("He comes over to you and asks for your ID. You tell him that you lost it during the chaos. Suprisingly, he believes you. He tells you to get moving.");
                              r = true;
                              break;
                            }
                            if(action == 2 && player.items[0].isOwned){
                              System.out.println("He approaches you. You feint to the left and cut a breathing tube that is hooked up to his backpack. Foul smelling gas billows out of it as the soldier struggles for breath. He struggles for a second and goes limp.\n The gun of his is unfortunately damaged from the tumult, however the ammo is interesting to you, so you decide to pick some up. \n NYAN Ammo added to inventory to be studied later perhaps.");  
                              player.items[1].isOwned = true;
                              r = true;
                              break;
                              }
                             if(action == 2 && !player.items[0].isOwned){
                              {
                              System.out.println("Uhhhh, you don't have that option. Better find a better one because he is coming closer.");
                             break;
                              }
                             }
                            else
                            {
                            System.out.println("Uhhhh, you don't have that option. Better find a better one because he is coming closer.");
                            break;
                            }
                          }
       break;
     }
      //resolves the battle. if you have a knife, you get an additional option
      case 'b':
      {
       System.out.print("He doesn't appear to notice you. It would probably benifit you to take this guy out. Your options are (Use numbers): \n1) Sneak past. \n");
       if(player.items[0].isOwned)
       {
       System.out.println("2) Fight.");
       }
       boolean r = false;
       while(r != true)
       {int action = sc.nextInt();
                          
                           if(action == 1)
                            {
                              System.out.println("You walk past him as he still bangs at the machine. You muffle a laugh as you walk past");
                              r = true;
                              break;
                            }
                            if(action == 2 && player.items[0].isOwned){
                              System.out.println("You walk up to him and cut his breathing tube. Gas rushes out as he struggles for air. He goes limp within seconds. You loot his body and figure out he has 10 Derp Dollars on him. Sweet!");  
                              player.numb_Coins += 10;
                              r = true;
                              break;
                              }
                             if(action == 2 && !player.items[0].isOwned){
                              {
                              System.out.println("You do not have that option.");
                             break;
                              }
                             }
                            else
                            {
                            System.out.println("You dont have that option.");
                            break;
                            }
                          }
     }
    
      default:
        System.out.println("There does not appear to be anything special with this room.");
        break;
    
  }
  }
  /**
   * Method to match up the current location with the location the player is at
   * @param xPosn the current xposition
   * @param yPosn the current y position
   */
  public static Location findLocation(int xPosn, int yPosn)
  {
       //checks the hallway locations
    String temp;
    for(Location loc: HallwayLocations)
    {
      if(loc.xPosn == xPosn && loc.yPosn == yPosn)
      {
        return loc;
      }
    }
    //checks the special event locations
    for(Location loc2: SpecialLocations)
    {
     if(loc2.xPosn == xPosn && loc2.yPosn == yPosn)
      {
        return loc2;
      } 
    }
      //otherwise, there is a wall
       Location wall = new Location(xPosn, yPosn, noItems, 'n', "You bonk your head against the wall. BONK! You think you hear a voice laughing at you.....");
       return wall;    
  }
}