package Countries;

import java.util.Comparator;

public class CompareByPopulation implements Comparator<Country> {
    public int compare(Country state1, Country state2){
        return state1.getPopulation() - state2.getPopulation();
    }
}
