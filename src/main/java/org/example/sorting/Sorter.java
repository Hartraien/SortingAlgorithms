package org.example.sorting;

import java.util.Comparator;
import java.util.List;

public interface Sorter
{
    <T extends Comparable<? super T>> void sort( List<T> list );

    <T> void sort( List<T> list, Comparator<T> comparator );

}
