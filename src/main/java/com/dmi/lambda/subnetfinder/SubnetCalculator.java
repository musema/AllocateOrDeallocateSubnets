package com.dmi.lambda.subnetfinder;

import java.util.LinkedHashMap;
import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SubnetCalculator implements RequestHandler<LinkedHashMap<String,Object>, LambdaCFNResponse> {
	private LambdaLogger logger;
	private DatabaseServices dbService;
	private LambdaCFNRequest request=new LambdaCFNRequest();
	private LambdaCFNResponse response=new LambdaCFNResponse();
    @Override
    public LambdaCFNResponse handleRequest(LinkedHashMap<String,Object> input, Context context) {
       logger=context.getLogger();
       
       this.request=transformInputToCFNRequest(input);
       String networkAdress=request.getResourceProperties().get("vpc");
       if(networkAdress==null){
    	   this.response.setStatus("Failure");
    	   this.response.getData().put("Reason", "Invalid or no network address is provided");
    	   
    	   logger.log("\nUnable to calculate the subnet without knowing the network address\n");
    	   return null;
       }
       AmazonDynamoDB client=AmazonDynamoDBClientBuilder.standard().withRegion(Regions.fromName("us-east-1")).build();
       this.dbService=new DatabaseServices(client);
       
       if(request.getRequestType().equalsIgnoreCase("Create")){
    	   this.response.setData(IpUtils.allocateSubnets(request,networkAdress, dbService, 4));
    	   populateCommonCFNResponse();
    	   this.response.setStatus("Success");
    	   return this.response;
       }
       if(request.getRequestType().equalsIgnoreCase("Delete")){
    	   this.dbService.deAllocateSubnets(this.request.getStackId());
    	   populateCommonCFNResponse();
    	   this.response.setStatus("Success");
    	   return this.response;
       }
       if(request.getRequestType().equalsIgnoreCase("Update")){
    	   //update operation
    	   populateCommonCFNResponse();
    	   this.response.setStatus("Success");
    	   return this.response;
       }
       this.response.setStatus("Failure");
	   this.response.getData().put("Reason", "Unknown");
       return this.response;
    }
    @SuppressWarnings("unchecked")
	public LambdaCFNRequest transformInputToCFNRequest(LinkedHashMap<String,Object> input){
    	for(Map.Entry<String, Object> en:input.entrySet()){
    		 if(en.getKey().equalsIgnoreCase("ResourceProperties"))
      		   {
    			 this.request.setResourceProperties((Map<String, String>)en.getValue());
    			 continue;
      		   }
    		 this.request.setValue(en.getKey(), en.getValue());
         }
    	return this.request;
    }
    public void populateCommonCFNResponse(){
    	
    }
}
