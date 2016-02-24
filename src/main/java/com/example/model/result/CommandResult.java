package com.example.model.result;

/**
 * Created by zonoise on 2016/02/15.
 */
abstract public class CommandResult {
    public static final int CONTINUE = 80;
    public static final int END = 99;
    abstract public int getType();
}