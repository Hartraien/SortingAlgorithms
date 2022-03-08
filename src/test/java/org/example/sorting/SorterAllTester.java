package org.example.sorting;

import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Objects;

public class SorterAllTester
{
    @Test
    void testAllTests()
    {
        Reflections reflections = new Reflections( "org.example" );

        final var sorterClasses = reflections.getSubTypesOf( SorterTesterInterface.class );

        sorterClasses
                .stream()
                .filter( elem -> !Modifier.isAbstract( elem.getModifiers() ) )
                .map( this::getSorterTesterInterface )
                .filter( Objects::nonNull )
                .forEach( SorterTesterInterface::testSorter );
    }

    private SorterTesterInterface getSorterTesterInterface( Class<? extends SorterTesterInterface> elem )
    {
        try
        {
            final Constructor<? extends SorterTesterInterface> ctor = elem.getConstructor();
            return ctor.newInstance();
        }
        catch ( InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ignored )
        {

        }
        return null;
    }
}
