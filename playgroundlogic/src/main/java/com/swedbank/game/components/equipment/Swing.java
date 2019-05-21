package com.swedbank.game.components.equipment;

import org.springframework.stereotype.Component;

/**
 * Created by maryam on 10/3/2018.
 */
@Component
public class Swing extends Equipment {
    public final static int TYPE = 4;
    public final static String NAME = "Swing";
    private final static int CAPACITY = 2;

    public Swing() {
        super(TYPE, NAME, CAPACITY);
    }
}
