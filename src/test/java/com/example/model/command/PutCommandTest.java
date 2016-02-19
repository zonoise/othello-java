package com.example.model.command;

import com.example.model.Board;
import com.example.model.Game;
import com.example.model.Point;
import junit.framework.TestCase;

/**
 * Created by zonoise on 2016/02/19.
 */
public class PutCommandTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }


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
    public Game put(int x,int y){
        Board board = new Board();
        board.init();
        Game game = new Game(board);
        game.run(new InitializeCommand());
        return game;
//        Point point = new Point(x,y);
//        PutCommand p = new PutCommand(point);
//        game.run(p);
//        //p.execute(game);
//        return game;
    }

    public void test1(){
        Game game = put(2,3);
        String after = game.getBoard().toDetailString();
        System.out.println(after);
        String expect =
        "0 0 0 0 0 0 0 0\n" +
        "0 0 0 0 0 0 0 0\n" +
        "0 0 0 0 0 0 0 0\n" +
        "0 0 0 W B 0 0 0\n" +
        "0 0 0 B W 0 0 0\n" +
        "0 0 0 0 0 0 0 0\n" +
        "0 0 0 0 0 0 0 0\n" +
        "0 0 0 0 0 0 0 0\n";
        assertEquals(expect,after);
    }

    public void test2(){
        int x = 2;
        int y = 3;
        Board board = new Board();
        board.init();
        Game game = new Game(board);
        game.run(new InitializeCommand());
        Point point = new Point(x,y);
        PutCommand p = new PutCommand(point);
        game.run(p);
        //p.execute(game);
        //return game;
    }
}
