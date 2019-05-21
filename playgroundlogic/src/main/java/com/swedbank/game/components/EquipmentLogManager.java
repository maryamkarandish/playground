package com.swedbank.game.components;

import com.swedbank.game.components.equipment.Equipment;
import com.swedbank.game.domain.Log;
import com.swedbank.game.domain.Kid;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by maryam on 10/4/2018.
 */
public class EquipmentLogManager {
    private final static String DATE_TIME_FORMAT = "yyyy-MM-dd' 'HH:mm:ss";
    private final static String TIME_FORMAT = "HH:mm:ss";

    private List<Log> logList = new ArrayList<>();
    private long defaultTime;

    public EquipmentLogManager() {
        this.defaultTime = this.getDefaultTime();
    }

    public List<Log> getLogList() {
        return logList;
    }

    public void addedToQueue(Equipment equipment, Kid kid) {
        Log log = new Log();
        log.setAddedToQueue(new Date(System.currentTimeMillis()));
        log.setEquipmentId(equipment.getId());
        log.setEquipmentName(equipment.getName());
        log.setTicketNo(kid.getTicketNo());
        log.setName(kid.getName());
        log.setAge(kid.getAge());
        log.setMaximumEquipmentCapacity(equipment.getCapacity());
        this.logList.add(log);

        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        String addedToQueue = sdf.format(log.getAddedToQueue());

        System.out.println(String.format("Equipment Name: %s, " +
                        "Ticket No: %s, " +
                        "Kid Name: %s, " +
                        "Is VIP: %s, " +
                        "Added To Queue Time: %s", equipment.getName(), kid.getTicketNo(),
                kid.getName(), kid.isVip(), addedToQueue));
    }

    public void start(Equipment equipment, Kid kid) {
        Log log = this.findLog(equipment.getId(), kid.getTicketNo());
        log.setStartDate(new Date(System.currentTimeMillis()));

        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        String startTime = sdf.format(log.getStartDate());

        System.out.println(String.format("Equipment Name: %s, " +
                "Ticket No: %s, " +
                "Kid Name: %s, " +
                "Is VIP: %s, " +
                "Start Time: %s", equipment.getName(), kid.getTicketNo(),
                kid.getName(), kid.isVip(), startTime));
    }

    public void end(final String equipmentId, Kid kid) {
        Log log = this.findLog(equipmentId, kid.getTicketNo());
        log.setEndDate(new Date(System.currentTimeMillis()));
        long duration = log.getEndDate().getTime() - log.getStartDate().getTime();
        log.setDuringTime(new Timestamp(this.defaultTime + duration));

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);

        String startTime = sdf.format(log.getStartDate());
        String endTime = sdf.format(log.getEndDate());

        System.out.println(String.format("Equipment Name: %s, " +
                        "Ticket No: %s, " +
                        "Kid Name: %s, " +
                        "Is VIP: %s, " +
                        "Start Time: %s, " +
                        "End Time: %s, " +
                        "Duration: %s", log.getEquipmentName(), kid.getTicketNo(),
                kid.getName(), kid.isVip(), startTime,
                endTime, timeFormat.format(log.getDuringTime())));
    }

    private Log findLog(String equipmentId, String ticketNo) {
        return this.logList.stream()
                .filter(a-> a.getEquipmentId() == equipmentId
                        && a.getTicketNo().equals(ticketNo)).findFirst().get();
    }

    private long getDefaultTime() {
        try {
            return new SimpleDateFormat(TIME_FORMAT).parse("00:00:00").getTime();
        } catch (Exception ex) {
            ex.printStackTrace();
            return -12600000;
        }
    }
}
