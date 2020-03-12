package com.example.async;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BatchComponent {

    @Async
    public void doProcess(final LocalDateTime dateTime) {
        System.out.println("[start] batch process");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("parameter = " + dateTime);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[end] batch process");
    }
}
