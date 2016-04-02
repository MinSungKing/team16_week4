package org.team16.team16week4;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BillTest extends TestCase{

	public BillTest(String testName)
	{
		super(testName);
	}
    public static Test suite()
    {
        return new TestSuite( BillTest.class );
    }
    public void testApp()
    {
    	String gold = "Gold";
    	String silver = "Silver";
        Bill testBill = new Bill(gold, 878, 4);
        assertEquals(83.95,testBill.drawBill(),0.01);
        testBill = new Bill(gold, 1123, 1);
        assertEquals(105.3,testBill.drawBill(),0.01);
        testBill = new Bill(gold, 1123, 4);
        assertEquals(139.3,testBill.drawBill(),0.01);
        testBill = new Bill(silver, 523, 2);
        assertEquals(63.87,testBill.drawBill(),0.01);
        testBill = new Bill(silver, 44, 5);
        assertEquals(82.95,testBill.drawBill(),0.01);
        testBill = new Bill(silver, 521, 5);
        assertEquals(94.29,testBill.drawBill(),0.01);
    }
}