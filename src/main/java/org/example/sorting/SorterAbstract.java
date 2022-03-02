package org.example.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public abstract class SorterAbstract implements Sorter
{

    @Override
    public <T extends Comparable<? super T>> void sort( List<T> list )
    {
        sortInner( list, null );
    }

    @Override
    public <T> void sort( List<T> list, Comparator<T> comparator )
    {
        sortInner( list, (Comparator<Object>) comparator );
    }

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

    protected abstract void sortArray( Object[] arr, Comparator<Object> comparator );

    protected class InnerComparator implements Comparator<Object>
    {
        private final Comparator<Object> comparator;

        public InnerComparator( Comparator<Object> comparator )
        {
            this.comparator = comparator;
        }


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
