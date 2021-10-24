package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    public String name;
    public int capacity;
    List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (capacity > roster.size()) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        int index = -1;
        for (int r = 0; r < roster.size(); r++) {
            if (roster.get(r).getName().equals(name)){
                index = r;
            }
        }
        if (index!=-1){
            roster.remove(index);return true;
        }
        return false;
        //return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }
        return null;
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
       sb.append(String.format("The people in the hotel %s are:%n",this.name));
       this.roster
               .stream().forEach(r->{
                   sb.append(r).append(System.lineSeparator());
               });
        return sb.toString().trim();
    }
}


