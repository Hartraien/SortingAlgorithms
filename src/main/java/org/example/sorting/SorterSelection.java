package org.example.sorting;

import java.util.Comparator;

/**
 * Sort using selection sort
 */
public class SorterSelection extends SorterAbstract
{
    @Override
    protected void sortArray( Object[] arr, Comparator<Object> comparator )
    {
        for ( int i = 0; i < arr.length; i++ )
        {
            Object minVal = arr[i];
            int minIndex = i;
            for ( int j = i + 1; j < arr.length; j++ )
            {
                if ( comparator.compare( minVal, arr[j] ) > 0 )
                {
                    minVal = arr[j];
                    minIndex = j;
                }
            }

            if ( minIndex != i )
            {
                Object temp = arr[i];
                arr[i] = minVal;
                arr[minIndex] = temp;
            }
        }
    }
}
