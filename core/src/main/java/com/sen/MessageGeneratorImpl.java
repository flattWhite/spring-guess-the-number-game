package com.sen;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    private static final Logger log = Logger.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    private int guessCount = 10;

    // == init ==
    @PostConstruct
    public void init(){
        log.info("game " + game);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return "You guessed it! The number was " + game.getNumber();
        }else if((game.isGameLost())){
            return "You lost. The number was " + game.getNumber();
        }else if(!game.isValidNumberRange()){
            return ("Invalid number range!");
        }else if(game.getRemainingGuesses() == guessCount){
            return "What is your first guess?";
        }else{
            String direction = "Lower";

            if(game.getGuess() < game.getNumber()){
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + " guess left.";
        }
    }
}
