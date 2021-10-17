package ListyIterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> elements;
    private int index;

    public ListyIterator(String... elements) {
        this.elements = Arrays.asList(elements);
        index = 0;
    }

    public boolean hasNext() {
        return index < elements.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.elements.size() == 0) {
            throw new IllegalStateException("Invalid Operation!");
        } else {
            System.out.println(this.elements.get(index));
        }
    }
}