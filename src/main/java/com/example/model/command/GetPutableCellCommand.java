package com.example.model.command;

import com.example.model.Board;
import com.example.model.Game;
import com.example.model.Point;
import com.example.model.command.util.Reverser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zonoise on 2016/02/19.
 */
public class GetPutableCellCommand extends Command{

    @Override
    public void execute(Game game) throws Exception {

          List<Point> list = putable(game);
        
    }

    public List<Point> putable(Game game) throws Exception {
        final Board board = game.getBoard();
        final Integer color;

        if(Game.STATUS_BLACK == game.getStatus()){
            color = Board.BLACK;
        }else if(Game.STATUS_WHITE == game.getStatus()){
            color = Board.WHITE;
        }else {
            throw new Exception();
        }
        List<Point> resultPoints = new ArrayList<Point>();
        Board debug = new Board(board);

        //あいているセルに駒を置いてみて、裏返るセルがあるなら、そこはおけるセル。
        for (int x = 0; x < 8; x++){
            for (int y = 0; y < 8;y++){
                Point point = new Point(x,y);
                if(Board.EMPTY == board.getValue(point)){
                    Reverser reverser = new Reverser( board ,point ,color );
                    List<Point> points = reverser.reversed();
                    if(points.size()>0){
                        resultPoints.add(point);
                        debug.setValue(new Point(point), Board.PUTTABLE);
                    }
                }
            }
        }
        return resultPoints;
    }

}
