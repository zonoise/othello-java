package com.example.model.result;

import com.example.model.Board;
import com.example.model.Game;

/**
 * Created by zonoise on 2016/03/03.
 */
public class HintResult extends CommandResult{

    Board board;

    public HintResult(Board board) {
        this.board = board;
    }

    @Override
    public int getType() {
        return HINT;
    }
    @Override
    public String renderCui(Game game) {
        System.out.print("renderCUI");
        return board.toDetailString();
    }
}
