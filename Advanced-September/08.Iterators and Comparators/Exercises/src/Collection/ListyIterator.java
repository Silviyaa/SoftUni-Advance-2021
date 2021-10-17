package Collection;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
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

    public void printAll() {
        this.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index;

            @Override
            public boolean hasNext() {
                return this.index < elements.size();
            }

            @Override
            public String next() {
                String element = elements.get(index);
                index++;
                return element;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        this.elements.forEach(action::accept);
    }
}