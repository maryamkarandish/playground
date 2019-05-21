package com.swedbank.game.beans;

import java.io.Serializable;

/**
 * Created by maryam on 10/7/2018.
 */
public class LogReport implements Serializable {
    private String equipmentId;
    private String equipmentName;
    private String name;
    private String addedToQueue;
    private String startDate;
    private String endDate;
    private String duringTime;
    private String ticketNo;
    private byte age;
    private int maximumEquipmentCapacity;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddedToQueue() {
        return addedToQueue;
    }

    public void setAddedToQueue(String addedToQueue) {
        this.addedToQueue = addedToQueue;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDuringTime() {
        return duringTime;
    }

    public void setDuringTime(String duringTime) {
        this.duringTime = duringTime;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public int getMaximumEquipmentCapacity() {
        return maximumEquipmentCapacity;
    }

    public void setMaximumEquipmentCapacity(int maximumEquipmentCapacity) {
        this.maximumEquipmentCapacity = maximumEquipmentCapacity;
    }
}
