package com.demo.with.aop.action;

import com.demo.with.aop.bls.ComplexReportFormatter;
import com.demo.with.aop.bls.ComplexReportProvider;
import com.demo.with.aop.bls.ComplexReportRepository;
import com.demo.with.aop.ds.FormattedReport;
import com.demo.with.aop.ds.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComplexReportAction {
    @Autowired
    private ComplexReportRepository complexReportRepository;
    @Autowired
    private ComplexReportFormatter complexReportFormatter;
    @Autowired
    private ComplexReportProvider complexReportProvider;

    public void perform() throws InterruptedException {
        Report report = complexReportProvider.getReport();

        FormattedReport formattedReport = complexReportFormatter.formattedReport(report);

        complexReportRepository.save(formattedReport);
    }






}
