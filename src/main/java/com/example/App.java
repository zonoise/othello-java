package com.example;

import com.example.cui.Cui;
import com.example.model.Board;
import com.example.model.Game;
import com.example.model.Point;
import com.example.model.command.GetPutableCellCommand;
import com.example.model.command.InitializeCommand;
import com.example.model.command.PutCommand;
import com.example.model.command.util.Reverser;

/**
 * Hello world!
 */
public class App 
{

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


    public static void main( String[] args )
    {
        try {
            sub3();
        }catch (Exception e){

        }

    }

    public static void sub3() throws Exception{

        Board board = new Board();
        board.init();
        Game game = new Game(board);
        game.setStatus(Game.STATUS_BLACK);
        game.run(new InitializeCommand());

        Cui cui = new Cui(game);
        cui.run();

    }

    public static void sub() throws Exception{

        Board board = new Board();
        board.init();
        Game game = new Game(board);
        game.setStatus(Game.STATUS_BLACK);
        game.run(new InitializeCommand());

        game.setStatus(Game.STATUS_WHITE);
        game.run(new PutCommand(new Point(2, 3)));

        game.setStatus(Game.STATUS_WHITE);
        game.run(new PutCommand(new Point(1, 3)));


        String s2 = board.toDetailString();
        System.out.println(s2);

        Reverser reverser= new Reverser(board,new Point(0,3),Board.BLACK);
        reverser.reversed();
    }

    public static void sub2() throws Exception{

        Board board = new Board();
        board.init();
        Game game = new Game(board);
        game.setStatus(Game.STATUS_BLACK);
        game.run(new InitializeCommand());

        game.run(new GetPutableCellCommand());


//        game.setStatus(Game.STATUS_WHITE);
//        game.run(new PutCommand(new Point(2, 3)));
//
//        game.setStatus(Game.STATUS_WHITE);
//        game.run(new PutCommand(new Point(1, 3)));
//
//        game.run(new PutCommand(new Point(0, 3)));
//
//        game.run(new PutCommand(new Point(4, 2)));
//
//        String s2 = board.toDetailString();
//        System.out.println(s2);

    }


}
