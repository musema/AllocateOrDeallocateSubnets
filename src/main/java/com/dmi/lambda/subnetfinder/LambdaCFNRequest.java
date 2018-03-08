package com.dmi.lambda.subnetfinder;

import java.util.Map;

public class LambdaCFNRequest {
	private String ServiceToken;
	private String RequestType;
	private String ResponseURL;
	private String StackId;
	private String RequestId;
	private String ResourceType;
	private String LogicalResourceId;
	private String PhysicalResourceId;
	private Map<String,String> ResourceProperties;
	private Map<String,String> OldResourceProperties;
	public LambdaCFNRequest(){
		
	}
	//helper method
	public void setValue(String key, Object v){
		String val=(String) v;
		if(key.equalsIgnoreCase("ServiceToken"))
			this.ServiceToken=val;
		else if(key.equalsIgnoreCase("RequestType"))
			this.RequestType=val;
		else if(key.equalsIgnoreCase("ResponseURL"))
			this.ResponseURL=val;
		else if(key.equalsIgnoreCase("StackId"))
			this.StackId=val;
		else if(key.equalsIgnoreCase("RequestId"))
			this.RequestId=val;
		else if(key.equalsIgnoreCase("ResourceType"))
			this.ResourceType=val;
		else if(key.equalsIgnoreCase("LogicalResourceId"))
			this.LogicalResourceId=val;
		else if(key.equalsIgnoreCase("PhysicalResourceId"))
			this.PhysicalResourceId=val;
	}
	public String getServiceToken() {
		return ServiceToken;
	}
	public void setServiceToken(String serviceToken) {
		ServiceToken = serviceToken;
	}
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		this.RequestType = requestType;
	}
	public String getResponseUrl() {
		return ResponseURL;
	}
	public void setResponseUR(String responseURL) {
		ResponseURL = responseURL;
	}
	public String getStackId() {
		return StackId;
	}
	public void setStackId(String stackId) {
		StackId = stackId;
	}
	public String getRequestId() {
		return RequestId;
	}
	public void setRequestId(String requestId) {
		RequestId = requestId;
	}
	public String getResourceType() {
		return ResourceType;
	}
	public void setResourceType(String resourceType) {
		ResourceType = resourceType;
	}
	public String getLogicalResourceId() {
		return LogicalResourceId;
	}
	public void setLogicalResourceId(String logicalResourceId) {
		LogicalResourceId = logicalResourceId;
	}
	public String getPhysicalResourceId() {
		return PhysicalResourceId;
	}
	public void setPhysicalResourceId(String physicalResourceId) {
		PhysicalResourceId = physicalResourceId;
	}
	public Map<String, String> getResourceProperties() {
		return ResourceProperties;
	}
	public void setResourceProperties(Map<String, String> resourceProperties) {
		ResourceProperties = resourceProperties;
	}
	public Map<String, String> getOldResourceProperties() {
		return OldResourceProperties;
	}
	public void setOldResourceProperties(Map<String, String> oldResourceProperties) {
		OldResourceProperties = oldResourceProperties;
	}
	

}
