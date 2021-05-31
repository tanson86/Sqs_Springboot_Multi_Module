package com.sqs.push.demo.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

import com.sqs.push.demo.pojo.MathOperation;
import com.sqs.push.demo.pojo.Operations;
import com.sqs.push.demo.repository.CalculatorRepository;

@Service
public class QueuePoller {
	
	@Autowired
	private CalculatorRepository calculatorRepository;
	
	@Value("${cloud.aws.end-point.uri}")
	private String endPoint;
	
	@SqsListener(value= {"${cloud.aws.end-point.uri}"})
	  public void loadMessagesFromQueue(MathOperation operation) {
		  //MathOperation operation = convertJSONToPojo(json);
	      Integer num1 = operation.getNum1();
	      Integer num2 = operation.getNum2();
	      Operations op = operation.getOperation();
	      //System.out.println("Going to check if "+num1+" "+num2+" "+ op+"exist in db");
	      com.sqs.push.demo.entity.MathOperation mathOperation = calculatorRepository.findByNum1AndNum2AndOperation(num1, num2, op.toString());
	      if(mathOperation == null || mathOperation.getOperation() == null || mathOperation.getOperation().isBlank())
	    	  calculatorRepository.save(new com.sqs.push.demo.entity.MathOperation(op.toString(),num1,num2));
	}
	


}
