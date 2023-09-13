package Countries;

import java.util.Comparator;

public class CompareByName implements Comparator<Country> {
    public int compare(Country state1, Country state2) {
        return state1.getName().compareTo(state2.getName());
    }
}
