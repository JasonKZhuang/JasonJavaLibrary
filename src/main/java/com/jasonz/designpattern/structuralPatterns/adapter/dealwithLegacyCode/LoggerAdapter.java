package com.jasonz.designpattern.structuralPatterns.adapter.dealwithLegacyCode;

public class LoggerAdapter implements INewLoggerInterface {
    // inject the legacy logger
    private final LegacyLogger legacyLogger;

    public LoggerAdapter(LegacyLogger legacyLogger) {
        this.legacyLogger = legacyLogger;
    }

    @Override
    public void log(String message) {
        // do pre-processing
        System.out.println("Pre-processing adapter Log... " );
        // call legacy logger
        legacyLogger.logMessage(message);

        // do post-processing
        System.out.println("Post-processing adapter Log... " );
    }
}
