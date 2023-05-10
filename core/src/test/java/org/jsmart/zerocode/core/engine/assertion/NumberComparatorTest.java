package org.jsmart.zerocode.core.engine.assertion;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberComparatorTest {
    
    @BeforeClass
    public static void createNewComparator(){
        NumberComparator comparator = new NumberComparator();
    }

    @Test
    public void shouldCompareTwoNonDecimalNumbers() throws Exception {
        assertThat((new BigDecimal("3")).compareTo(new BigDecimal("3")), is(0));
    }
    @Test
    public void shouldCompareOneDecimalAndNonDecimalNumbers() throws Exception {
        assertThat((new BigDecimal("3.0")).compareTo(new BigDecimal("3")), is(0));
    }
    @Test
    public void shouldCompareNonDecimalAndFourDecimalNumbers() throws Exception {
        assertThat((new BigDecimal("3")).compareTo(new BigDecimal("3.0009")), is(-1));
    }
    @Test
    public void shouldCompareFourDecimalAndOneDecimalNumbers() throws Exception {
        assertThat((new BigDecimal("3.0009")).compareTo(new BigDecimal("3")), is(1));
    }
    @Test
    public void shouldCompareTwoFiveDecimalNumbers() throws Exception {
        assertThat((new BigDecimal("3.00009")).compareTo(new BigDecimal("3.00009")), is(0));
    }
    @Test
    public void shouldCompareIntegerAndLongWithComparator() throws Exception {
        assertThat(comparator.compare(new Integer("3"), new Long("3")), is(0));
    }
    @Test
    public void shouldCompareIntegerAndDoubleWithComparator() throws Exception {
        assertThat(comparator.compare(new Integer("3"), new Double("3.0")), is(0));
    }
    }
}
