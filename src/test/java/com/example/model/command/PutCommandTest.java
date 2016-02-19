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
    try {
        Board board = new Board();
        board.init();
        Game game = new Game(board);
        game.setStatus(Game.STATUS_BLACK);
        game.run(new InitializeCommand());
        //return game;
        Point point = new Point(x, y);
        PutCommand p = new PutCommand(point);
        game.run(p);
        //p.execute(game);
        return game;
}catch (Exception e){
    return null;
}
    }

    public void test1(){
        Game game = put(2,3);
        String after = game.getBoard().toDetailString();
        System.out.println(after);
        String expect =
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 B B B 0 0 0 \n" +
            "0 0 0 B W 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n";
        assertEquals(expect,after);
    }

    public void test2() throws Exception{
        Game game = put(3,2);
        String after = game.getBoard().toDetailString();
        System.out.println(after);
        String expect =
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 B 0 0 0 0 \n" +
            "0 0 0 B B 0 0 0 \n" +
            "0 0 0 B W 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n";
        assertEquals(expect,after);
    }


    public void test3() throws Exception{
        Game game = put(5,4);
        String after = game.getBoard().toDetailString();
        System.out.println(after);
        String expect =
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 W B 0 0 0 \n" +
            "0 0 0 B B B 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n" +
            "0 0 0 0 0 0 0 0 \n";
        assertEquals(expect,after);
    }

    public void test4() throws Exception{
        Game game = put(2,5);
        String after = game.getBoard().toDetailString();
        System.out.println(after);
        String expect =
                "0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 W B 0 0 0 \n" +
                        "0 0 0 B B B 0 0 \n" +
                        "0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 \n";
        assertEquals(expect,after);
    }
}
