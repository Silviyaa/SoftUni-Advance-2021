package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;

    public CustomList() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T remove(int index) {
        return elements.remove(index);
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(elements, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        return (int) elements.stream().filter(value -> value.compareTo(element) > 0).count();
//        int count = 0;
//        for (T value : this.elements) {
//            if (value.compareTo(element) > 0) {
//                count++;
//            }
//        }
//        return count;
    }

    public T getMax() {
        return Collections.max(elements);
    }

    public T getMin() {
        return Collections.min(elements);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element : this.elements) {
            builder.append(element).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
