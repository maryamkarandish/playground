package com.swedbank.game.report;

import com.swedbank.game.beans.EquipmentUtilizingReport;
import com.swedbank.game.beans.LogReport;
import com.swedbank.game.beans.PercentageOfUsageReport;
import com.swedbank.game.components.Factory;
import com.swedbank.game.components.PlayGroundSite;
import com.swedbank.game.components.equipment.Equipment;
import com.swedbank.game.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by maryam on 10/5/2018.
 */
@Component
public class ReportEngine {
    private final static String DATE_TIME_FORMAT = "yyyy-MM-dd' 'HH:mm:ss";
    private final static String TIME_FORMAT = "HH:mm:ss";

    @Autowired private PlayGroundSite playGroundSite;

    public List<EquipmentUtilizingReport> getEquipmentUtilizingReport() {
        SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);

        List<EquipmentUtilizingReport> result = new ArrayList<>();
        for (Equipment item : this.playGroundSite.getEquipmentList()) {
            EquipmentUtilizingReport report = new EquipmentUtilizingReport();
            report.setEquipmentName(this.playGroundSite.findEquipment(item.getId()).getName());
            report.setEquipmentId(item.getId());
            long time = Factory.createEquipmentLogManager().getLogList()
                    .stream().filter(a-> a.getEquipmentId().equals(item.getId()))
                    .collect(Collectors.summingLong(a-> a.getDuringTime().getTime()));
            report.setUtilizingTime(timeFormat.format(new Timestamp(time)));
            result.add(report);
        }

        return result;
    }

    public List<PercentageOfUsageReport> getPercentageOfReport() {
        List<PercentageOfUsageReport> result = new ArrayList<>();
        for (Equipment item : this.playGroundSite.getEquipmentList()) {
            long sumOfCapacity = Factory.createEquipmentLogManager().getLogList().stream()
                    .filter(a-> a.getEquipmentId().equals(item.getId()))
                    .collect(Collectors.summingLong(a-> a.getMaximumEquipmentCapacity()));

            long sumOfKids = Factory.createEquipmentLogManager().getLogList().stream()
                    .filter(a-> a.getEquipmentId().equals(item.getId()))
                    .collect(Collectors.counting());

            PercentageOfUsageReport report = new PercentageOfUsageReport();
            Equipment equipment = this.playGroundSite.findEquipment(item.getId());
            report.setEquipmentName(equipment.getName());
            report.setEquipmentId(item.getId());
            report.setUsage(this.calculatePercentage(sumOfCapacity, sumOfKids));
            result.add(report);
        }

        return result;
    }

    public List<LogReport> fetchLog() {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);

        List<LogReport> result = new ArrayList<>();
        for (Log item : Factory.createEquipmentLogManager().getLogList()) {
            LogReport report = new LogReport();
            report.setAge(item.getAge());
            report.setEquipmentId(item.getEquipmentId());
            if(item.getAddedToQueue() != null)
                report.setAddedToQueue(dateTimeFormat.format(item.getAddedToQueue()));

            if(item.getDuringTime() != null)
                report.setDuringTime(timeFormat.format(item.getDuringTime()));

            if(item.getEndDate() != null)
                report.setEndDate(dateTimeFormat.format(item.getEndDate()));

            report.setEquipmentName(item.getEquipmentName());
            report.setMaximumEquipmentCapacity(item.getMaximumEquipmentCapacity());

            if(item.getStartDate() != null)
                report.setStartDate(dateTimeFormat.format(item.getStartDate()));

            report.setTicketNo(item.getTicketNo());
            report.setName(item.getName());
            result.add(report);
        }

        return result;
    }

    private String calculatePercentage(long capacity, long kids) {
        if(capacity == 0)
            return "0%";

        double result = (100 / capacity) * kids;
        return result + "%";
    }
}
