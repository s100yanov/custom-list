package Countries;

import java.util.Comparator;

public class CompareByPopulation implements Comparator<Country> {
    public int compare(Country state1, Country state2){
        if (state1 == null) {
            return ((state2 == null) ? 0 : 1);
        }
        if (state2 == null) {
            return -1;
        }
        return state1.getPopulation() - state2.getPopulation();
    }
}
