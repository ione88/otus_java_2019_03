package ru.otus.hw02;

import java.util.*;

public class DYIArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_VALUES = {};
    transient Object[] values; // non-private to simplify nested class access
    private int length;

    public DYIArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.values = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.values = EMPTY_VALUES;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public DYIArrayList() {
        this.values = EMPTY_VALUES;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("contains");
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("iterator");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("toArray");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("<T> toArray");
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = values.length;
        if (oldCapacity > 0 || values != EMPTY_VALUES) {
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return values = Arrays.copyOf(values, newCapacity);
        } else {
            return values = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private void add(E e, Object[] values, int s) {
        if (s == values.length)
            values = grow(size() + 1);
        values[s] = e;
        length = s + 1;
    }

    @Override
    public boolean add(E e) {
        add(e, values, length);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++)
            values[i] = null;
        length = 0;
    }

    @Override
    public E get(int index) {
        if (index < size())
            return valueData(index);
        throw new ArrayIndexOutOfBoundsException("index more then size" + index + " > " + size());
    }

    // Positional Access Operations

    @SuppressWarnings("unchecked")
    E valueData(int index) {
        return (E) values[index];
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
