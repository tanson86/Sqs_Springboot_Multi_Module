package com.sqs.push.demo.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints={
	    @UniqueConstraint(columnNames = {"operation", "num1","num2"})
	}) 
public class MathOperation {
	
	    
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;

	  @Column(length = 10)
	  private String operation;

	  private Integer num1;
	  
	  private Integer num2;
	  

	  public MathOperation(String operation, Integer num1, Integer num2) {
		super();
		this.operation = operation;
		this.num1 = num1;
		this.num2 = num2;
	}
	  
	  
}
