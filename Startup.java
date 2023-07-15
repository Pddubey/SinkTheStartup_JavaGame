import java.util.ArrayList;

public class Startup {
    private ArrayList<String> locationCells;
    private String name;
    public void setName(String n){
        name=n;
    }

    String checkYourself(String userGuess){
        String result="miss";
        int index= locationCells.indexOf(userGuess);
        if(index>=0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouchh!! you kill "+name);
            }
            else {
                result="hit";
            }
        }

        return result;
    }
    public void setLocationCells(ArrayList<String> locs){
        locationCells=locs;
    }


}
