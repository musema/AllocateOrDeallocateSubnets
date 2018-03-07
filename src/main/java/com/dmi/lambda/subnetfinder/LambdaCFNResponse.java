package com.dmi.lambda.subnetfinder;

import java.util.Map;

public class LambdaCFNResponse {
	private String Status;
	private String Reason;
	private String PhysicalResourceId;
	private String StackId;
	private String RequestId;
	private String LogicalResourceId;
	private String NoEcho;
	private Map<String,String>Data;
	
	public LambdaCFNResponse(){
		
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getPhysicalResourceId() {
		return PhysicalResourceId;
	}

	public void setPhysicalResourceId(String physicalResourceId) {
		PhysicalResourceId = physicalResourceId;
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

	public String getLogicalResourceId() {
		return LogicalResourceId;
	}

	public void setLogicalResourceId(String logicalResourceId) {
		LogicalResourceId = logicalResourceId;
	}

	public String getNoEcho() {
		return NoEcho;
	}

	public void setNoEcho(String noEcho) {
		NoEcho = noEcho;
	}

	public Map<String, String> getData() {
		return Data;
	}

	public void setData(Map<String, String> data) {
		Data = data;
	}
	
	

}
