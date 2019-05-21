package com.swedbank.game.model;

/**
 * Created by maryam on 10/5/2018.
 */
public class QueueRequest {
    private String equipmentId;
    private String ticketNo;

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }
}
