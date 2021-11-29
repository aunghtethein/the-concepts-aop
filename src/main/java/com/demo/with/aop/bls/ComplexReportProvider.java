package com.demo.with.aop.bls;

import com.demo.with.aop.annotations.PerformanceLogger;
import com.demo.with.aop.ds.Report;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportProvider {

    @PerformanceLogger
    public Report getReport() throws InterruptedException {
        System.out.println("Fetching the report...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        System.out.println("Report Created.");
        return new Report();
    }
}
