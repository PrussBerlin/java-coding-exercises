import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

    private String name;
    private ArrayList<T> teams = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public boolean addTeam(T newTeam) {
        if(!findTeam(newTeam)) {
            teams.add(newTeam);
            System.out.println(newTeam.getName() + " added to "+ name);
            return true;
        }
        System.out.println(newTeam.getName() + " is already in the " + name);
        return false;
    }

    public boolean findTeam(T team) {
        if(teams.isEmpty()) {
            return false;
        }
        return teams.contains(team);
    }

    public String getName() {
        return name;
    }

    public void printSorted() {
        Collections.sort(teams);
        int i = 1;
        for(T t : teams) {
            System.out.println((i++) + ": " + t.getName() + ", Punkte: " + t.ranking());
        }
    }
}
