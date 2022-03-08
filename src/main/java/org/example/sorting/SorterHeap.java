package org.example.sorting;

import java.util.Comparator;

/**
 * Implements heap sort
 */
public class SorterHeap extends SorterAbstract
{
    @Override
    protected void sortArray( Object[] arr, Comparator<Object> comparator )
    {
        if ( arr.length < 2 )
            return;

        int length = arr.length;

        // preheapify array starting with first non leaf elements
        for ( int i = length / 2 - 1; i >= 0; i-- )
            heapify( arr, comparator, i, length );

        // reverse last and first element and reheapify array
        for ( int i = length - 1; i >= 0; i-- )
        {
            Object temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify( arr, comparator, 0, i );
        }
    }

    /**
     * headpifies array: that is for every element with index startIndex it is not smaller than 2*startIndex+1 and 2*startIndex+2 elements
     * recursively heapifes only startIndex's children and only if rearrange was made
     * @param arr - array to heapify
     * @param comparator - comparator to compare elements
     * @param startIndex - from which point to start heapifing
     * @param length - up to which element to heapify
     */
    private void heapify( Object[] arr, Comparator<Object> comparator, int startIndex, int length )
    {
        int leftChild = 2 * startIndex + 1;
        int rightChild = 2 * startIndex + 2;

        int largest = startIndex;


        if ( leftChild < length && comparator.compare( arr[leftChild], arr[largest] ) > 0 )
            largest = leftChild;

        if ( rightChild < length && comparator.compare( arr[rightChild], arr[largest] ) > 0 )
            largest = rightChild;

        if ( largest != startIndex )
        {
            Object temp = arr[startIndex];
            arr[startIndex] = arr[largest];
            arr[largest] = temp;
            heapify( arr, comparator, largest, length );
        }
    }
}
