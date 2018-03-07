package com.dmi.lambda.subnetfinder;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SubnetCalculator implements RequestHandler<LambdaCFNRequest, LambdaCFNResponse> {

    @Override
    public LambdaCFNResponse handleRequest(LambdaCFNRequest input, Context context) {
        context.getLogger().log("Input: " + input);
        
        LambdaCFNRequest request=(LambdaCFNRequest)input;
        context.getLogger().log("\nRequest Type="+request.getRequestType()+"\n");
        context.getLogger().log("\nResponse URL="+request.getResponseUrl()+"\n");
        context.getLogger().log("\nStackID="+request.getStackId()+"\n");
        context.getLogger().log("\nResource Type="+request.getResourceType()+"\n");
        context.getLogger().log("\nLogical Resource ID="+request.getLogicalResourceId()+"\n");

       
        return null;
    }
}
