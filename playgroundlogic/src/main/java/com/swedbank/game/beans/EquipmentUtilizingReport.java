package com.swedbank.game.beans;

import java.io.Serializable;

/**
 * Created by maryam on 10/6/2018.
 */
public class EquipmentUtilizingReport implements Serializable {
    private String equipmentId;
    private String equipmentName;
    private String utilizingTime;

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getUtilizingTime() {
        return utilizingTime;
    }

    public void setUtilizingTime(String utilizingTime) {
        this.utilizingTime = utilizingTime;
    }
}
