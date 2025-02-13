package CustomListImplementation;

import Countries.Country;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Country Bulgaria = new Country("Bulgaria","Sofia", "Europe", 6520314, 110994);
        Country Romania = new Country("Romania","Bucharest", "Europe", 19053815, 238397);
        Country Greece = new Country("Greece","Athens", "Europe", 10432481, 131957);
        Country Hungary = new Country("Hungary","Budapest", "Europe", 9689000, 93030);
        Country Croatia = new Country("Croatia","Zagreb", "Europe", 3871833, 56594);
        Country CzechRepublic = new Country("Czech Republic","Prague", "Europe", 10516707, 78871);
        Country Poland = new Country("Poland","Warsaw", "Europe", 37796000, 312696);
        Country Italy = new Country("Italy", "Rome", "Europe", 58853482, 301230);
        Country Spain = new Country("Spain", "Madrid", "Europe", 47325360, 505990);
        Country France = new Country("France", "Paris", "Europe", 68042591, 643801);

        CustomList<Country> customList = new CustomList<>();

        customList.addNode(France);
        customList.addNode(Spain);
        customList.addNode(Italy);
        customList.addNode(Greece);
        customList.addNode(Croatia);
        customList.addNode(Romania);
        customList.addNode(Hungary);
        customList.addNode(CzechRepublic);
        customList.addNode(Poland);
        customList.addFirst(Bulgaria);

        System.out.println("List size: " + customList.listSize());
        System.out.println("------------------------------------------------");
        System.out.println("List by input order:");
        printList(customList);

        System.out.println("The list sorted by 'Country Name':");
        customList.mergeSort();
        printList(customList);

        Country Austria = new Country("Austria", "Vienna", "Europe", 9027999, 83871);
        Country Switzerland = new Country("Switzerland", "Bern", "Europe", 8636896, 41285);
        Country Germany = new Country("Germany", "Berlin", "Europe", 84270625, 357592);
        Country Denmark = new Country("Denmark", "Copenhagen", "Europe", 5928364, 42943);
        Country Portugal = new Country("Portugal", "Lisbon", "Europe", 10352042, 92212);

        customList.addNode(Austria);
        customList.addNode(Switzerland);
        customList.addNode(Germany);
        customList.addNode(null);
        customList.addNode(Denmark);
        customList.addNode(Portugal);

        customList.mergeSort(new Countries.CompareByPopulation());
        System.out.println("The list sorted by 'Country Population', after adding new nodes:");
        printList(customList);

        int indexOfRemovedElement = customList.removeValue(null);
        System.out.println("Index of element, removed 'by Value': " + indexOfRemovedElement);
        Country removedElement = customList.removeIndex(customList.listSize()- 1);
        System.out.println("Element, removed 'by Index': " + removedElement);
        System.out.println("List content after deletion:");
        printList(customList);

        customList.selectionSort(new Countries.CompareByArea());
        CustomList<Country>.CustomIterator listItr = customList.new CustomIterator();
        System.out.println("The list in details, sorted by 'Country Area':");
        printDetails(listItr);

        System.out.println("List contains Bulgaria: " + customList.contains(Bulgaria));
        System.out.println("List contains Germany: " + customList.contains(Germany));
        System.out.println("------------------------------------------------");

        System.out.printf("First element: %s \nLast element: %s\n", customList.firstElement(), customList.lastElement());
        System.out.println("------------------------------------------------");

        Random rand = new Random();
        int randomIndex = rand.nextInt(customList.listSize());
        Country country = customList.elementAtIndex(randomIndex);
        System.out.printf("Index %d contains: %s\n", randomIndex, country);
        System.out.println("------------------------------------------------");

        customList.reverse();
        System.out.printf("Index of %s after reversal: %d\n", country, customList.indexOf(country));
    }

    private static void printList(CustomList<Country> countries){
        System.out.println("------------------------------------------------");
        for (Countries.Country state : countries) {
            System.out.println(state);
        }
        System.out.println("------------------------------------------------");
    }

    private static void printDetails(CustomList<Country>.CustomIterator itr) {
        System.out.println("------------------------------------------------");
        while (itr.hasNext()) {
            Country current = itr.next();
            System.out.println(current + "  ||  population " + current.getPopulation() + "  ||  area " + current.getArea());
        }
        System.out.println("------------------------------------------------");
    }
}
