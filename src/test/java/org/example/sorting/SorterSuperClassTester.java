package org.example.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SorterSuperClassTester implements SorterTesterInterface
{

    private static class A
    {
        private final String name;

        private A( String name )
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }
    }


    private static class B extends A
    {

        private B( String name )
        {
            super( name );
        }
    }

    private static String getRandomString( int length )
    {
        return ThreadLocalRandom.current().ints( 'a', 'z' + 1 )
                .limit( length )
                .collect( StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append )
                .toString();
    }

    @Test
    @Override
    public void testSorter()
    {
        int size = 100;

        List<B> example = Stream.generate( () -> getRandomString( 10 ) )
                .limit( size )
                .map( B::new )
                .collect( Collectors.toList() );

        List<B> copy = new ArrayList<>( example );
        List<B> test = new ArrayList<>( example );

        Comparator<A> aComparator = Comparator.comparing( A::getName );
        Comparator<B> bComparator = Comparator.comparing( A::getName );

        example.sort( aComparator );
        copy.sort( aComparator );
        test.sort( bComparator );

        Assertions.assertEquals( example, copy );
        Assertions.assertEquals( example, test );

    }
}
