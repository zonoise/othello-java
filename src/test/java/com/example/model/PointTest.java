package com.example.model;

import junit.framework.TestCase;

/**
 * Created by zonoise on 2016/02/17.
 */
public class PointTest extends TestCase
{
    public void testCompare() throws Exception {
        Point p1 = new Point(1,2);
        Point p2 = new Point(1,2);
        assertEquals(p1,p2);
    }


}
