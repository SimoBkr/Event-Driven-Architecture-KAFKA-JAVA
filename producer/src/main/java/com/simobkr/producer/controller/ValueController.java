package com.simobkr.producer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ValueController {

    private final StreamBridge streamBridge;

    @GetMapping("values/{value}")
    public ResponseEntity<String> values(@PathVariable String value) {
        log.info("Sending value {} to topic", value);
        streamBridge.send("values-topic", value);
        return ResponseEntity.ok("ok");
    }
}
