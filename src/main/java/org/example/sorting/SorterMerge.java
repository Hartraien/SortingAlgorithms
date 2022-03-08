package org.example.sorting;

import java.util.Comparator;

/**
 * Sort using merge sort (recursive)
 */
public class SorterMerge extends SorterAbstract
{
    @Override
    protected void sortArray( Object[] arr, Comparator<Object> comparator )
    {
        if ( arr.length < 2 )
            return;
        sortSubArray( arr, comparator, 0, arr.length );
    }

    /**
     * Sorts left and right subarrays and merges them in result
     * @param arr - array
     * @param comparator - comparator to compare elements
     * @param startIndex - index of first element of subarray
     * @param upperBound - index of last element of subarray + 1
     */
    private void sortSubArray( Object[] arr, Comparator<Object> comparator, int startIndex, int upperBound )
    {
        if ( upperBound - startIndex > 1 )
        {
            int mid = ( upperBound + startIndex ) / 2;
            sortSubArray( arr, comparator, startIndex, mid );
            sortSubArray( arr, comparator, mid, upperBound );
            Object[] temp = new Object[upperBound - startIndex];
            int index = 0;
            int leftIndex = startIndex;
            int rightIndex = mid;
            while ( leftIndex < mid && rightIndex < upperBound )
            {
                if ( comparator.compare( arr[leftIndex], arr[rightIndex] ) <= 0 )
                {
                    temp[index++] = arr[leftIndex++];
                }
                else
                    temp[index++] = arr[rightIndex++];
            }

            while ( leftIndex < mid )
                temp[index++] = arr[leftIndex++];

            while ( rightIndex < upperBound )
                temp[index++] = arr[rightIndex++];

            System.arraycopy( temp, 0, arr, startIndex, temp.length );
        }
    }
}
