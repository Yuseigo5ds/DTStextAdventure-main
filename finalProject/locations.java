
/**
 * This file has the arrays relating to locations
 */
public class locations
{
    images images = new images();
    items items = new items();
    String[] locations = {//add the feature where you have to go up or downstairs (may need another var for this)
            "The Commons", //0
            "History Class", //1
            "English Class", //2
            "Science Lab", //3
            "Science Class", //4
            "Math Class", //5
            "Spanish Class", //6
            "Sue's Office", //7
            "Physics Class" //8
        };
    String[] altNames = {//alternative names for locations
            "Commons",
            "History",
            "English",
            "Lab",
            "Science",
            "Math",
            "Spanish",
            "Office",
            "Physics"
    };
    String[] locDescriptions = {//these should probably be in a format like "you enter the [blank] room, it has blah blah blah
            "This is where lunch can be eaten on campus and where the annoying band 'feathers of lead' practice",
            "George's Classroom, where U.S. and World History is taught.",
            "Brian's Classroom, where freshman English and U.S. Literature is taught",
            "The Science Lab, where all science based labs are conducted",
            "Kelsey's Classroom, where Biology and Chemistry is taught.",
            "Ananya's and Hudson's Classroom, this is where all of the math classes, from algebra 1 to statistics, are taught",
            "Lupe's Classroom, where Spanish is taught",
            "This office belongs to the head of school.",
            "This is usually where Daniel teaches physics and advanced physics, but Ananya sometimes teaches math here"
        };
    public int[][] schedule = {//classes for each year
            {4, 5, 2},//chem, alg 2, english 1
            {4, 6, 1, 2},//bio, spanish 1, american hist, english 2
            {1, 2, 6, 5},//wash hist, eng 3, span 2, calc (if you go to science or phys talk about summer phys
            {6, 1, 2, 5, 8}//span 3, philosophy, eng 4, stats, a phys
    };
    public static int period = 0;
    public int findNumClasses(int grade)
    {
        int numClasses = 0;
        if(main.grade == 9) {numClasses = 3;}//set the total number of classes for that year
        else if (main.grade == 10) {numClasses = 4;}
        else if (main.grade == 11) {numClasses = 4;}
        else if (main.grade == 12) {numClasses = 5;}

        return numClasses;
    }
    public int schoolTime()//assigns classes for each period
    {
        int grade = main.grade - 9;
        int numClasses = 0;

        if(main.grade == 9) {numClasses = 3;}//set the total number of classes for that year
        else if (main.grade == 10) {numClasses = 4;}
        else if (main.grade == 11) {numClasses = 4;}
        else if (main.grade == 12) {numClasses = 5;}

        if(period == 0)//if it's first period
        {
            if(schedule[grade][period] != main.playerLocation)
            {
                System.out.println("Your first class is " + locations[schedule[grade][period]]);
                //System.out.println("Period: " + period + " Last Period: " + numClasses);//for troubleshooting
            }
            else
            {
                period++;
                System.out.println("You are in " + locations[schedule[grade][period - 1]]);
                System.out.println("You have " + locations[schedule[grade][period]] + " next");
            }
        }
        else if(period+1 <= numClasses)//if it's any period but the last one
        {
            System.out.println("You are in " + locations[schedule[grade][period - 1]]);
            System.out.println("You have " + locations[schedule[grade][period]] + " next");
            //System.out.println("Period: " + period + " Last Period: " + numClasses);//for troubleshooting
        }
        else
        {
            if(main.grade < 12)//except for senior year
            {
                //freshman grade check
                if(main.grade == 9 && items.algebraCompleted == true)
                {
                    //when you just enter last period
                    System.out.println("Congradulations you've finished " + main.grade + "th grade.");
                    System.out.println("You are now starting " + (main.grade + 1) + "th grade.");
                    //System.out.println("Period: " + period + " Last Period: " + numClasses);//for troubleshooting
                    main.grade++;//add a year
                    grade = 1;
                    period = 0;//reset period
                    images.printGrade(main.grade);
                    System.out.println("Your first class is " + locations[schedule[grade][period]]);
                    return 0;//this is the dumbest solution to a problem I've ever come up with
                }
                else if (main.grade == 9 && items.algebraCompleted == false)
                {
                    //System.out.println(items.algebraCompleted);//used for troubleshooting
                    System.out.println("You've finished all of your classes, but still have to take your math test.");
                    return 0;
                }

                //sophomore grad check
                if(main.grade == 10 && items.courtCompleted == true)
                {
                    //if it's last period (this needs to change because it says you've finished a class
                    //when you just enter last period
                    System.out.println("Congradulations you've finished " + main.grade + "th grade.");
                    System.out.println("You are now starting " + (main.grade + 1) + "th grade.");
                    //System.out.println("Period: " + period + " Last Period: " + numClasses);//for troubleshooting
                    main.grade++;//add a year
                    grade = 2;
                    period = 0;//reset period
                    images.printGrade(main.grade);
                    //System.out.println(schedule[grade][period]);//for troubleshooting
                    System.out.println("Your first class is " + locations[schedule[grade][period]]);
                    return 0;
                }
                else if(main.grade == 10 && items.courtCompleted == false)
                {
                    System.out.println("You've finished all of your classes, but still have to take your history quiz.");
                    return 0;
                }

                if(main.grade == 11 && items.itemsOwned[5] == true)
                {
                    //move to 12th grade
                    //if it's last period (this needs to change because it says you've finished a class
                    //when you just enter last period
                    System.out.println("Congradulations you've finished " + main.grade + "th grade.");
                    System.out.println("You are now starting " + (main.grade + 1) + "th grade.");
                    //System.out.println("Period: " + period + " Last Period: " + numClasses);//for troubleshooting
                    main.grade++;//add a year
                    grade = 3;
                    period = 0;//reset period
                    images.printGrade(main.grade);
                    //System.out.println(schedule[grade][period]);//for troubleshooting
                    System.out.println("Your first class is " + locations[schedule[grade][period]]);
                    return 0;
                }
                else if (main.grade == 11 && items.itemsOwned[6] == false)
                {
                    System.out.println("You've finished all of your classes, but still have to turn in your english essay.");
                    return 0;
                }
            }
            else if(main.grade == 12)//senior check is a little different because you need the different items
            {
                if(items.itemsOwned[6] == true && items.itemsOwned[7] == true && items.itemsOwned[8] == true)//this stuff needs to be checked.
                {
                    System.out.println("Congradulations! You've finished High School");
                    System.out.println("Good luck on your future endeavours.");
                    System.out.println("feel free to keep roaming around or quit");
                }
                else
                {
                    System.out.println("You've finished all of your classes, but you still need all of your graduation " +
                            "requirements");
                    System.out.println("You need:\nCrime and Punishment Essay\nPersonal Philosophy\nCapstone Project");
                }
            }
        }
        return 0;
    }
}

