package org.example.sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SorterAllTester
{
    @Test
    void testAllTests()
    {
        List<SorterTesterInterface> sorterTesters = new ArrayList<>();

        sorterTesters.add( new SorterBubbleTest() );
        sorterTesters.add( new SorterMergeTest() );
        sorterTesters.add( new SorterQuickSortTest() );
        sorterTesters.add( new SorterHeapTest() );
        sorterTesters.add( new SorterSelectionTest() );
        sorterTesters.add( new SorterInsertionTest() );

        sorterTesters.forEach( SorterTesterInterface::testSorter );
    }
}
