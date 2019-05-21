package com.swedbank.game.components;

import com.swedbank.game.components.equipment.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maryam on 10/5/2018.
 */
@Component
public class Factory {
    private List<Equipment> equipmentList;
    private static EquipmentLogManager equipmentLogManager;

    static {
        equipmentLogManager = new EquipmentLogManager();
    }

    public Equipment createFactory(int equipmentType)
            throws Exception {
        if(BallPitPlay.TYPE == equipmentType)
            return new BallPitPlay();
        else if(Carousel.TYPE == equipmentType)
            return new Carousel();
        else if(Slide.TYPE == equipmentType)
            return new Slide();
        else if(Swing.TYPE == equipmentType)
            return new Swing();
        else
            throw new Exception("Equipment that requested is invalid");
    }

    public List<Equipment> fetchEquipmentList() {
        try {
            if (this.equipmentList == null) {
                this.equipmentList = new ArrayList<>();

                this.equipmentList.add(this.createFactory(BallPitPlay.TYPE));
                this.equipmentList.add(this.createFactory(Carousel.TYPE));
                this.equipmentList.add(this.createFactory(Slide.TYPE));
                this.equipmentList.add(this.createFactory(Swing.TYPE));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return this.equipmentList;
    }

    public static EquipmentLogManager createEquipmentLogManager() {
        return equipmentLogManager;
    }
}
