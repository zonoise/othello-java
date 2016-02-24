package com.example.model.command;

import com.example.model.Board;
import com.example.model.Game;
import com.example.model.Point;
import com.example.model.command.util.Reverser;
import com.example.model.result.CommandResult;
import com.example.model.result.ContinueResult;
import com.example.model.result.EndResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zonoise on 2016/02/19.
 */
public class GetPutableCellCommand extends Command{

    @Override
    public CommandResult execute(final Game game) throws Exception {

        List<Point> list = putable(game);

        if(0<list.size()){
            return new ContinueResult();
        }else{
            //置く場所がない場合は別の色も試してみて置けるとこがないならEnd
            Game gameAnatherColor = new Game(game);
            if(game.getStatus()==Game.STATUS_BLACK){
                game.setStatus(Game.STATUS_WHITE);
            }else if(game.getStatus()==Game.STATUS_WHITE){
                game.setStatus(Game.STATUS_BLACK);
            }
             if(0 < putable(gameAnatherColor).size()){
                 return new ContinueResult();
             }else {
                 return new EndResult();
             }
        }
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
