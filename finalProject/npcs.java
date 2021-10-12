
/**
 * This file has the arrays relating to npcs
 */
public class npcs
{
    public String[] npcNames = {//need to add ashleigh
            "George",
            "Sue",
            "Brian",
            "Lupe",
            "Kelsey",
            "Ananya",
            "Hudson",
            "Daniel",
            "Ashleigh",//make sure code for ashleigh works
            "Jeremy",
            "Dan"
        };
    /*
    public static String[] npcResponses = {//original responses
            "History is fun! I love the Supreme Court. Did you know that the Franco-Prussian war helped to shape the modern nation state?",
            "Hey, I talked to Brian, he says that you haven't turned in an essay but you said that you did it. You should probably find it and turn it in.",
            "I need that essay or you're gonna fail the class",
            "No sé dónde está tu ensayo ¿Por qué siempre pierdes todo? ¡¡¡ERES UN DESASTRE!!!",
            "The mitochondria is the powerhouse of the cell",
            "Hello, I know you need to find your English Essay but don't forget you have a math exam next week",
            "Filler text for Daniel",
            "You should listen to Pink Floyd or Led Zepplin"
        };//we can also add random npc responses
     */
    /*
    public static String[][] npcResponses = {//responses now take into consideration the player's grade
            {"George 9",
                    "History is fun! I love the Supreme Court. Did you know that the Franco-Prussian war helped to shape the modern nation state?",
                    "George 11",
                    "George 12"},
            {"Sue 9",
                    "Sue 10",
                    "Sue 11",
                    "Sue 12"},
            {"Brian 9",
                    "Brian 10",
                    "Brian 11",
                    "Brian 12"},
            {"Lupe 9",
                    "Lupe 10",
                    "Lupe 11",
                    "Lupe 12"},
            {"Kelsey 9",
                    "The mitochondria is the powerhouse of the cell",
                    "Kelsey 11",
                    "Kelsey 12"},
            {"Ananya 9",
                    "Ananya 10",
                    "Ananya 11",
                    "Ananya 12"},
            {null,
                    null,
                    "Hudson 11",
                    "Hudson 12"},
            {null, null, "There must be a mistake in your schedule, I know you took physics over " +
                    "summer so you can just head to your next class", "Daniel 12"},
            {null, null, null, "You should listen to Pink Floyd or Led Zepplin"}};

     */

