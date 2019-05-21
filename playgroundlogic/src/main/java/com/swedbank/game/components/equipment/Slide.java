package com.swedbank.game.components.equipment;

import org.springframework.stereotype.Component;

/**
 * Created by maryam on 10/3/2018.
 */
@Component
public class Slide extends Equipment {
    public final static int TYPE = 3;
    public final static String NAME = "Slide";
    private final static int CAPACITY = 1;

    public Slide() {
        super(TYPE, NAME, CAPACITY);
    }
}
