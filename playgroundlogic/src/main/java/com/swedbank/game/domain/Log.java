package com.swedbank.game.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by maryam on 10/4/2018.
 */
public class Log {
    private String equipmentId;
    private String equipmentName;
    private String name;
    private Date addedToQueue;
    private Date startDate;
    private Date endDate;
    private Timestamp duringTime;
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

    public Date getAddedToQueue() {
        return addedToQueue;
    }

    public void setAddedToQueue(Date addedToQueue) {
        this.addedToQueue = addedToQueue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Timestamp getDuringTime() {
        return duringTime;
    }

    public void setDuringTime(Timestamp duringTime) {
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
