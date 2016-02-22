package com.example.model;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

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

    public void testContain() {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,2);
        List<Point> list =new ArrayList<Point>();
        list.add(p1);
        list.add(p2);
        assertEquals(true,
                list.contains(new Point(1,1)));
    }
}
