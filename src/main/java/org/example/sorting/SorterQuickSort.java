package org.example.sorting;

import java.util.Comparator;

/**
 * Sort using quicksort (recursive)
 */
public class SorterQuickSort extends SorterAbstract
{
    @Override
    protected void sortArray( Object[] arr, Comparator<Object> comparator )
    {
        if ( arr.length < 2 )
            return;
        sortSubArray( arr, comparator, 0, arr.length - 1 );
    }

    private void sortSubArray( Object[] arr, Comparator<Object> comparator, int startIndex, int lastIndex )
    {
        if ( lastIndex <= startIndex )
            return;
        int pivot = partition( arr, comparator, startIndex, lastIndex );
        sortSubArray( arr, comparator, startIndex, pivot - 1 );
        sortSubArray( arr, comparator, pivot + 1, lastIndex );
    }

    /**
     * rearranges subarray so that every element to the left of pivot is smaller than pivot and all elements to the right are not smaller than
     *
     * @param arr        - array
     * @param comparator - comparator to compare elements
     * @param startIndex - start of subarray
     * @param lastIndex  - index of last element
     * @return index of new pivot
     */
    private int partition( Object[] arr, Comparator<Object> comparator, int startIndex, int lastIndex )
    {

        int counter = startIndex;
        for ( int i = startIndex; i < lastIndex; i++ )
        {
            if ( comparator.compare( arr[i], arr[lastIndex] ) < 0 )
            {
                Object temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }

        Object temp = arr[lastIndex];
        arr[lastIndex] = arr[counter];
        arr[counter] = temp;

        return counter;
    }
}
