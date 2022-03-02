package org.example.sorting;

import java.util.Comparator;

public class SorterBubble extends SorterAbstract
{

    @Override
    protected void sortArray( Object[] arr, Comparator<Object> comparator )
    {
        boolean finished = false;
        while ( !finished )
        {
            finished = true;
            for ( int i = 0; i < arr.length - 1; i++ )
            {
                if ( comparator.compare( arr[i], arr[i + 1] ) > 0 )
                {
                    Object temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    finished = false;
                }
            }
        }
    }

}
