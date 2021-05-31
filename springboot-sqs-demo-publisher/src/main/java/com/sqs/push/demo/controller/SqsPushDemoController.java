package com.sqs.push.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sqs.push.demo.pojo.MathOperation;
import com.sqs.push.demo.pojo.Operations;

@RestController
public class SqsPushDemoController {
	
	@Autowired
    private QueueMessagingTemplate queueMessagingTemplate;
	
	@Value("${cloud.aws.end-point.uri}")
	private String endPoint;
	
	
	@PostMapping
	  public HttpStatus performOperation(@RequestBody MathOperation operation) {
		System.out.println("In POST performOperation");
		try {
			Integer i1 = operation.getNum1();
			Integer i2 = operation.getNum2();
			Operations o = Operations.valueOf(operation.getOperation().toString());
			queueMessagingTemplate.convertAndSend(endPoint, operation);
			return HttpStatus.OK;
		}catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.BAD_REQUEST;
		}
	  }
	
	
	@GetMapping
	  public HttpStatus performOperation() {
		System.out.println("In GET performOperation");
			return HttpStatus.OK;
	  }

	  
}
