package Google;


import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Company: \n");
        if (company != null) {
            stringBuilder.append(company).append("\n");
        }
        stringBuilder.append("Car: \n");
        if (car != null) {
            stringBuilder.append(car).append("\n");
        }
        stringBuilder.append("Pokemon: \n");
        for (Pokemon pokemon : pokemons) {
            stringBuilder.append(pokemon.toString()).append("\n");
        }
        stringBuilder.append("Parents: \n");
        for (Parents parent : parents) {
            stringBuilder.append(parent.toString()).append("\n");
        }
        stringBuilder.append("Children: \n");
        for (Children children : children) {
            stringBuilder.append(children.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}