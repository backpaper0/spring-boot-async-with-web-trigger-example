package com.example.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.async.BatchComponent;
import com.example.complexannotation.ISODateTimeFormat;

@RestController
public class TriggerController {

    private final BatchComponent batchComponent;

    public TriggerController(final BatchComponent batchComponent) {
        this.batchComponent = batchComponent;
    }

    @PostMapping("/fire")
    public void fire(
            @RequestParam @ISODateTimeFormat final LocalDateTime dateTime) {
        System.out.println("[start] trigger");
        batchComponent.doProcess(dateTime);
        System.out.println("[end] trigger");
    }
}
