import java.lang.reflect.Array;
import java.util.ArrayList;
public class StartupBust {
    /**
     * GameHelper helper
     * int numOfGuesses
     * ArrayList
     * setUpGame()
     * startPlaying()
     * checkUserGuess()
     * finishGame()
     */
    //Listing the instance variable of the class
    private GameHelper helper=new GameHelper();
    private ArrayList<Startup> startups=new ArrayList<Startup>();
    private int numOfGuesses=0;

    private void setUpGame() {
        //creating three startups and given the name to them
        Startup one=new Startup();
        one.setName("Unacademy");
        Startup two=new Startup();
        two.setName("MBA Chaiwala");
        Startup three=new Startup();
        three.setName("Phone-Pay");
        //storing all thse three startups in to startups arraylist
        startups.add(one);
        startups.add(two);
        startups.add(three);

        System.out.println("Your goal is to sink three Startups.");
        System.out.println("Unacademy, MBA Chaiwala, Phone-Pay");
        System.out.println("Try to sink them all in the fewest number of guesses");
        //pacing all three startups in a random place
        for (Startup startup:startups) {
            ArrayList<String> newLocation=helper.placeStartup(3);
            startup.setLocationCells(newLocation);
        }
    }
    private void startPlaying(){
        while(!startups.isEmpty()){
            String userGuess=helper.getUserInput("Enter a Guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    private String checkUserGuess(String userGuess){
        numOfGuesses++;
        String result="miss";
        for (Startup startup:startups) {
            result=startup.checkYourself(userGuess);
            if(result.equals("hit")){
                break;
            }
            if (result.equals("kill")){
                startups.remove(startup);
                break;
            }
        }
        System.out.println(result);
        return result;

    }
    private void finishGame() {
        System.out.println("All Startups are dead! Your stock is now worthless");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }


    public static void main(String[] args) {
        StartupBust game=new StartupBust();
        game.setUpGame();
        game.startPlaying();
        game.finishGame();

    }
}

