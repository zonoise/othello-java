package com.example.model;

import com.example.model.command.Command;

/**
 * Created by zonoise on 2016/02/15.
 */
public class Game {
    private Board board;
    private int status;
    public static final int STATUS_WHITE = 1;
    public static final int STATUS_BLACK = 2;

    //受付中
    //置いた
    //裏返せるマスを
    public Game(Board board) {
        this.board = board;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public CommandResult run(Command command) throws Exception{
        command.execute(this);
        CommandResult c = new CommandResult();
        return c;
    }

    public String boardText(){
        return board.toDetailString();
    }

}
