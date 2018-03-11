package com.dmi.lambda.subnetfinder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;

public class DatabaseServices {
	private final DynamoDBMapper mapper;
	
	public DatabaseServices(AmazonDynamoDB client){
		this.mapper=new DynamoDBMapper(client);
	}
	public void allocateSubnet(Subnet sub){
		mapper.save(sub);
	}
	public void deAllocateSubnets(String networkAddress,String stackId){
		DynamoDBQueryExpression<Subnet> query=new DynamoDBQueryExpression<Subnet>()
				.withRangeKeyCondition(stackId, 
						new Condition()
						.withComparisonOperator(ComparisonOperator
						.EQ)
						.withAttributeValueList(new AttributeValue().withS(stackId)));
		mapper.query(Subnet.class, query);
		
	}
	public void deAllocateSubnets(String stackId){
		AttributeValue attVal=new AttributeValue();
		attVal.setS(stackId);
		Map<String,AttributeValue> currentStack=new HashMap<String,AttributeValue>();
		currentStack.put("stackId", attVal);
		DynamoDBScanExpression scan=new DynamoDBScanExpression();
				//.withFilterExpression("stackId = :stackId").withExpressionAttributeValues(currentStack);
		List<Subnet> subnets= mapper.scan(Subnet.class, scan);
		String networkAddress="";
		for(int i=0;i<subnets.size();i++){
			networkAddress=subnets.get(i).getNetworkAddress();
			Subnet s=new Subnet();
			s.setNetworkAddress(networkAddress);
			s.setStackId(stackId);
			mapper.delete(s);
		}
		
	}
	public Subnet getSubnetBySubnetId(String subId){
		return mapper.load(Subnet.class,subId);
	}
	public List<Subnet> getAllSubnets(){
		return null;
	}
	public Object getSubnetByNetworkAddressAndStackId(String networkAddress, String stackId) {
		Subnet sub=new Subnet();
		sub.setNetworkAddress(networkAddress);
		sub.setStackId(stackId);
		return mapper.load(sub);
	}
}
