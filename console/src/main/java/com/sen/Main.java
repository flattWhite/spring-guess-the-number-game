package com.sen;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        // create context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // get number generator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        // call method next() to get a random number
        int number = numberGenerator.next();

        // log generated number
        log.info("number = " + number);

        // get game bean from context (container)
        Game game = context.getBean(Game.class);

        // call reset method
        game.reset();

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info(messageGenerator.getMainMessage());
        log.info(messageGenerator.getResultMessage());

        // close context (container)
        context.close();


    }
}
