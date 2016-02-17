package com.example.model;

import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * Created by zonoise on 2016/02/15.
 */
public class Board {
    public static final Integer BLACK = 1;
    public static final Integer WHITE = 2;
    public static final Integer EMPTY = 5;

    private HashMap<Point,Integer> data;

    public Board() {
    }

    public Board(Board b) {
        this.data = b.data;
    }

    public void init(){
        this.data = new HashMap<Point,Integer>();
        IntStream.range(0,8).forEach(i -> {
            IntStream.range(0, 8).forEach(j -> {
                this.data.put(new Point(i, j),EMPTY);
            });
        });

    }

    public void putWhite(int x,int y) throws Exception{
        if(!this.isPutable(x,y)){
            throw new Exception("");
        }
        this.setValue(new Point(x, y), WHITE);
    }

    public void putBlack(int x,int y) throws Exception{
        if(!this.isPutable(x,y)){
            throw new Exception("");
        }
        this.setValue(new Point(x,y),BLACK);
    }

    private Boolean isPutable(int x,int y){
        Integer value = this.getValue(new Point(x, y));
        return EMPTY == value ? true : false;
    }

    public void detectDeadPointFrom(Point point){
        //getOffsetValue(point,
    }

    /**
     * 与えられた点 point から、x,y 移動した点のvalueを取得する
     *
     * @param point
     * @param x
     * @param y
     * @return
     * @throws Exception
     */
    private Integer getOffsetValue(Point point,int x ,int y){
        return this.data.get(new Point(point.getX()+x ,point.getY() + y));
    }

    public Integer getValue(Point point){
        return this.data.get(new Point(point.getX(),point.getY()));
    }

    public void setValue(Point point,Integer value){
        this.data.replace(point,value);
    }

    @Override
    public String toString() {
        return "Board{" +
                "data=" + data +
                '}';
    }

    public String toDetailString(){
        StringBuffer sb = new StringBuffer();

        //this.data = new HashMap<Point,Integer>();
        IntStream.range(0,8).forEach(y -> {
            IntStream.range(0, 8).forEach(x -> {
                Integer v = this.data.get(new Point(x, y));
                if(v == WHITE){
                    sb.append('W');
                }else if (v == BLACK){
                    sb.append('B');
                }else if (v == EMPTY){
                    sb.append('.');
                }else{
                    sb.append(v);
                }

            });
            sb.append('\n');
        });
        return sb.toString();
    }

}
