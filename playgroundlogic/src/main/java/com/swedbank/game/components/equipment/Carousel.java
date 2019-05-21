package com.swedbank.game.components.equipment;

import org.springframework.stereotype.Component;

/**
 * Created by maryam on 10/3/2018.
 */
@Component
public class Carousel extends Equipment {
    public final static int TYPE = 2;
    public final static String NAME = "Carousel";
    private final static int CAPACITY = 20;

    public Carousel() {
        super(TYPE, NAME, CAPACITY);
    }
}
