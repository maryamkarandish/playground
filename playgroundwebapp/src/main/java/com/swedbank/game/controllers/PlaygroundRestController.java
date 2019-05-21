package com.swedbank.game.controllers;

import com.swedbank.game.beans.LogReport;
import com.swedbank.game.beans.PercentageOfUsageReport;
import com.swedbank.game.components.Factory;
import com.swedbank.game.components.PlayGroundSite;
import com.swedbank.game.components.equipment.Equipment;
import com.swedbank.game.domain.Kid;
import com.swedbank.game.model.*;
import com.swedbank.game.report.ReportEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maryam on 10/5/2018.
 */
@RestController
public class PlaygroundRestController {
    @Autowired private PlayGroundSite playGroundSite;
    @Autowired private Factory factory;
    @Autowired private ReportEngine reportEngine;

    @GetMapping("/showEquipmentList")
    public List<Equipment> showEquipmentList() {
        return this.playGroundSite.getEquipmentList();
    }

    @GetMapping("/showDefaultEquipmentList")
    public List<Equipment> showDefaultEquipmentList() {
        return this.factory.fetchEquipmentList();
    }

    @GetMapping("/showKidList")
    public List<Kid> showKidList() {
        return this.playGroundSite.getKidList();
    }

    @GetMapping("/showQueue")
    public QueueResponse showQueue(EquipmentRequest request) {
        QueueResponse response = new QueueResponse();

        Equipment equipment = this.playGroundSite.findEquipment(request.getId());
        response.setNormalQueue(equipment.getNormalQueue());
        response.setVipQueue(equipment.getVipQueue());
        response.setQueueLength(equipment.queueLength());

        return response;
    }

    @PostMapping("/postEnterKid")
    public Response enterKid(@RequestBody KidRequest request)
    {
        Response response = new Response("0", "Successful");

        try {
            Kid kid = new Kid();
            kid.setTicketNo(request.getTicketNo());
            kid.setName(request.getName());
            kid.setAge(request.getAge());
            kid.setVip(Boolean.valueOf(request.getIsVip()));
            this.playGroundSite.enter(kid);
        } catch (Exception ex) {
            response.setCode("1");
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    @PostMapping("/postExitKid")
    public Response exitKid(TicketRequest request)
    {
        Response response = new Response("0", "Successful");

        try {
            this.playGroundSite.exit(request.getTicketNo());
        } catch (Exception ex) {
            response.setCode("1");
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    @PostMapping("/postAddQueue")
    public Response addQueue(QueueRequest request)
    {
        Response response = new Response("0", "Successful");

        try {
            this.playGroundSite.addQueue(request.getEquipmentId(), request.getTicketNo());
        } catch (Exception ex) {
            response.setCode("1");
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    @PostMapping("/postRemoveQueue")
    public Response removeQueue(QueueRequest request)
    {
        Response response = new Response("0", "Successful");

        try {
            this.playGroundSite.removeQueue(request.getEquipmentId(), request.getTicketNo());
        } catch (Exception ex) {
            response.setCode("1");
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    @PostMapping("/postStart")
    public Response start(EquipmentRequest request)
    {
        Response response = new Response("0", "Successful");

        try {
            this.playGroundSite.start(request.getId());
        } catch (Exception ex) {
            response.setCode("1");
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    @PostMapping("/postEnd")
    public Response end(EquipmentRequest request)
    {
        Response response = new Response("0", "Successful");

        try {
            this.playGroundSite.end(request.getId());
        } catch (Exception ex) {
            response.setCode("1");
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    @PostMapping("/postRemoveEquipment")
    public Response removeEquipment(EquipmentRequest request)
    {
        Response response = new Response("0", "Successful");

        try {
            this.playGroundSite.remove(request.getId());
        } catch (Exception ex) {
            response.setCode("1");
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    @PostMapping("/postAddEquipment")
    public Response addEquipment(EquipmentTypeRequest request)
    {
        Response response = new Response("0", "Successful");

        try {
            this.playGroundSite.add(request.getType());
        } catch (Exception ex) {
            response.setCode("1");
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    @GetMapping("/getPercentageOfUsageReport")
    public PercentageOfUsageResponse getPercentageOfUsageReport()
    {
        PercentageOfUsageResponse response = new PercentageOfUsageResponse("0", "Successful");

        try {
            response.setPercentageOfUsageReports(this.reportEngine.getPercentageOfReport());
        } catch (Exception ex) {
            response.setCode("1");
            response.setMessage(ex.getMessage());
        }

        return response;
    }

    @GetMapping("/fetchLog")
    public List<LogReport> fetchLog()
    {
        List<LogReport> logReportList = new ArrayList<>();

        try {
            logReportList = this.reportEngine.fetchLog();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return logReportList;
    }
}
