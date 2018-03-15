# AWS Lambda Project 
# Lambda with Java
	*This project is created from eclipse, so you need to install aws eclipse plugins first
# Where to start learning about this lambda function?
	*check **SubnetCalculator** class in this class you will find *handleRequest(LinkedHashMap<String,Object> input, Context context)* method, that is all it takes
#What are the POJOs used?
	* LambdaCFNRequest:-Equivalent to AWS CloudFormation Request JSON template.It just makes easy for me to work with properties of the request.
	* LambdaCFNResponse:-Equivalent to AWS CloudFormation Response JSON template.It just makes easy for me to populate the response through out the process.
#What other AWS services are used here?
	AWS DynamoDB is used here to store **SubnetIDs** or **Network Adresses** that are occupied.
	 