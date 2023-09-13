package Countries;

public class Country implements Comparable<Country> {

    private String name;
    private String capital;
    private String continent;
    private int population;
    private int area;

    public Country(String name, String capital, String continent, int population, int area){
        this.name = name;
        this.capital = capital;
        this.continent = continent;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public int compareTo(Country item) {
        return this.getName().compareTo(item.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
