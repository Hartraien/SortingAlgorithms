package org.example.sorting;

import org.example.sorting.sortertestermain.SorterTester;
import org.junit.jupiter.api.Test;

class SorterHeapTest implements SorterTesterInterface
{

    @Test
    @Override
    public void testSorter()
    {
        SorterTester tester = new SorterTester();
        tester.testSorter( new SorterHeap() );
    }
}