    public static int numResponses = 2;
    //code for pulling response would be n.npcResponses[requestedNPC][grade-9][random.int(0, 2)] (if it's not null)
    public static int[][] responseSaid = {
            {0, 0, 0, 0},//George
            {0, 0, 0, 0},//Sue
            {0, 0, 0, 0},//Brian
            {0, 0, 0, 0},//Lupe
            {0, 0, 0, 0},//Kelsey
            {0, 0, 0, 0},//Ananya
            {0, 0, 0, 0},//Hudson
            {0, 0, 0, 0},//Daniel
            {0, 0, 0, 0},//Ashleigh
            {0, 0, 0, 0},//Jeremy
            {0, 0, 0, 0}//Dan`

    };
    public static String[][][] npcResponses = {
            {{"Hey, I know you don't have history this year, but you're free to stay",
                    "feel free to stay here while you study for your math test",
                    "You should probably talk to Ananya about the math test you have today"},
                    {"History is fun! I love the Supreme Court. Did you know that the Franco-Prussian war helped to shape the modern nation state?",
                            "I assume you studied for your history quiz",
                            "It's time for your history quiz now."},
                    {"I loved our trip to the Elwah River Damn, I think it really helped contextualize what we were learning in class",
                            "You should record your interview soon, that way there'll be time to get it transcribed and checked by the " +
                                    "interviewee",
                            "I hope you've contacted the person you want to interview"},
                    {"Don't forget to turn in your personal philosophy",
                            "Start with the bottom line of your ideal nation and then go about how the nation would achieve its " +
                                    "bottom line",
                            "Make sure you finish your capstone project. You can still fail this class before graduation"}},
            {{"Welcome to DTS, feel free to talk to any of the teachers anytime!",
                    "You should talk to teachers multiple times so you can hear everything they have to say.",
                    "I heard you have a math quiz today. Good Luck!"},
                    {"Make sure you're prepared for your city as lab to court next week",
                            "I think George wants to make sure you understand the US courts before next week",
                            "You should probably double check the levels of court before George asks you about them"},
                    {"Hey, I talked to Brian, he says that you haven't turned in an essay but you said that you did it. " +
                            "You should probably find it and turn it in.",
                            "You should look specifically for the essay in every room",
                            "If you don't find the essay, you can't graduate from junior year."},
                    {"Almost done, you just need to find all of your graduation requirements",
                            "I'm exited to see your capstone project", "Don't forget that you need to get your graduation requirements soon"}},
            {{"Did you know Romeo and Juliet can be considered a comedy rather than a tragedy",
                    "Animal Farm is actually about animal rights",
                    "What do you mean Animal Farm isn't about animal rights?"},
                    {"Let's just say that your tryptich write-up from the What is a Good Life intensive was interesting",
                            "No spoilers, but My Antonia is the most interesting book we'll read this year",
                            "I don't know understand why your class keeps complaining about My Antonia, there's so much imagery. " +
                                    "The book does a great job of really describing the locations"},
                    {"I need that essay or you're gonna fail the class", "Look around for the essay", "try to 'take essay' in every classroom."},
                    {"I'm going to need your Crime and Punishment essay from you soon",
                            "You should try finding this essay the same way to you tried last year",
                            "If you don't turn in your essay, you're not going to be able to graduate"}},
            {{"Tu no tiene clase de espanol", "Oh, I forgot that you don't have spanish class",
                    "You should learn the phrase 'no hablo espanol' that way the only spanish you know translates to '" +
                            "I don't speak spanish'"},
                    {"Now that you're in spanish 1, you can't just say 'no hablo espanol' anymore",
                            "Es el encuadernamiento para tu libro infantil dificil? Practica porque te vas para " +
                                    "Destination Imagination",
                            "entrega tu libro infantil antes de irte para Destination Imagination"},
                    {"No se donde esta tu ensayo Por que siempre pierdes todo? ERES UN DESASTRE!!!",
                            "Tu ensayo es muy tarde!!!",
                            "Por que tu tienes este problema!!!"},
                    {"Remember our weekly meetings on Friday, because you're learning asynchronously it's important to meet when we can",
                            "I think I saw your capstone project somewhere around here",
                            "You should try to take your capstone project, it might turn up"}},
            {{"Please don't drink the gatorade.", "We need the gatordate for the lab so you don't drink it",
                    "Wait, why did you drink the gatorade? It was contamiated! You should probably make sure you're ok"},
                    {"The mitochondria is the powerhouse of the cell",
                            "Yeast is the best organism",
                            "Don't question how amazing yeast is"},
                    {"Good job taking physics over summer, I hear you crushed it",
                            "You're not in Advanced Bio so I assume you're looking for your english essay",
                            "Some items are hidden and you need to try to specifically take them"},
                    {"Why did you pick Advanced Physics over Advanced Bio? What about the yeast?",
                            "Why do I keep hearing about uranium and a closet? I feel like I should be worried",
                            "I think you should look in the commons for your essay"}},
            {{"Don't forget about your math test",
                    "I hope you remember linear equations",
                    "It's time for you to take your math test."},
                    {"No, precalculus isn't just algebra 2 but harder",
                            "Later this week M100 and M200 are going on a city-as-lab meaning only you and the 5 students " +
                                    "in precalculus will be left at school",
                            "Don't prank the school while M100 and M200 are gone"},
                    {"I bet you're having fun learning calculus! The class is both challenging and interesting",
                            "If you think derivatives are fun, wait until you get to integrals!",
                            "I know you need to find your English Essay but don't forget you have a math exam in Hudson's " +
                                    "class next week"},
                    {"You should probably relearn some of calculus before you head off to college",
                            "You can stay here and work on calculus assignments if you want",
                            "I like Hudson's city as lab idea: use calculus to find out how far you've travelled " +
                                    "while in the trunk of a car"}},
            {{null, null, null},
                    {null, null, null},
                    {"If I pull on your hoodie while you're walking, that's both jerk and being a jerk",
                            "If you were in the trunk of a car and all you had was a stopwatch, you could use " +
                                    "calculus to estimate where you ended up",
                            "I think I should try stuffing students in the back of a car for a city as lab"},
                    {"In 2018, GSS did a study where about 28% of people said that the Sun revolved around the Earth",
                            "Good news: our chi-squared test shows that this scientific misunderstanding is independent of " +
                                    "political party",
                            "Unfortunately, that's still a lot of people that think the Sun revolves around the Earth"}},
            {{null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {"Don't forget that because of length contraction, while you're moving you get a little bit thinner",
                            "Our nuclear physics lab is next thursday, make sure you're ready",
                            "Remember, because we'll be handling uranium, we're gonna conduct our lab in the closet"}},
            {{null, null, null},
                    {null, null, null},
                    {"We're working on next year's schedule soon so think about what classes you want to take",
                            "Make sure you get back to me about your planned schedule for next year",
                            "We're going over grades and comments tomorrow so make sure you stay for the meeting"},//junior year should be filled
                    {null, null, null}},//Ashleigh
            {{null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {"Your healthcheck and temperature look good so you're cleared to go to class now",
                            "You should listen to better music",
                            "Why are you still listening to garbage music?"}},
            {{null, null, null},//Don't need any text here for Dan, but needs to exist in array
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}}
    };


    public int[][] npcLocations = {//100 is a placeholder for null
            {1, 1, 1, 1},//george
            {7, 7, 7, 7},//sue
            {2, 2, 2, 2},//brian
            {6, 6, 6, 6},//lupe
            {4, 4, 4, 4},//kelsey
            {5, 5, 8, 5},//ananya
            {100, 100, 5, 5},//hudson
            {100, 100, 100, 8},//Daniel
            {100, 100, 0, 100},//Ashleigh
            {100, 100, 100, 0},//Jeremy
            {0, 0, 0, 0}//Dan maybe change 9th grade to 100 cause technically wasn't here
    };

    public static String[] randomResponses = {
            "Hey, I'm gonna go to the armoury for lunch today. You should join me.",
            "I have to study for my physics test next period, special relativity is so unintuitive.",
            "I  don't even understand Integrals. I should probably meet with Hudson after school.",
            "Did you hear Feathers of Lead at the dance last week? They sucked. Dan's singing was so out of tune.",
            "I can't wait til the intensive, I'm taking the film making one so I can add to Ethan's mockumentary series",
            "George is taking us to court next week. We're gonna watch a case about discrimination regarding a handicap." +
                    " Should I wear a suit or not?",
            "Yo no hablo espanol o mi espanol es muy mal.",//the accents aren't working here
            "I'm behind on my reading. I tried to read My Antonia, but it was too hard to get through.",
            "Have you seen Cobra Kai, it's a really good show. I didn't believe Dan at first, but then it was on Netflix",
            "I have to take my Driver's Ed test tomorrow. I'm not gonna study though, I just need 80%"
    };
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