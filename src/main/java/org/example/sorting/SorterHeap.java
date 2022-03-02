package org.example.sorting;

import java.util.Comparator;

public class SorterHeap extends SorterAbstract
{
    @Override
    protected void sortArray( Object[] arr, Comparator<Object> comparator )
    {
        if ( arr.length < 2 )
            return;

        int length = arr.length;

        for ( int i = length / 2 - 1; i >= 0; i-- )
            heapify( arr, comparator, i, length );

        for ( int i = length - 1; i >= 0; i-- )
        {
            Object temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify( arr, comparator, 0, i );
        }
    }

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
