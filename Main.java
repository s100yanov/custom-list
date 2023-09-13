package CustomListImplementation;

import Countries.Country;

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

        customList.addNode(Bulgaria);
        customList.addNode(Romania);
        customList.addNode(Greece);
        customList.addNode(Hungary);
        customList.addNode(Croatia);
        customList.addNode(CzechRepublic);
        customList.addNode(Poland);
        customList.addNode(Italy);
        customList.addNode(Spain);
        customList.addNode(France);

        System.out.println("List size: " + customList.listSize());
        System.out.println("------------------------------------------------");
        int i = 0;

        while (i < customList.listSize()) {
            System.out.println(customList.elementAtIndex(i));
            i++;
        }

        System.out.println("------------------------------------------------");

        customList.removeValue(CzechRepublic);
        System.out.println("The list after removing an element:");
        System.out.println("------------------------------------------------");

        int j = 0;

        while (j < customList.listSize()) {
            System.out.println(customList.elementAtIndex(j));
            j++;
        }

        System.out.println("------------------------------------------------");

        System.out.printf("First element: %s -> Last element: %s\n", customList.firstElement(), customList.lastElement());
        customList.reverse();
        System.out.printf("First element: %s -> Last element: %s\n", customList.firstElement(), customList.lastElement());

    }
}
