package com.swedbank.game.model;

import com.swedbank.game.beans.PercentageOfUsageReport;

import java.util.List;

/**
 * Created by maryam on 10/7/2018.
 */
public class PercentageOfUsageResponse extends Response {
    public PercentageOfUsageResponse(String code, String message) {
        super(code, message);
    }

    private List<PercentageOfUsageReport> percentageOfUsageReports;

    public List<PercentageOfUsageReport> getPercentageOfUsageReports() {
        return percentageOfUsageReports;
    }

    public void setPercentageOfUsageReports(List<PercentageOfUsageReport> percentageOfUsageReports) {
        this.percentageOfUsageReports = percentageOfUsageReports;
    }
}
