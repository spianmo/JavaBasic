package org.spianmo.learn.week7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarketEmployeeTest {

    @Test
    public void print() {
        MarketEmployee marketEmployee = new MarketEmployee("admin");
        marketEmployee.print();
    }

    @Test
    public void getSalary() {
        MarketEmployee marketEmployee = new MarketEmployee("admin");
        int salary = marketEmployee.getSalary();
        assertEquals(3000, salary);
    }
}