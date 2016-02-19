package com.example.model.command.util;

import com.example.model.Board;
import com.example.model.Point;
import junit.framework.TestCase;

/**
 * Created by zonoise on 2016/02/19.
 */
public class ReverserTest extends TestCase {
    /*
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 W B 0 0 0
0 0 0 B W 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
 */

    public void test1(){

        try {
            Board board = new Board();
            board.init();
            board.putBlack(4, 3);
            board.putBlack(3, 4);
            board.putWhite(4, 4);
            board.putWhite(3, 3);

            Point point = new Point(2,5);
            Integer color = Board.BLACK;
            Reverser reverser = new Reverser(board, point, color );
            System.out.print(reverser.reversed());
            System.out.print(reverser.reversed().size());

        }catch (Exception e){

        }
    }
}
