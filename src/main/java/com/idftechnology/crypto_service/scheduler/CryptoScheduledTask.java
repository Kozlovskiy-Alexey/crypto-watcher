package com.idftechnology.crypto_service.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class CryptoScheduledTask {

    private final TaskScheduler taskScheduler;
    private final ScheduleCryptoJobTask task1;

    @PostConstruct
    public void init() {
        taskScheduler.schedule(task1, new PeriodicTrigger(60, TimeUnit.SECONDS));
    }
}
