package com.example.model.command.util;

import com.example.model.Board;
import com.example.model.Point;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by zonoise on 2016/02/16.
 */
public class ReverseQueue{

    private LinkedList<Integer> buffer;

    private LinkedList<Point> buffer2;
    private int index = 0;
    private Integer pushedColor;
    private Integer nextColor;
    private Integer beforeColor;// color before cursor

    public ReverseQueue(Integer pushedColor) {
        this.pushedColor = pushedColor;
        buffer = new LinkedList<Integer>();
        buffer2 = new LinkedList<Point>();

    }

    public boolean push(Point point,Integer color){
        if(color == Board.BLACK || color == Board.WHITE){

        }else{return false;}

        if(color == pushedColor){
            //隣が同じ色なら終わり
            return false;
        }else{
            nextColor = color;
            buffer2.addLast(point);
            buffer.addLast(color);
            return true;
        }
    }

    public int reverseNumber(){
        return buffer.size();
    }

    public LinkedList<Point> getPoints() {
        return buffer2;
    }
}
