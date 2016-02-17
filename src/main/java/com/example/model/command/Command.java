package com.example.model.command;

import com.example.model.Board;
import com.example.model.Game;

/**
 * Created by zonoise on 2016/02/15.
 */
abstract public class Command {
    abstract public void execute(Game game);
}
