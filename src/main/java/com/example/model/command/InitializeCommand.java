package com.example.model.command;

import com.example.model.Board;
import com.example.model.Game;
import com.example.model.result.ContinueResult;

/**
 * Created by zonoise on 2016/02/15.
 * 最初の4個を置くコマンド
 */
public class InitializeCommand extends Command {

    public InitializeCommand() {
    }

    public ContinueResult execute(Game game){
        Board board = game.getBoard();
        try {

            board.putBlack(4,3);
            board.putBlack(3,4);
            board.putWhite(4, 4);
            board.putWhite(3, 3);

        }catch (Exception e){

        }
        return new ContinueResult();

    }
}
