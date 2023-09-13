package Countries;

import java.util.Comparator;

public class CompareByArea implements Comparator<Country> {
    public int compare(Country state1, Country state2){
        return state1.getArea() - state2.getArea();
    }
}
