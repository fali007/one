package com.example.demo;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bank")
public class Person {
//	@Id ObjectId databaseId;
	@Id
	private int id;
	private String name;
	private int balance;
	
	public Person(String name, int balance) {
		this.name=name;
		this.balance=balance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", balance=" + balance + "]";
	}
	
}
