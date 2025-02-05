package Behavioural_Design_Pattern.ChainOfResponsibilityPattern;

import Behavioural_Design_Pattern.ChainOfResponsibilityPattern.service.LogProcessor;
import Behavioural_Design_Pattern.ChainOfResponsibilityPattern.service.impl.DebugLogProcessor;
import Behavioural_Design_Pattern.ChainOfResponsibilityPattern.service.impl.ErrorLogProcessor;
import Behavioural_Design_Pattern.ChainOfResponsibilityPattern.service.impl.InfoLogProcessor;

import static Behavioural_Design_Pattern.ChainOfResponsibilityPattern.constant.constant.*;

public class Main {
    public static void main(String[] args) {
        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logObject.log(ERROR, "exception happens");
        logObject.log(DEBUG, "need to debug this ");
        logObject.log(INFO, "just for info ");

    }
}
