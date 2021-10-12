
/**
 * This file has the arrays relating to items
 */

/*
Here are the exit ticket/grad requirements per year (need items to start these, and items are easily found in commons etc)
    9: algebra 2 question
    10: question about court
    11: hidden object: essay
    12: find hidden objects:
        Crime and Punishment Essay
        Personal Philosophy
        Capstone Project
 */
import java.util.Scanner;
public class items
{
    npcs n = new npcs();
    String[] items = {
        "Pencil",
        "Eraser",
        "Backpack",
        "Screwdriver",
        "Chromebook",
        "Essay",
        "Crime and Punishment Essay",//senior brian exit ticket
        "Personal Philosophy",//senior george exit ticket
        "Capstone Project",//senior sue exit ticket
        "Electric Guitar"
    };//need to fix the multiple word items so they work with drop


    public static boolean algebraCompleted = false;
    public void algebraTest()//freshman grade test
    {
        String answer;

        System.out.println("Algebra 2 Test");
        System.out.println("This is a pretty simple question");

        while(algebraCompleted == false)//loop while the question isn't answered correctly
        {
            System.out.println("What is the y-intercept of y = -3x + 4");
            System.out.print(main.playerName + ": ");
            Scanner input = new Scanner(System.in);
            answer = input.nextLine();
            if(answer.equalsIgnoreCase("4"))//if it's correct
            {
                System.out.println("Correct!");
                n.npcResponses[5][0][2] = "Good job on your Math test!";
                algebraCompleted = true;//break the loop
            }
            else
            {
                System.out.println("Incorrect! Try again.");
            }
        }
    }

    //sophomore grad check
    public static boolean courtCompleted = false;
    public void courtQuestion()//very similar to algebra test
    {
        String answer;
        while(courtCompleted == false)
        {
            System.out.println("George asks what's the highest court in the United States.");
            System.out.print(main.playerName + ": ");
            Scanner input = new Scanner(System.in);
            answer = input.nextLine();
            if (answer.equalsIgnoreCase("The Supreme Court") || answer.equalsIgnoreCase("Supreme Court"))
            {
                System.out.println("Correct!");
                n.npcResponses[0][1][2] = "Good thing you know what the Supreme Court is. Don't forget we're going on a " +
                        "city as lab to the courthouse next week!";
                courtCompleted = true;
            }
            else
            {
                System.out.println("Incorrect! Try again.");
            }
        }
    }

    static boolean[] itemsOwned = {
        true,
        true,
        true,
        false,
        false,
        false,
        false,
        false,
        false,
        false
    };
    public static int[] itemLocation = {
        50,
        50,
        50,
        1,
        1,
        62,//hidden item, subract 60 to make it visible
        60,
        61,
        66,
        6
    };//50 just means that the player is holding the item. Invisible items have 60 added to their location number
}
/*
 * String[] locations = {
            0"The Commons",
            1"History Class",
            2"English Class",
            3"The Lab",
            4"Science Class",
            5"Math Class",
            6"Spanish Class",
            7"Sue's Office"
        };
 */