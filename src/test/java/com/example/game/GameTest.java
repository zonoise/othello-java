package com.example.game;

import com.example.model.Board;
import com.example.model.Point;
import com.example.model.Game;
import com.example.model.command.GetPutableCellCommand;
import com.example.model.result.CommandResult;
import junit.framework.TestCase;

/**
 * Created by zonoise on 2016/02/19.
 */
public class GameTest extends TestCase
{
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testGameEndFullCell() throws Exception{
        Board board = new Board();
        board.init();
        //すべてのマスを埋める
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                board.setValue(new Point(x,y),Board.BLACK);
            }
        }
        Game game  = new Game(board);
        game.setStatus(Game.STATUS_BLACK);
        CommandResult result = game.run(new GetPutableCellCommand());
        assertEquals(CommandResult.END, result.getType());
    }

    public void testGameEndNoPutableCell() throws Exception{
        Board board = new Board();
        board.init();
        //すべてのマスを埋める
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                board.setValue(new Point(x,y),Board.BLACK);
            }
        }
        board.setValue(new Point(7,7),Board.EMPTY);
        Game game  = new Game(board);
        game.setStatus(Game.STATUS_BLACK);
        CommandResult result = game.run(new GetPutableCellCommand());
        assertEquals(CommandResult.END, result.getType());
    }
}