package org.example.sorting;

import org.example.sorting.sortertestermain.SorterTester;
import org.junit.jupiter.api.Test;

class SorterSelectionTest implements SorterTesterInterface
{

    @Test
    @Override
    public void testSorter()
    {
        SorterTester tester = new SorterTester();
        tester.testSorter( new SorterSelection() );
    }
}