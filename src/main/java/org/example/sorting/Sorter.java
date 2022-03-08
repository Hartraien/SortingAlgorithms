package org.example.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Sort lists
 * Sorter interface provides two sort methods
 * One requires list of Comparable types
 * Another requires comparator
 */
public interface Sorter
{
    /**
     * Sorts list of comparable elements
     *
     * @param list - list to sort
     * @param <T>  - type of list elements, should implement comparable
     */
    <T extends Comparable<? super T>> void sort( List<T> list );

    /**
     * Sorts list using comparator
     *
     * @param list       - list
     * @param comparator - comparator for list elements
     * @param <T>        - type of list elements
     */
    <T> void sort( List<T> list, Comparator<T> comparator );

}
