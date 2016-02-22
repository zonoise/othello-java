package com.example.model.command.util;

import com.example.model.Board;
import com.example.model.Point;

import java.util.LinkedList;

/**
 * Created by zonoise on 2016/02/16.
 */
public class ReverseQueue{

    private LinkedList<Integer> buffer;

    private LinkedList<Point> buffer2;
    private int index = 0;
    private Integer pushedColor;
    private Integer lastColor;
    private Integer beforeColor;// color before cursor

    public ReverseQueue(Integer pushedColor) {
        this.pushedColor = pushedColor;
        buffer = new LinkedList<Integer>();
        buffer2 = new LinkedList<Point>();
    }

    public boolean push(Point point,Integer color){
        if(pushedColor ==Board.WHITE && color == Board.BLACK){
            lastColor = color;
            buffer2.addLast(point);
            buffer.addLast(color);
            return true;
        } else if( pushedColor == Board.BLACK && color == Board.WHITE ){
            lastColor = color;
            buffer2.addLast(point);
            buffer.addLast(color);
            return true;
        }else if (color == pushedColor){
            lastColor = color;
            //buffer2.addLast(point);
            //buffer.addLast(color);
            return false;
        }else{
            return false;
        }
    }

    public int reverseNumber(){
        return buffer.size();
    }

    public boolean isReverse(){
        return pushedColor == lastColor;
    }
    public LinkedList<Point> getPoints() {
        return buffer2;
    }
}
