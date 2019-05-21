package com.swedbank.game.beans;

/**
 * Created by maryam on 10/7/2018.
 */
public class PercentageOfUsageReport {
    private String equipmentId;
    private String equipmentName;
    private String usage;

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

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
}
