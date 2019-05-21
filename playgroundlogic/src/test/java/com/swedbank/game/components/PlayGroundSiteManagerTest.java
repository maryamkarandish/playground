package com.swedbank.game.components;

import com.swedbank.game.beans.EquipmentUtilizingReport;
import com.swedbank.game.beans.PercentageOfUsageReport;
import com.swedbank.game.components.equipment.*;
import com.swedbank.game.domain.Kid;
import com.swedbank.game.report.ReportEngine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by maryam on 10/4/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayGroundSiteManagerTest {
    @Autowired private PlayGroundSite playGroundSite;
    @Autowired private ReportEngine reportEngine;

    private Kid kid1;
    private Kid kid2;
    private Kid kid3;
    private Kid kid4;
    private Kid kid5;
    private Kid kid6;
    private Kid kid7;
    private Kid kid8;
    private Kid kid9;

    @Before
    public void initialize() {
        try {
            this.playGroundSite.add(BallPitPlay.TYPE);
            this.playGroundSite.add(Carousel.TYPE);
            this.playGroundSite.add(Slide.TYPE);
            this.playGroundSite.add(Swing.TYPE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        this.kid1 = new Kid();
        this.kid1.setAge(new Byte("12").byteValue());
        this.kid1.setName("Test1");
        this.kid1.setVip(true);
        this.kid1.setTicketNo("T001");
        this.playGroundSite.enter(this.kid1);

        this.kid2 = new Kid();
        this.kid2.setAge(new Byte("13").byteValue());
        this.kid2.setName("Test2");
        this.kid2.setVip(false);
        this.kid2.setTicketNo("T002");
        this.playGroundSite.enter(this.kid2);

        this.kid3 = new Kid();
        this.kid3.setAge(new Byte("14").byteValue());
        this.kid3.setName("Test3");
        this.kid3.setVip(false);
        this.kid3.setTicketNo("T003");
        this.playGroundSite.enter(this.kid3);

        this.kid4 = new Kid();
        this.kid4.setAge(new Byte("12").byteValue());
        this.kid4.setName("Test4");
        this.kid4.setVip(true);
        this.kid4.setTicketNo("T004");
        this.playGroundSite.enter(this.kid4);

        this.kid5 = new Kid();
        this.kid5.setAge(new Byte("15").byteValue());
        this.kid5.setName("Test5");
        this.kid5.setVip(false);
        this.kid5.setTicketNo("T005");
        this.playGroundSite.enter(this.kid5);

        this.kid6 = new Kid();
        this.kid6.setAge(new Byte("13").byteValue());
        this.kid6.setName("Test6");
        this.kid6.setVip(false);
        this.kid6.setTicketNo("T006");
        this.playGroundSite.enter(this.kid6);

        this.kid7 = new Kid();
        this.kid7.setAge(new Byte("11").byteValue());
        this.kid7.setName("Test7");
        this.kid7.setVip(true);
        this.kid7.setTicketNo("T007");
        this.playGroundSite.enter(this.kid7);

        this.kid8 = new Kid();
        this.kid8.setAge(new Byte("10").byteValue());
        this.kid8.setName("Test8");
        this.kid8.setVip(true);
        this.kid8.setTicketNo("T008");
        this.playGroundSite.enter(this.kid8);

        this.kid9 = new Kid();
        this.kid9.setAge(new Byte("13").byteValue());
        this.kid9.setName("Test9");
        this.kid9.setVip(false);
        this.kid9.setTicketNo("T009");
        this.playGroundSite.enter(this.kid9);
    }

    @Test
    public void execute(){
        try {
            String equipmentId1 = this.playGroundSite.getEquipmentList().get(0).getId();
            String equipmentId2 = this.playGroundSite.getEquipmentList().get(1).getId();
            this.playGroundSite.addQueue(equipmentId1, this.kid1.getTicketNo());
            this.playGroundSite.addQueue(equipmentId1, this.kid2.getTicketNo());
            this.playGroundSite.addQueue(equipmentId1, this.kid3.getTicketNo());
            this.playGroundSite.addQueue(equipmentId1, this.kid4.getTicketNo());
            this.playGroundSite.addQueue(equipmentId1, this.kid5.getTicketNo());
            this.playGroundSite.addQueue(equipmentId2, this.kid6.getTicketNo());
            this.playGroundSite.addQueue(equipmentId2, this.kid7.getTicketNo());
            this.playGroundSite.addQueue(equipmentId2, this.kid8.getTicketNo());
            this.playGroundSite.addQueue(equipmentId2, this.kid9.getTicketNo());

            this.playGroundSite.start(equipmentId1);
            Thread.sleep(2000);
            this.playGroundSite.end(equipmentId1);

            this.playGroundSite.start(equipmentId1);
            Thread.sleep(3000);
            this.playGroundSite.end(equipmentId1);

            this.playGroundSite.start(equipmentId1);
            Thread.sleep(1000);
            this.playGroundSite.end(equipmentId1);

            this.playGroundSite.start(equipmentId1);
            Thread.sleep(3000);
            this.playGroundSite.end(equipmentId1);

            this.playGroundSite.start(equipmentId1);
            Thread.sleep(4000);
            this.playGroundSite.end(equipmentId1);

            this.playGroundSite.start(equipmentId2);
            Thread.sleep(2000);
            this.playGroundSite.end(equipmentId2);

            this.playGroundSite.start(equipmentId2);
            Thread.sleep(1000);
            this.playGroundSite.end(equipmentId2);

            this.playGroundSite.start(equipmentId2);
            Thread.sleep(2000);
            this.playGroundSite.end(equipmentId2);

            this.playGroundSite.start(equipmentId2);
            Thread.sleep(3000);
            this.playGroundSite.end(equipmentId2);

            this.playGroundSite.exit(this.kid1.getTicketNo());
            this.playGroundSite.exit(this.kid2.getTicketNo());
            this.playGroundSite.exit(this.kid3.getTicketNo());
            this.playGroundSite.exit(this.kid4.getTicketNo());
            this.playGroundSite.exit(this.kid5.getTicketNo());
            this.playGroundSite.exit(this.kid6.getTicketNo());
            this.playGroundSite.exit(this.kid7.getTicketNo());
            this.playGroundSite.exit(this.kid8.getTicketNo());
            this.playGroundSite.exit(this.kid9.getTicketNo());

            System.out.println("*****************************************************************");
            System.out.println("Report");
            System.out.println("*****************************************************************");

            List<EquipmentUtilizingReport> utilizingReport = this.reportEngine.getEquipmentUtilizingReport();
            for (EquipmentUtilizingReport item : utilizingReport) {
                System.out.println(String.format("Equipment ID: %s, Equipment Name: %s, Time: %s",
                        item.getEquipmentId(), item.getEquipmentName(), item.getUtilizingTime()));
            }

            System.out.println("*****************************************************************");
            System.out.println("Report");
            System.out.println("*****************************************************************");

            List<PercentageOfUsageReport> usageReports = this.reportEngine.getPercentageOfReport();
            for (PercentageOfUsageReport item : usageReports) {
                System.out.println(String.format("Equipment ID: %s, Equipment Name: %s, Time: %s",
                        item.getEquipmentId(), item.getEquipmentName(), item.getUsage()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
