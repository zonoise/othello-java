package com.example.model.command;

import com.example.model.Board;
import com.example.model.Game;
import com.example.model.Point;
import junit.framework.TestCase;

/**
 * Created by zonoise on 2016/02/19.
 */
public class GetPutableCellCommandTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void test1(){
        try {
            Board board = new Board();
            board.init();
            Game game = new Game(board);
            game.setStatus(Game.STATUS_BLACK);
            game.run(new InitializeCommand());
            game.run(new GetPutableCellCommand());

        }catch (Exception e){

        }

        assertEquals(1,1);
    }
}
