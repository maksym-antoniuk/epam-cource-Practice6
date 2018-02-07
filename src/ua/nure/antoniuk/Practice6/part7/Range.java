package ua.nure.antoniuk.Practice6.part7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Range implements Iterable<Integer> {

    List<Integer> list = new ArrayList<>();
    private boolean reverse;

    public Range(int n, int m, boolean reverse) {
        if (reverse) {
            for (int i = n; i <= m; i++) {
                list.add(i);
            }

        } else {
            for (int i = m; i >= n; i--) {
                list.add(i);
            }
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Integer> {
        Iterator<Integer> it = list.iterator();

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
