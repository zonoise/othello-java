package com.example.model.command;

import com.example.model.Board;
import com.example.model.Game;
import com.example.model.Point;
import com.example.model.command.util.Reverser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zonoise on 2016/02/15.
 */
public class PutCommand extends Command {
    private Point point;

    public PutCommand(Point point) {
        this.point = point;

    }

    public void execute(Game game) throws Exception{
        Integer color = null;
        if(Game.STATUS_BLACK == game.getStatus()){
            color = Board.BLACK;
        }else if (Game.STATUS_WHITE == game.getStatus()){
            color = Board.WHITE;
        }else{
            throw new Exception("unknown status");
        }

        //裏返す
        Board board = game.getBoard();
        Reverser reverser = new Reverser( board ,point ,color );
        List<Point> points = reverser.reversed();

        for(Point p:points ){
            board.setValue(p,color);
        }

        //置く
        board.setValue(point,color);

        if(Game.STATUS_BLACK == game.getStatus()){
            game.setStatus(Game.STATUS_WHITE);
        }else if (Game.STATUS_WHITE == game.getStatus()){
            game.setStatus(Game.STATUS_BLACK);
        }
        return;
    }
}