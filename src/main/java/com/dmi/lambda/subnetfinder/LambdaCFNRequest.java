package com.dmi.lambda.subnetfinder;

import java.util.Map;

public class LambdaCFNRequest {
	private String ServiceToken;
	private String RequestType;
	private String ResponseUrl;
	private String StackId;
	private String RequestId;
	private String ResourceType;
	private String LogicalResourceId;
	private String PhysicalResourceId;
	private Map<String,String> ResourceProperties;
	private Map<String,String> OldResourceProperties;
	public LambdaCFNRequest(){
		
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
		RequestType = requestType;
	}
	public String getResponseUrl() {
		return ResponseUrl;
	}
	public void setResponseUR(String responseUR) {
		ResponseUrl = responseUR;
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
