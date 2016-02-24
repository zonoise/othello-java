package com.example.model.command;

import com.example.model.Board;
import com.example.model.Game;
import com.example.model.result.CommandResult;

/**
 * Created by zonoise on 2016/02/15.
 */
abstract public class Command {
    abstract public CommandResult execute(Game game) throws Exception;
}
