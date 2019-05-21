package com.swedbank.game.components;

import com.swedbank.game.components.equipment.Equipment;
import com.swedbank.game.domain.Kid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maryam on 10/3/2018.
 */
@Component
public class PlayGroundSite {
    private List<Equipment> equipmentList;
    private List<Kid> kidList;

    @Autowired private Factory factory;

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public List<Kid> getKidList() {
        return kidList;
    }

    public void add(int type)
            throws Exception {
        if(this.equipmentList == null)
            this.equipmentList = new ArrayList<>();

        this.equipmentList.add(this.factory.createFactory(type));
    }

    public void remove(String equipmentId) {
        if(this.equipmentList != null)
            this.equipmentList.remove(this.findEquipment(equipmentId));
    }

    public void enter(Kid kid) {
        if(this.kidList == null)
            this.kidList = new ArrayList<>();

        this.kidList.add(kid);
    }

    public void exit(String ticketNo) {
        if(this.kidList != null && this.kidList.size() > 0)
            this.kidList.remove(this.findKid(ticketNo));
    }

    public void start(String equipmentId)
            throws Exception {
        this.findEquipment(equipmentId).start();
    }

    public void end(String equipmentId) {
        this.findEquipment(equipmentId).end();
    }

    public void addQueue(String equipmentId, String ticketNo)
            throws Exception {
        this.findEquipment(equipmentId).addQueue(this.findKid(ticketNo));
    }

    public void removeQueue(String equipmentId, String ticketNo) {
        this.findEquipment(equipmentId).removeQueue(this.findKid(ticketNo));
    }

    private Kid findKid(String ticketNo) {
        return this.kidList.stream().filter(a-> a.getTicketNo().equals(ticketNo)).findFirst().get();
    }

    public Equipment findEquipment(String id) {
        return this.equipmentList.stream().filter(a-> a.getId().equals(id)).findFirst().get();
    }
}
