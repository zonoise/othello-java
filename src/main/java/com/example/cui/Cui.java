package com.example.cui;

import com.example.model.Game;
import com.example.model.Point;
import com.example.model.command.Command;
import com.example.model.command.PutCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zonoise on 2016/02/22.
 */
public class Cui {
    private Game game;

    public Cui(Game game) {
        this.game = game;
    }

    public void run() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {

            println(game.getBoard().toDetailString());
            String str = reader.readLine();
            Command command = parse(str);
            game.run(command);
        }
    }

    private Command parse(String str){
        int x = Character.getNumericValue(str.charAt(0));
        int y = Character.getNumericValue(str.charAt(2));
        System.out.println(str);
        System.out.println(x);
        System.out.println(y);

        return new PutCommand(new Point(x,y));
    }
    private static void println(String  str){
        System.out.println(str);
    }
}
