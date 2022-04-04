package org.example.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * Abstract class for sorter
 * All sorters should extend this one instead of implementing Sorter interface
 * Implements common code among all sorters
 * All inheriting classes should implement sortArray(Object[], Comparator<Object>) method
 */
public abstract class SorterAbstract implements Sorter
{

    @Override
    public <T extends Comparable<? super T>> void sort( List<T> list )
    {
        sortInner( list, null );
    }

    @Override
    public <T> void sort( List<T> list, Comparator<? super T> comparator )
    {
        sortInner( list, (Comparator<Object>) comparator );
    }

    /**
     * Sorts list using compartor by converting list to array and sorting array using sortArray() method
     * code taken from openjdk Collections.sort() method
     *
     * @param list       - list to sort
     * @param comparator - comparator for list elements
     * @param <T>        - type of elements
     */
    private <T> void sortInner( List<T> list, Comparator<Object> comparator )
    {
        Object[] arr = list.toArray();
        this.sortArray( arr, new InnerComparator( comparator ) );
        ListIterator<T> iterator = list.listIterator();
        for ( Object o : arr )
        {
            iterator.next();
            iterator.set( (T) o );
        }
    }

    /**
     * Sorts array of Objects using comparator
     * Should be implemented in all inheriting classes
     *
     * @param arr        - array to sort
     * @param comparator - comparator from InnerComparator class
     */
    protected abstract void sortArray( Object[] arr, Comparator<Object> comparator );


    /**
     * Comparator to be used in sortArray() method
     * If comparator is provided in constructor, returns the result of given comparator
     * Otherwise assumes that objects are Comparable and returns the result of compareTo method
     */
    protected class InnerComparator implements Comparator<Object>
    {
        private final Comparator<Object> comparator;

        /**
         * Comparator to be used, if null is provided, compareTo() method will be used
         *
         * @param comparator - comparator for Object or null if compareTo() method will be used
         */
        public InnerComparator( Comparator<Object> comparator )
        {
            this.comparator = comparator;
        }


        /**
         * Compares two objects using $comparator if it's not null
         * compareTo() otherwise
         *
         * @param o1 - first object
         * @param o2 - second object
         * @return negative number of o1 < o2
         * 0 if o1 == o2
         * positive number if o1>o2
         */
        @Override
        public int compare( Object o1, Object o2 )
        {
            if ( comparator == null )
                return ( (Comparable) o1 ).compareTo( o2 );
            else
                return comparator.compare( o1, o2 );
        }
    }
}
