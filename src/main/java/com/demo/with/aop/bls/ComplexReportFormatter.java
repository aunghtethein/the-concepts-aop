package com.demo.with.aop.bls;

import com.demo.with.aop.annotations.PerformanceLogger;
import com.demo.with.aop.ds.FormattedReport;
import com.demo.with.aop.ds.Report;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportFormatter {

    @PerformanceLogger
    public FormattedReport formattedReport(Report report) throws InterruptedException {
        System.out.println("Formatting Report...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("Report Formatted.");
        return new FormattedReport(report);
    }
}
