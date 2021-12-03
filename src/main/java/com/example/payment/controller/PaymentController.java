package com.example.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import org.json.simple.JSONObject;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${upstream.order.serviceAddr}")
    private String orderAddr;
    @Value("${upstream.order.servicePort}")
    private String orderPort;

    final RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/health/ready")
    @ResponseStatus(HttpStatus.OK)
    public void ready() {
    }

    @GetMapping("/health/live")
    @ResponseStatus(HttpStatus.OK)
    public void live() {
    }

    @PostMapping
    public Object getPayment(@RequestBody JSONObject requestBody) {

        int second = (int)(Math.random()*10) + 1;
        try{
            Thread.sleep(second*1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://" + orderAddr + ":" + orderPort + "/order/update",requestBody.get("ID"), String.class);
        final String response = responseEntity.getBody();
        System.out.println(response);
        return ResponseEntity.ok("Received request in PAYMENT service,"+requestBody);

    }

}
