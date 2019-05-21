package com.swedbank.game.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maryam on 10/5/2018.
 */
@Controller
public class PlaygroundController {
    @RequestMapping("/")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/playgroundSiteConfiguration")
    public String playgroundSiteConfiguration()
    {
        return "playground/playgroundSiteConfiguration.inc";
    }

    @RequestMapping("/enterKid")
    public String enterKid()
    {
        return "playground/enterKid.inc";
    }

    @RequestMapping("/addQueue")
    public String addQueue()
    {
        return "playground/addQueue.inc";
    }

    @RequestMapping("/removeQueue")
    public String removeQueue()
    {
        return "playground/removeQueue.inc";
    }

    @RequestMapping("/start")
    public String start()
    {
        return "playground/start.inc";
    }

    @RequestMapping("/end")
    public String end()
    {
        return "playground/end.inc";
    }

    @RequestMapping("/usageReport")
    public String usageReport()
    {
        return "playground/usageReport.inc";
    }

    @RequestMapping("/logReport")
    public String log()
    {
        return "playground/logReport.inc";
    }
}
