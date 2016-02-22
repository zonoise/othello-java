package com.example.model.command.util;

import com.example.model.Board;
import com.example.model.Point;
import junit.framework.TestCase;

/**
 * Created by zonoise on 2016/02/19.
 */
public class ReverseQueueTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void test1(){
        ReverseQueue queue = new ReverseQueue(Board.BLACK);
        assertEquals(true,queue.push(new Point(0, 0), Board.WHITE));
        assertEquals(false, queue.push(new Point(0, 1), Board.BLACK));
        assertEquals(1, queue.getPoints().size());
    }

    public void test2(){
        ReverseQueue queue = new ReverseQueue(Board.BLACK);
        assertEquals(false,queue.push(new Point(1, 1), Board.BLACK));
        //assertEquals(false, queue.push(new Point(1, 1), Board.BLACK));
//        assertEquals(false, queue.push(new Point(1, 1), Board.EMPTY));

        assertEquals(0,queue.getPoints().size());
    }

}
