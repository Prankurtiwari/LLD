package Behavioural_Design_Pattern.ChainOfResponsibilityPattern.service.impl;

import Behavioural_Design_Pattern.ChainOfResponsibilityPattern.service.LogProcessor;

import static Behavioural_Design_Pattern.ChainOfResponsibilityPattern.constant.constant.ERROR;
import static Behavioural_Design_Pattern.ChainOfResponsibilityPattern.constant.constant.INFO;

public class ErrorLogProcessor extends LogProcessor{
    public ErrorLogProcessor(LogProcessor nexLogProcessor){
        super(nexLogProcessor);
    }

    public void log(int logLevel,String message){

        if(logLevel == ERROR) {
            System.out.println("ERROR: " + message);
        } else{

            super.log(logLevel, message);
        }

    }

}
