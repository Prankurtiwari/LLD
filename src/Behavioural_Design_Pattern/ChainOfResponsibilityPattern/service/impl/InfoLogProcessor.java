package Behavioural_Design_Pattern.ChainOfResponsibilityPattern.service.impl;

import Behavioural_Design_Pattern.ChainOfResponsibilityPattern.service.LogProcessor;

import static Behavioural_Design_Pattern.ChainOfResponsibilityPattern.constant.constant.INFO;

public class InfoLogProcessor extends LogProcessor{
    public InfoLogProcessor(LogProcessor nexLogProcessor){
        super(nexLogProcessor);
    }

    public void log(int logLevel,String message){

        if(logLevel == INFO) {
            System.out.println("INFO: " + message);
        } else{

            super.log(logLevel, message);
        }

    }

}
