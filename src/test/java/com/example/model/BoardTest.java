package com.example.model;

import junit.framework.TestCase;

/**
 * Created by zonoise on 2016/02/17.
 */
public class BoardTest  extends TestCase {

    private Board board;
    public void setUp() throws Exception {
        super.setUp();
        board = new Board();
        board.init();
    }

    public void testAllEmpty() throws Exception {
        final int MaxX = 8;
        final int MaxY = 8;

        for(int y = 0;y < MaxY;y++){
            for(int x = 0;x < MaxX;x++){
                Integer c = board.getValue(new Point(x, y));
                assertEquals(Board.EMPTY , c);
            }
        }
    }
}
