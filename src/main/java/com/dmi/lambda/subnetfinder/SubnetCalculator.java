package com.dmi.lambda.subnetfinder;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SubnetCalculator implements RequestHandler<LinkedHashMap<String,Object>, LambdaCFNResponse> {
	private LambdaLogger logger;
    @Override
    public LambdaCFNResponse handleRequest(LinkedHashMap<String,Object> input, Context context) {
    	logger=context.getLogger();
        logger.log("Input: " + input.toString());
        
        logger.log("\n");
       for(Map.Entry<String, Object> en:input.entrySet()){
    	   if(en.getKey().equalsIgnoreCase("ResourceProperties"))
    		   continue;
    	   logger.log(en.getKey()+","+en.getValue()+"\n");
    	   logger.log("Entry class:"+en.getClass()+"\n");
       }
       
       LambdaCFNResponse response=new LambdaCFNResponse();
       response.setStatus("Success");
       response.setLogicalResourceId("id-1");
       response.setData(new HashMap<String,String>());
       response.getData().put("key1", "val1");
       response.getData().put("key2", "val2");
       return response;
        //return transformInputToCFNRequest(input);
    }
    public LambdaCFNRequest transformInputToCFNRequest(LinkedHashMap<String,Object> input){
    	LambdaCFNRequest request=new LambdaCFNRequest();
    	 for(Map.Entry<String, Object> en:input.entrySet()){
    		 if(en.getKey().equalsIgnoreCase("ResourceProperties"))
      		   continue;
    		 request.setValue(en.getKey(), en.getValue());
         }
    	return request;
    }
}
