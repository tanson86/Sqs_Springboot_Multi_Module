package com.sqs.push.demo.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class MathOperation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num1;
	private int num2;
	private Operations operation;
}
