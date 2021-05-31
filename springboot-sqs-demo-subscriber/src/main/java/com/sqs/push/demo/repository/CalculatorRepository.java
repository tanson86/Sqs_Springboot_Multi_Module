package com.sqs.push.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.sqs.push.demo.entity.MathOperation;

public interface CalculatorRepository extends CrudRepository<MathOperation, Integer>{

	MathOperation findByNum1AndNum2AndOperation(Integer num1, Integer num2, String Operation);
}
