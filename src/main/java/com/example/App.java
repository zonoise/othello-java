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


    public static void main( String[] args ) throws Exception
    {
            Board board = new Board();
            board.init();
            Game game = new Game(board);
            game.setStatus(Game.STATUS_BLACK);
            game.run(new InitializeCommand());

            Cui cui = new Cui(game);
            cui.run();
    }

}
