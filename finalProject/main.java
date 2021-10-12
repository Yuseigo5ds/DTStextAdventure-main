/**
 * Main file for final project
 * This file has the "parser" and most important bits
 * @Dan Joshwa
 * @6/9/2021
 * Work left to do
 * Write dialogue and descriptions (lots of this, should be prioritized)
 * Implement changing dialogue for senior grad requirements
 * Implement chromebook use for capstone project if you want
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class main
{
    //important variables
    public static int playerLocation = 0;
    public static String playerName;
    public static int grade = 0;
    public static String []s;
    public static boolean winCondition = false;//win con is probably gonna be changed
    public static void main(String[] args)
    {
        npcs n = new npcs();
        locations l = new locations();
        items i = new items();
        images images = new images();
        musicPlayer musicPlayer = new musicPlayer();

        boolean run = true;
        //System.out.println(l.locations[0]);
        //Introduction
        Scanner userInput = new Scanner(System.in);
        images.dtsLogo();
        System.out.println("The Downtown School: A Lakeside School: The Text Adventure");
        System.out.println("By Dan Joshwa\n2019\n");
        boolean gradeNotDecided = true;
        System.out.println("What is your name? ");
        playerName = userInput.nextLine();
        System.out.println("Welcome " + playerName);
        while (gradeNotDecided)
        {
            System.out.println("What grade are you in (9-12)");
            String gradeInput = userInput.nextLine();
			if (gradeInput.equals("9"))//set the grade
            {
                grade = 9;
                images.printGrade(grade);
                gradeNotDecided = false;
            }
            else if (gradeInput.equals("10"))
            {
                grade = 10;
                images.printGrade(grade);
                gradeNotDecided = false;
            }
            else if (gradeInput.equals("11"))
            {
                grade = 11;
                images.printGrade(grade);
                gradeNotDecided = false;
            }
            else if (gradeInput.equals("12"))
            {
                grade = 12;
                images.printGrade(grade);
                gradeNotDecided = false;
            }
            else
            {
                System.out.println("Make sure to enter a valid grade");
            }
        }
        System.out.println("You are now in The Downtown School");
        //need real instructions to go here
        System.out.println("You are a student at the Downtown School. You may move around the different classrooms by " +
                "using the command 'goto' followed by the classroom you want to visit. If you are confused about where " +
                "you can go, use the 'map' command. Try to use 'talk to [name]'. You can talk to anyone at the school, " +
                "including teachers and students. Even if you don't see a student, try talking to them. The teachers have " +
                "a lot to say so you should probably talk to them multiple times " +
                "You may also 'take' and 'drop'. Be sure to check your schedule with the " +
                "'schedule' command. This will tell you what class you have now and next period. If you want to see the " +
                "list of commands you can use, just type 'help'. Enjoy the game, and if you ever want to stop playing just " +
                "type 'stop the pain' \nMusic credit to Led Zepplin and larzgallows for the solo backing track\nGuitar solo played by Dan Joshwa");
        System.out.println();
        describeRoom();
        //main game loop
        while(run)
        {
            System.out.print(playerName + ": ");
            String []s = userInput.nextLine().split(" ");
            /*
             * This is how the parser works
             * The array above, holds the user input split at each word
             * the if statements below look at each word
             */
            if (s[0].equalsIgnoreCase("help"))//full instructions for the game as well as list of available locations
            {
                System.out.println("You are a student at the Downtown School. You may move around the different classrooms by " +
                        "using the command 'goto' followed by the classroom you want to visit. If you are confused about where " +
                        "you can go, use the 'map' command. Try to use 'talk to [name]'. You can talk to anyone at the school, " +
                        "including teachers and students. Even if you don't see a student, try talking to them. The teachers have " +
                        "a lot to say so you should probably talk to them multiple times " +
                        "You may also 'take' and 'drop'. Be sure to check your schedule with the " +
                        "'schedule' command. This will tell you what class you have now and next period. If you want to see the " +
                        "list of commands you can use, just type 'help'. Enjoy the game, and if you ever want to stop playing just " +
                        "type 'stop the pain'");
                System.out.println("List of Commands:");
                System.out.println("help\nmap\nschedule\ninventory\ngoto [location name]\nlook\ntake [item name]\n" +
                        "take all\ndrop [item name]\ntalk to [character name]\n(You don't need to include brackets)");
                System.out.println();
                System.out.println("You may go to these locations:");
                for (int j = 0; j < l.locations.length; j++)
                {
                    System.out.println(l.locations[j]);
                }
                System.out.println("");
                System.out.println("You may also take/drop items and look at your inventory as well as talk to teachers");
                System.out.println("");
            }
            else if (s[0].equalsIgnoreCase("map"))//shows the visual map and a reminder of goto
            {
                images.map();
                System.out.println();
                System.out.println("Don't forget that you can go anywhere just by saying 'goto [location]'");
                System.out.println("And if you forgot where you are, just type 'look'");
            }
            else if (s[0].equalsIgnoreCase("schedule"))
            {
                l.schoolTime();//displays current and next class in schedule
            }
            else if (s[0].equalsIgnoreCase("inventory") || s[0].equalsIgnoreCase("i") && s.length == 1)
            {
                System.out.println("");
                System.out.println(playerName + "'s inventory:");
                for (int j = 0; j < i.itemsOwned.length; j++)//traverse throught the items owned array
                {
                    if (i.itemsOwned[j] == true)//and if the program owns the item
                    {
                        System.out.println(i.items[j]);//print the item name
                    }
                }
                System.out.println("");
            }
            else if (s[0].equalsIgnoreCase("goto"))//code for moving around
            {
                String destination = "";//make the second and third words the user's requested destination
                //gonna have to add the "the" feature in later
                if (s.length == 1)//if the s array has 1 words
                {
                    System.out.println("please specify where you would like to go");
                }
                else if  (s.length == 2)
                {
                    destination = s[1];
                }
                else if (s.length == 3)
                {
                    destination = s[1] + " " + s[2];
                }
                else if (s.length == 4)//if the s array has 4 words
                {
                    destination = s[1] + " " + s[2] + " " + s[3];//the requested destination has 3 (as first is goto)
                }
                else if (s.length == 5)//now max size for a location name is 4 words
                {
                    destination = s[1] + " " + s[2] + " " + s[3] + " " + s[4];
                }
                move(destination, s.length);//send destination and s.length to the function
            }
            //another game breaking bug if you just type go
            else if(s[0].equalsIgnoreCase("go") && s.length == 1)
            {
                System.out.println("Don't forget that you need to type goto [location] if you want to go somewhere");
            }
            else if (s[0].equalsIgnoreCase("go") && s[1].equalsIgnoreCase("to"))//code for moving around
            {
                String destination = "";//make the second and third words the user's requested destination

                if (s.length == 2)//if the s array has 1 words
                {
                    System.out.println("please specify where you would like to go");
                }
                else if  (s.length == 3)
                {
                    destination = s[2];
                }
                else if (s.length == 4)
                {
                    destination = s[2] + " " + s[3];
                }
                else if (s.length == 5)//if the s array has 4 words
                {
                    destination = s[2] + " " + s[3] + " " + s[4];//the requested destination has 3 (as first is goto)
                }
                else if (s.length == 6)//now max size for a location name is 4 words
                {
                    destination = s[2] + " " + s[3] + " " + s[4] + " " + s[5];
                }
                move(destination, s.length);//send destination and s.length to the function
            }
            else if (s[0].equalsIgnoreCase("observe") || s[0].equalsIgnoreCase("look"))//code for look around
            {
                describeRoom();
            }
            else if (s[0].equalsIgnoreCase("look") && s[1].equalsIgnoreCase("around"))//also code for looking around
            {
                describeRoom();
            }
            else if (s[0].equalsIgnoreCase("take"))
            {
                int requestedItem = 0;
                int itemExist = 0;
                //bug where if you just type take you get an out of bounds error
				//so you need to add a condition if there is no s[1]
				if(s.length == 1)//if "take" is the only word in input
				{
					System.out.println("Please specify what you want to take or you can 'take all'");
				}
				else if (s.length == 2 && s[1].equalsIgnoreCase("the"))//if the second word is the but there is no third word
                {
                    System.out.println("Please specify what you want to take or you can 'take all'");//don't break the game
                }
				else//otherwise run as normal
				{
					if (s[1].equalsIgnoreCase("all"))//if the user is asking to take all of the items in the room
					{
						ArrayList<Integer> visibleItems = new ArrayList<>();//this arraylist will hold the addresses for all items in the room
                        int numItems = 0;
						for (int t = 0; t < i.items.length; t++)//traverse items array
						{
							if (i.itemLocation[t] == playerLocation)//if the selected item has the same location as the player
							{
								visibleItems.add(t);//add that item's address to the arraylist
                                numItems++;
							}
						}
						if(numItems == 0)
                        {
                            System.out.println("There was nothing in the room to take");
                        }
						//System.out.println(visibleItems);//used for troubleshooting
						for (int u = 0; u < visibleItems.size(); u++)//traverse the visibleItems arraylist
						{
							System.out.println("You take the " + i.items[visibleItems.get(u)]);
							i.itemsOwned[visibleItems.get(u)] = true;
							i.itemLocation[visibleItems.get(u)] = 50;
						}
						visibleItems.clear();//clear the arraylist so it's reset
					}
					else//or if the user is asking to take a specific item
					{
                        String itemName = "";
					    if (s[1].equalsIgnoreCase("the") && s.length > 2)//if the second word is the
                        {
                            for (int z = 2; z < s.length; z++)//ignore it
                            {
                                itemName += s[z];
                                if(s.length > 2 && z != s.length - 1)
                                {
                                    itemName += " ";
                                }
                            }
                        }
					    else//otherwise act normally and go through the array to set the itemName
					    {
                            for (int z = 1; z < s.length; z++)
                            {
                                itemName += s[z];
                                if (s.length > 2 && z != s.length - 1)
                                {
                                    itemName += " ";
                                }
                            }
                        }
					    //System.out.println(itemName + ".");//for troubleshooting
						//first what needs to happen is we look through the names array and id what address is requested
						for (int t = 0; t < i.items.length; t++)//traverse the item name array
						{
							if (itemName.equalsIgnoreCase(i.items[t]))//if the input equals a name in the names array
							{
								requestedItem = t;//save the item address
							}
							else 
							{
								itemExist++;//otherwise keep going
							}
						}
						if (itemExist == i.items.length)
						{
							System.out.println("There is simply nothing that goes by that name nearby");
						}
						else
						{
							if (i.itemLocation[requestedItem] == playerLocation)
							{
								System.out.println("You take the " + i.items[requestedItem]);
								i.itemsOwned[requestedItem] = true;//change the itemOwned array
								i.itemLocation[requestedItem] = 50;//change the itemLocation array
								//System.out.println(i.itemLocation[requestedItem]);//used for troubleshooting
							}
							else if (i.itemLocation[requestedItem] == playerLocation + 60)//for hidden items
                            {
                                System.out.println("You found a hidden " + i.items[requestedItem]);
                                if(i.items[requestedItem].equalsIgnoreCase("Essay"))//if the item is the essay
                                {
                                    n.npcResponses[2][2][0] = "Thanks for getting your essay to me.";//change Brian's responses
                                    n.npcResponses[2][2][1] = "Thanks for getting your essay to me.";
                                    n.npcResponses[2][2][2] = "Thanks for getting your essay to me.";
                                }
                                //you probably need simlar if statements for the senior year npcs
                                i.itemsOwned[requestedItem] = true;//set the arrays so the character owns the item
                                i.itemLocation[requestedItem] = 50;
                            }
							else if (i.itemLocation[requestedItem] == 50)//if you have the item
							{
								System.out.println("You already have the " + i.items[requestedItem]);
							}
							else//if the item exists but is in a different room
							{
								System.out.println("You look around and you can't seem to find the " + i.items[requestedItem]);
							}
						}
						System.out.println("");
					}
				}
			}
			
                /*for (int u = 0; u < i.itemLocation.length; u++)//used for troubleshooting
                {
                System.out.println(i.itemLocation[u]);
                }*/
        
            else if (s[0].equalsIgnoreCase("drop"))//very similar to take
            {
                int requestedItem = 0;
                int itemExist = 0;
                //first what needs to happen is we look through the names array and id what address is requested
				if(s.length == 1)
				{
					System.out.println("Please specify what you want to drop (you cannot drop all)");
				}
				else if(s.length == 2 && s[1].equalsIgnoreCase("the"))
                {
                    System.out.println("Please specify what you want to drop (you cannot drop all)");
                }
				else
				{
				    //implement "the" recognition
                    String itemName = "";
                    if(s[1].equalsIgnoreCase("the") && s.length > 2)//if the second word is the and the isn't the last word
                    {
                        for (int z = 2; z < s.length; z++)//build the itemName string ignoring the
                        {
                            itemName += s[z];
                            if(s.length > 2 && z != s.length - 1)
                            {
                                itemName += " ";
                            }
                        }
                    }
                    else //otherwise, just build the itemName string normally
                    {
                        for (int z = 1; z < s.length; z++) {
                            itemName += s[z];
                            if (s.length > 2 && z != s.length - 1) {
                                itemName += " ";
                            }
                        }
                    }
					for (int t = 0; t < i.items.length; t++)//traverse the item name array
					{
						if (itemName.equalsIgnoreCase(i.items[t]))//if the input equals a name in the names array
						{
							requestedItem = t;
						}
						else 
						{
							itemExist++;
						}
					}
					if (itemExist == i.items.length)
					{
						System.out.println("You don't have anything that goes by that name");
					}
					else
					{
						System.out.println("You drop the " + i.items[requestedItem]);
						i.itemsOwned[requestedItem] = false;//change the itemOwned array
						i.itemLocation[requestedItem] = playerLocation;//change the itemLocation array
					}
					System.out.println("");
				}
            }
			//you need a what if input is just talk
            else if (s[0].equalsIgnoreCase("talk"))//this is similar to talking to npcs in something like a pokemon game
            {
                if(s.length == 1)
                {
                    System.out.println("Don't just talk to yourself, who do you want to 'talk to'?");
                }
                else if(s.length == 2)
                {
                    System.out.println("Who do you want to talk to?");
                }
                else {
                    //System.out.println(n.npcNames
                    int requestedNPC = 0;//this int will become the array address for the NPC you want to talk to
                    int npcExist = 0;//this int checks if the requested name actually exists
                    for (int t = 0; t < n.npcNames.length; t++)//traverses npcNames array
                    {
                        if (s[2].equalsIgnoreCase(n.npcNames[t]))//if the input equals a name in the names array
                        {
                            requestedNPC = t;//save the address
                        } else
                        {
                            npcExist++;//otherwise add to this int
                        }
                    }
                    if (npcExist == n.npcNames.length)//if the requested name doesn't exist
                    {//integrate random npc responses
                        Random rand = new Random();//create a random object
                        System.out.println("You talk to " + s[2]);
                        System.out.print(s[2] + " says "); //print out a random response from the list of responses
                        System.out.println(npcs.randomResponses[rand.nextInt(npcs.randomResponses.length)]);
                    }
                    else//otherwise
                    {
                        if (n.npcLocations[requestedNPC][grade - 9] == playerLocation)//if the npc is in the same room as the player
                        {
                            if(n.npcResponses[requestedNPC][grade - 9] == null)//if the npc wasn't at dts
                            {
                                System.out.println(n.npcNames[requestedNPC] + " isn't at DTS this year");
                            }
                            else//say the appropriate line for that npc and year
                            {
                                if(requestedNPC != 10) //if you're not talking to Dan
                                {
                                    System.out.println("You talk to " + n.npcNames[requestedNPC]);
                                    System.out.println(n.npcNames[requestedNPC] + " says " +
                                            n.npcResponses[requestedNPC][grade - 9][n.responseSaid[requestedNPC][grade - 9]]);
                                }
                                //specific situations for the exit tickets
                                if(requestedNPC == 5 && grade == 9 && n.responseSaid[5][0] == 2
                                && items.algebraCompleted == false)//if it's time to take the math test
                                {
                                    i.algebraTest();
                                }
                                if(requestedNPC == 0 && grade == 10 && n.responseSaid[0][1] == 2
                                && items.courtCompleted == false)
                                {
                                    i.courtQuestion();
                                }
                                //if statement for the guitar sidequest
                                if(requestedNPC == 10)
                                {
                                    danGuitar();
                                }
                                //npcResponses is now a 3d array, [right npc][right grade][in order of which responses were already said]
                                if (n.responseSaid[requestedNPC][grade - 9] < n.numResponses)//if
                                {
                                    n.responseSaid[requestedNPC][grade - 9]++;
                                }
                                //add more if staetments here for exit ticket information/puzzles as you talk to the
                                //teachers
                            }
                        } else//otherwise (npc exists but is in a different room)
                        {
                            System.out.println("You look around and realize that " + n.npcNames[requestedNPC] + " is not in " + l.locations[playerLocation]);//say that the npc isn't in the same room as you
                        }
                    }
                }
            }
            else if (s[0].equalsIgnoreCase("endgame"))
            {
                System.out.println("[insert endgame spoiler here]");                
            }
            else if (s[0].equalsIgnoreCase("whoami"))
            {
                System.out.println("geez, why don't you know who you are. Even I know that you're " + playerName);
            }
            else if (s[0].equalsIgnoreCase("quit"))
            {
                System.out.println("Thank you for playing");
                break;
            }
            else if (s[0].equalsIgnoreCase("stop") && s[1].equalsIgnoreCase("the") && s[2].equalsIgnoreCase("pain"))
            {
                System.out.println("Geez, you didn't have to be so harsh");//was this funny in 10th grade
                break;
            }
            else//in the case the user asks for something that isn't in the parser
            {
                System.out.println("You think for a second and realize that you don't understand what you're saying to yourself");
            }
            System.out.println("");
        }
    }

    public static void describeRoom()
    {
        locations l = new locations();
        items i = new items();
        npcs n = new npcs();
        System.out.println("You are in " + l.locations[playerLocation]);
        System.out.println(l.locDescriptions[playerLocation]);

        ArrayList<Integer> visibleItems = new ArrayList<>();//this arraylist will hold the addresses for all items in the room
        for (int t = 0; t < i.items.length; t++)//traverse items array
        {
            if (i.itemLocation[t] == playerLocation)//if the selected item has the same location as the player
            {
                //System.out.println(i.itemLocation[t]);//used for troubleshooting
                visibleItems.add(t);//add that item's address to the arraylist
            }
        }
        if (visibleItems.size() > 0)//if there is anything in the visibleItems arraylist
        {
            System.out.print("You can see a(n) ");//actually say this text
        }
        for (int u = 0; u < visibleItems.size(); u++)//traverse the visibleItems arraylist
        {
            if (u == visibleItems.size() - 2)//if statements so lists have proper grammar
            {
                System.out.print(i.items[visibleItems.get(u)] + ", and a(n) ");    
            }
            else if (u == visibleItems.size() - 1)
            {
                System.out.println(i.items[visibleItems.get(u)]);
            }
            else
            {
                System.out.print(i.items[visibleItems.get(u)] + ", ");
            }
            //System.out.print(i.itemLocation[visibleItems.get(u)]);//used for troubleshooting
        }
        visibleItems.clear();
        for (int v = 0; v < n.npcLocations.length; v++)
        {
            if (n.npcLocations[v][grade - 9] == playerLocation)
            {
                System.out.print("You can see ");
                System.out.print(n.npcNames[v]);
                System.out.println(" here");
            }
        }
        //System.out.println("");
    }

    public static void move(String destination, int inputLength)
    {
        locations l = new locations();
        int locExist = 0;
        boolean placeFound = false;//used so we don't check the altnames array if the main array works

        for (int j = 0; j < l.locations.length; j++)//traverse locations array
        {//there has to be a way to only allow to move to specific areas
            if (destination.equalsIgnoreCase(l.locations[j]))//if the requested destination is equal to a location
            {
                placeFound = true;
                if (j != playerLocation)//and the program isn't already there 
                {
                    playerLocation = j;//move the program
                    describeRoom();
                    if(l.period < l.findNumClasses(grade))
                    {
                        if (j == l.schedule[grade - 9][l.period])//if the player is in the right class
                        {
                            l.period++;//increase the period (this can move somewhere else if exit tickets exist)
                            //l.schoolTime();
                        }
                    }
                }
                else//otherwise
                {
                    System.out.println("You are already there");//the program should already be there
                }
            }
            else
            {
                locExist++;//every time the destination is not the name of a location this var increases by one
            }
        }//after traversing
        //try again but with the alternate names array
        if(placeFound == false)
        {
            locExist = 0;
            for (int k = 0; k < l.altNames.length; k++)//traverse locations array
            {//there has to be a way to only allow to move to specific areas
                if (destination.equalsIgnoreCase(l.altNames[k]))//if the requested destination is equal to a location (in the altNames array)
                {
                    if (k != playerLocation)//and the program isn't already there
                    {
                        playerLocation = k;//move the program
                        describeRoom();
                        if (l.period < l.findNumClasses(grade))
                        {
                            if (k == l.schedule[grade - 9][l.period])//if the player is in the right class
                            {
                                l.period++;//increase the period (this can move somewhere else if exit tickets exist)
                                //l.schoolTime();
                            }
                        }
                    }
                    else//otherwise
                    {
                        System.out.println("You are already there");//the program should already be there
                    }
                }
                else
                {
                    locExist++;//every time the destination is not the name of a location this var increases by one
                }
            }//after traversing
        }

        //if there is no location doesn't exist and the user inputed more than just goto
        if (locExist == l.locations.length && inputLength > 1)
        {
            System.out.println("There is no such place in The Downtown School");
            locExist = 0;
        }
        else
        {
            locExist = 0;
        }
        placeFound = false;
    }

    static boolean guitarTaken = false;//whether Dan has the guitar
    public static void danGuitar()//runs when user talks to dan
    {
        if(items.itemLocation[9] == 50)//if the guitar is in player's inventory
        {//implement music player here
            System.out.println("Dan says Thanks a ton, now I can go on stage and play it without any invitation or context");
            items.itemLocation[9] = 100;//can't take the guitar back, music is always playing now
            items.itemsOwned[9] = false;
            guitarTaken = true;
            musicPlayer.playMusic("stairwaySolo.wav");//play music
        }
        else//if the guitar isn't in player's inventory
        {
            if (guitarTaken == true)//but Dan has the guitar
            {
                System.out.println("Dan says Thanks again for finding my guitar " + playerName);
            }
            else//if no one has the guitar
            {
                System.out.println("Dan says Hey, I need to get my guitar, can you help me find it? " +
                        "I have a terrible memory so I don't remember where I left it. Try some of the " +
                        "classrooms");
            }
        }
    }
/* original win copndition is no longer required
    public static void changeBrian()
    {
        items i = new items();
        npcs n = new npcs();
        if (i.itemsOwned[6] == true)
        {
            n.npcResponses[2] = "You got essay, great. Now I can grade it";
            winCondition = true;
        }
        else
        {
            winCondition = false;
        }
    }
    
    public static void win(int npc)
    {
        if (winCondition == true && npc == 2)
        {
            System.out.println("Now that you have turned in the essay you have won the game, you may continue playing or quit");
        }
    }*/
}