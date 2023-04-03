package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.rabbitMQ.RabbitMQProcedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {
    @Autowired
    private RabbitMQProcedure rabbitMQProcedure;

    @GetMapping("")
    public String sendDataToQueue() {
        rabbitMQProcedure.sendMessage("Helo");
        return "";
    }

}
