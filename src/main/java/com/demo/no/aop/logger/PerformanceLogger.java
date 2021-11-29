package com.demo.no.aop.logger;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.logging.Logger;

@Component
public class PerformanceLogger {
    private Logger logger = Logger.getLogger("performace.logger");

    public PerformanceLoggerInfo start(String name) {
        return new PerformanceLoggerInfo(name, System.currentTimeMillis());
    }
    public void stop(PerformanceLoggerInfo performanceLoggerInfo) {
        long start = performanceLoggerInfo.getStartTime();
        long finish = System.currentTimeMillis();
        logger.info(
                String.format("Duration of %s execution was %s ",
                        performanceLoggerInfo.getName(), Duration.ofMillis(finish - start))
        );
    }

    public static class PerformanceLoggerInfo {
        private final String name;
        private final long startTime;

        public PerformanceLoggerInfo(String name, long startTime) {
            this.name = name;
            this.startTime = startTime;
        }

        public String getName() {
            return name;
        }

        public long getStartTime() {
            return startTime;
        }
    }
}
