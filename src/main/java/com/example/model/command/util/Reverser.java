package com.example.model.command.util;

import com.example.model.Board;
import com.example.model.Point;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zonoise on 2016/02/16.
 */
public class Reverser {
    private final Board board;
    private final Point point;
    private final Integer color; //Colorもどうにかしたい

    public Reverser(Board board, Point point, Integer color) {
        this.board = board;
        this.point = point;
        this.color = color;
    }

    public List reversed(){

//        System.out.println("reversed start");

        LinkedList<Point> list = new LinkedList<Point>();
        list.addAll(this.reversePoint(0, 1)); //12:00

        list.addAll(this.reversePoint(1, 1)); //1:30
        list.addAll(this.reversePoint(1, 0)); //3:00
        list.addAll(this.reversePoint(1, -1)); //4:39
        list.addAll(this.reversePoint(-1, 0)); //6:00
        list.addAll(this.reversePoint(-1, -1)); //7:30
        list.addAll(this.reversePoint(-1, 0)); //9:00
        list.addAll(this.reversePoint(-1, -1)); //10:30
        list.forEach(c -> {
            System.out.println("X:" + c.getX() + "Y:" + c.getY());
        });

        return list;
    }


    private List<Point> reversePoint(int directX,int directY){

        Point p = new Point(point);

        ReverseQueue queue = new ReverseQueue(color);
        boolean status = false;
        do {
            p.translate(directX, directY);
            Integer i = board.getValue(p);
            System.out.print(i);
            status = queue.push(new Point(p),i);

        } while (status)  ;

        return queue.getPoints();
    }

}
