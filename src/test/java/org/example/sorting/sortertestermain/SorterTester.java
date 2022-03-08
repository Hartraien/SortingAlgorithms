package org.example.sorting.sortertestermain;

import org.example.sorting.Sorter;
import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.stream.Collectors;

public class SorterTester
{
    private final int listSize = 1000;

    public void testSorter( Sorter sorter )
    {
        testIntegers( sorter );
        testStrings( sorter );
        testIntegersReversed( sorter );
        testStringsReversed( sorter );
    }

    private void testStringsReversed( Sorter sorter )
    {
        List<String> list = this.generateListString();
        List<String> listCopy = new ArrayList<>( list );

        Comparator<String> comparator = ( a, b ) -> b.compareTo( a );

        list.sort( comparator );
        sorter.sort( listCopy, comparator );

        Assertions.assertEquals( list, listCopy );
    }

    private void testIntegersReversed( Sorter sorter )
    {

        List<Integer> list = this.generateListInteger();
        List<Integer> listCopy = new ArrayList<>( list );

        Comparator<Integer> comparator = ( a, b ) -> Integer.compare( b, a );

        list.sort( comparator );
        sorter.sort( listCopy, comparator );

        Assertions.assertEquals( list, listCopy );

    }

    private void testStrings( Sorter sorter )
    {
        List<String> list = this.generateListString();
        List<String> listCopy = new ArrayList<>( list );

        Collections.sort( list );
        sorter.sort( listCopy );

        Assertions.assertEquals( list, listCopy );
    }

    private void testIntegers( Sorter sorter )
    {
        List<Integer> list = this.generateListInteger();
        List<Integer> listCopy = new ArrayList<>( list );

        Collections.sort( list );
        sorter.sort( listCopy );

        Assertions.assertEquals( list, listCopy );
    }


    private List<String> generateListString()
    {
        List<String> result = new ArrayList<>();
        for ( int i = 0; i < listSize; i++ )
            result.add( this.generateRandomString() );
        return result;
    }

    private String generateRandomString()
    {
        final int lowerBound = 97;
        final int upperBound = 122;
        Random random = new Random();

        int size = random.nextInt( 1, 100 );

        return random
                .ints( lowerBound, upperBound )
                .limit( size )
                .collect( StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append )
                .toString();
    }

    private List<Integer> generateListInteger()
    {
        return new Random().ints().boxed()
                .limit( listSize )
                .collect( Collectors.toList() );
    }
}
