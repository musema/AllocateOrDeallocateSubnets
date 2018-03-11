package com.dmi.lambda.subnetfinder;


import java.util.HashMap;
import java.util.Map;

public class IpUtils {
	public static Map<String,String> allocateSubnets(LambdaCFNRequest request,String networkAddress, DatabaseServices dbService,int noOfSubnetsRequired){
		Map<String,String> subnets=new HashMap<String,String>(); 
		for(int i=1;i<=noOfSubnetsRequired;i++){
			String subId=getFreeSubnet(networkAddress,request.getStackId(),dbService);
			Subnet sub= new Subnet();
			sub.setNetworkAddress(subId);
			sub.setStackId(request.getStackId());
			dbService.allocateSubnet(sub);
			subnets.put("subnet-"+i, subId);	
		}
		return subnets;
		
	}
	public static String getFreeSubnet(String networkAddress,String stackId,DatabaseServices dbService){
		String[] temp=networkAddress.split("\\.",0);
		StringBuilder subnet=new StringBuilder();
		for(int i=8;i<=255;i++){
			subnet=new StringBuilder();
			subnet.append(temp[0]+".").append(temp[1]+"."+i+"."+temp[3]);
			if(dbService.getSubnetByNetworkAddressAndStackId(subnet.toString(),stackId)==null){
				return subnet.toString();
			}	
		}
		return subnet.toString();
	}
}
