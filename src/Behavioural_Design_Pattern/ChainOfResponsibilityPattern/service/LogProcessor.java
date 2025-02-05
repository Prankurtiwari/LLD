package Behavioural_Design_Pattern.ChainOfResponsibilityPattern.service;

public class LogProcessor {
    LogProcessor nextLoggerProcessor;
    protected LogProcessor(LogProcessor loggerProcessor) {
        this.nextLoggerProcessor = loggerProcessor;
    }

    public void log(int logLevel, String message) {
        if (nextLoggerProcessor != null) {
            nextLoggerProcessor.log(logLevel, message);
        }
    }

}
