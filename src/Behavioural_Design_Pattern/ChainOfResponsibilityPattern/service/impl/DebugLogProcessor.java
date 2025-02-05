package Behavioural_Design_Pattern.ChainOfResponsibilityPattern.service.impl;

import Behavioural_Design_Pattern.ChainOfResponsibilityPattern.service.LogProcessor;

import static Behavioural_Design_Pattern.ChainOfResponsibilityPattern.constant.constant.DEBUG;
import static Behavioural_Design_Pattern.ChainOfResponsibilityPattern.constant.constant.INFO;

public class DebugLogProcessor extends LogProcessor{
    public DebugLogProcessor(LogProcessor nexLogProcessor){
        super(nexLogProcessor);
    }

    public void log(int logLevel,String message){

        if(logLevel == DEBUG) {
            System.out.println("Debug: " + message);
        } else{

            super.log(logLevel, message);
        }

    }

}
