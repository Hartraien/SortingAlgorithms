package org.example.sorting;

import java.util.Comparator;

/**
 * Sort using insertion sort
 */
public class SorterInsertion extends SorterAbstract
{

    @Override
    protected void sortArray( Object[] arr, Comparator<Object> comparator )
    {
        for ( int i = 1; i < arr.length; i++ )
        {
            for ( int j = i - 1; j >= 0; j-- )
            {
                if ( comparator.compare( arr[j + 1], arr[j] ) < 0 )
                {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                else
                    break;
            }
        }
    }
}
