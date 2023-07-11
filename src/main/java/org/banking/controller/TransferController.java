package org.banking.controller;

import org.banking.entities.TransferTEFRequest;
import org.banking.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    TransferService service;

    @PostMapping
    ResponseEntity<String> transferTEF(@RequestBody TransferTEFRequest request) {
        service.tef(request);
        return ResponseEntity.ok("ok");
    }
}
