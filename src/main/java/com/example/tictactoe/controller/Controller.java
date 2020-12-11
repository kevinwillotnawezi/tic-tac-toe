package com.example.tictactoe.controller;


import com.example.tictactoe.business.Game;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Game game;

    public void play(){
        game.play();
    }
}
