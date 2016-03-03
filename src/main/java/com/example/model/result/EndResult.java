package com.example.model.result;

import com.example.model.Game;

/**
 * Created by zonoise on 2016/02/24.
 */
public class EndResult extends CommandResult {
    @Override
    public int getType() {
        return this.END;
    }
    @Override
    public String renderCui(Game game) {
        return "END";
    }
}
