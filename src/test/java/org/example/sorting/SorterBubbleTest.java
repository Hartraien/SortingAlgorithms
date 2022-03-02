package org.example.sorting;

import org.example.sorting.sortertestermain.SorterTester;
import org.junit.jupiter.api.Test;

class SorterBubbleTest implements SorterTesterInterface
{

    @Test
    public void testSorter()
    {
        SorterTester tester = new SorterTester();
        tester.testSorter( new SorterBubble() );
    }
}