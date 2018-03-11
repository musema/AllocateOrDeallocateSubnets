package com.dmi.lambda.subnetfinder;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Subnet")
public class Subnet {
	@DynamoDBHashKey(attributeName="networkAddress")
	private String networkAddress;
	@DynamoDBRangeKey(attributeName="stackId")
	private String stackId;
	public Subnet(){}
	public String getNetworkAddress() {
		return networkAddress;
	}
	public void setNetworkAddress(String networkAddress) {
		this.networkAddress = networkAddress;
	}
	public String getStackId() {
		return stackId;
	}
	public void setStackId(String stackId) {
		this.stackId = stackId;
	}
	
	

}
