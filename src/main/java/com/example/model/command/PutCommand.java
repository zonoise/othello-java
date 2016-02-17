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
    //private Board board;

    public PutCommand(Point point) {
        this.point = point;

    }

    public void execute(Game game){
        Integer color = null;
        if(Game.STATUS_BLACK == game.getStatus()){
            color = Board.BLACK;
        }else if (Game.STATUS_WHITE == game.getStatus()){
            color = Board.WHITE;
        }else{
            //error
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
//
//        try {
//
//            Board board = game.getBoard();
//
//
//            if(Game.STATUS_BLACK == game.getStatus()){
//                board.putBlack(point.getX(),point.getY());
//
//                Point workPoint = new Point(point.getX(),point.getY());
//
//                int directionX = 1;
//                int directionY = 0;
//                boolean is_reverse = false;
//                ArrayList<Point> arrayList = new ArrayList<Point>();
//
//                //
//                workPoint.translate(directionX, directionY);
//                Integer nextColor = board.getValue(workPoint);
//                if (nextColor == Board.WHITE) {
//                    System.out.print('W');
//
//                    arrayList.add( new Point(workPoint) );
//                }else{
//                    System.out.println("隣が同じ色なら終わり");
//
//                    //隣が同じ色なら終わり
//                }
//
//                //隣の隣から見ていく
//
//                while (true){
//                    workPoint.translate(directionX, directionY);
//
//                    if (Board.WHITE == board.getValue(workPoint)) {
//                        arrayList.add(new Point(workPoint));
//                    }else if(Board.BLACK == board.getValue(workPoint) ){
//                        System.out.println('B');
//                        System.out.println(arrayList.toString());
//                        //黒にあたったので裏かえすやつがある
//                        is_reverse = true;
//                        break;
//                    }else{
//                        //裏返すものがない
//                        break;
//                    }
//                }
//
//                if(is_reverse){
//                    arrayList.forEach(point -> {
//                        board.setValue(point,Board.BLACK);
//                    });
//                }
//
//                game.setStatus(Game.STATUS_WHITE);
//            }else if(Game.STATUS_WHITE == game.getStatus()){
//                board.putWhite(point.getX(),point.getY());
//                game.setStatus(Game.STATUS_BLACK);
//            }
//        }catch (Exception e){
//
//        }
    }
}
