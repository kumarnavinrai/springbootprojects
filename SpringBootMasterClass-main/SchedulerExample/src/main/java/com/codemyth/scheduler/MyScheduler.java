package com.codemyth.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyScheduler {

//    @Scheduled(cron = "1 * * * * ?")
//    public void s1(){
//
//    }

//    @Scheduled(fixedRate = 1000)
//    public void s2(){
//        log.info("fixedRate");
//    }

    @Scheduled(fixedDelay = 1000,initialDelay = 2000)
    public void s3(){
        log.info("fixedDelay");
    }
}
