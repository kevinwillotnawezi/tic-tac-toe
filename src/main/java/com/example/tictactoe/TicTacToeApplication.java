package com.example.tictactoe;

import com.example.tictactoe.business.Game;
import com.example.tictactoe.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory
			.getLogger(TicTacToeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeApplication.class, args);
	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");

		Game game = new Game();

//		Controller controller = new Controller();

		game.play();
	}
}
