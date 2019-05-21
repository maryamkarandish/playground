package com.swedbank.game.components.equipment;

import org.springframework.stereotype.Component;

/**
 * Created by maryam on 10/3/2018.
 */
@Component
public class BallPitPlay extends Equipment {
    public final static int TYPE = 1;
    public final static String NAME = "Ball Pit Play";
    private final static int CAPACITY = 10;

    public BallPitPlay() {
        super(TYPE, NAME, CAPACITY);
    }
}
