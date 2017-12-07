package com.bms.dao;

import com.bms.model.Customer;
import com.bms.model.Transaction;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class BmsMongoRepositoryDaoImpl implements BmsMongoRepositoryDao {
	public int registerBMSUser(Customer customer) throws BMSDAOException{
		int status = 1;
		
        System.out.println("into insertNEwUserDetails");
        try{
	        	DB db=getBMSMongoDB();	                     
	        //Set<String> collections = db.getCollectionNames();
	        //System.out.println("collections size:::"+collections.size());
	        //DBCollection col = db.getCollection("Customer");
	        DBCollection col  =getCollection(db,"Customer");
	        System.out.println("name====="+customer.getUsername());
	        insertRecordIntoEmployee(col,customer);            
	       
	        /*BasicDBObject searchQuery = new BasicDBObject();
	    	searchQuery.put("name", "Paul 222");
	
	    	DBCursor cursor = col.find(searchQuery);
	    	
	    	while (cursor.hasNext()) {
	    		System.out.println(cursor.next());
	    	}*/
	    	
	     
	   //mongoClient.close();
	
        } catch (Exception exc) {
        	status = 0;
        	throw new BMSDAOException(
        			"BMS User Transactions MongoDB Insert Failed.");
        }

        return status;


}
public boolean userNameExistsInBMS( String userId, String pwd) throws BMSDAOException{
			DB db=getBMSMongoDB();	                     
            //Set<String> collections = db.getCollectionNames();
            //System.out.println("collections size:::"+collections.size());
            //DBCollection col = db.getCollection("Customer");
            DBCollection col  =getCollection(db,"Customer");
            BasicDBObject searchQuery = new BasicDBObject();
        	searchQuery.put("name", "test1");

        	DBCursor cursor = col.find(searchQuery);
        	
        	while (cursor.hasNext()) {
        		System.out.println(cursor.next());
        		return true;
        	}
            return false;
	
}

/**
 * Method to get registred BMS user by accountNumber.
 * 
 * @param accountNumber
 *            , BMS user accountNumber.
 * @return String, if user found will return JSON or null.
 * 
 * @throws BMSDAOException
 *             , if any exception in DB operations.
 */
public String getRegisteredBMSUserByAccountNo(String accountNumber)
		throws BMSDAOException {

	String bmsUser = null;

	try {

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("accountNo", accountNumber);
		DBCursor cursor = getBMSMongoDB().getCollection(
				"Transaction").find();
		bmsUser = cursor.next().toString();

	} catch (Exception exc) {
		bmsUser = null;
	}

	return bmsUser;
}

public boolean insertUserTransactionDetails(Transaction transaction) throws BMSDAOException{
	DB db=getBMSMongoDB();	                     
    //Set<String> collections = db.getCollectionNames();
    //System.out.println("collections size:::"+collections.size());
    //DBCollection col = db.getCollection("Customer");
    DBCollection col  =getCollection(db,"Transaction");
    insertRecordIntoTransaction(col,transaction);
	return false;
}
private static void insertRecordIntoEmployee(DBCollection col,
		Customer customer) {
	System.out.println("before inserting record into the employee document");
	DBObject doc = createDBObject(customer);
	col.insert(doc);			
	
}
private static void insertRecordIntoTransaction(DBCollection col,
		Transaction transaction) {
	System.out.println("before inserting record into the employee document");
	DBObject doc = createTransactionDBObject(transaction);
	col.insert(doc);			
	
}
private static DBObject createTransactionDBObject(Transaction transaction ) {
	BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
	long transactionId = (long) (Math.random() * 10000000000000000L);	
	docBuilder.append("accountName", transaction.getAccountName());
	//docBuilder.append("accountNo", transaction.getAccountNO());   
	docBuilder.append("accountType",transaction.getAccountType());
	docBuilder.append("accAmount",transaction.getAmount());
	//docBuilder.append("date",transaction.getTransactionDt());
	docBuilder.append("type", transaction.getTransactionType());
	docBuilder.append("id", transactionId);
	transaction.setTransactionId(transactionId);
	
	return docBuilder.get();
}

private static DBObject createDBObject(Customer customer ) {
	BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
	long bms16DigitUniqueAccNo = (long) (Math.random() * 10000000000000000L);
	docBuilder.append("accountNumber", bms16DigitUniqueAccNo);
	docBuilder.append("name", customer.getName());
	docBuilder.append("userName", customer.getUsername());   
	docBuilder.append("password",customer.getPassword());
	docBuilder.append("dateofbirth", customer.getDob());
	docBuilder.append("gender",customer.getGender());
	docBuilder.append("contactNumber", customer.getContactNo());
	docBuilder.append("email", customer.getEmail());
	docBuilder.append("citizenship", customer.getCitizenship());
	//docBuilder.append("accountType", customer.get);
	docBuilder.append("registrationDate",customer.getDob());
	//docBuilder.append("citizenStatus", customer.getStatus());
	docBuilder.append("branchName", customer.getBranchName());
	docBuilder.append("initialDepositAmount", customer.getInitialDeposit());
	docBuilder.append("panNumber", customer.getPanNumber());
	//docBuilder.append("address",		
	customer.setAccountNumber(bms16DigitUniqueAccNo);
	
	return docBuilder.get();
}
@Override
//public String getRegisteredBMSUser(String jsonUserDetails)
public String getRegisteredBMSUser(String userID, String pwd)
		throws BMSDAOException {

	String bmsUser = null;
	try {
		                   
		DB db=getBMSMongoDB();
        DBCollection col  =getCollection(db,"Customer");
        BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put("name", userID);
    	searchQuery.put("password", pwd);

    	DBCursor cursor = col.find(searchQuery);    	
    	while (cursor.hasNext()) {
    		System.out.println(cursor.next());    		
    	}		

	} catch (Exception exc) {
		bmsUser = null;
	}

	return null;
}
@Override
public boolean userNameExistsInBMS(String bmsUserName) throws BMSDAOException {
	// TODO Auto-generated method stub
	return false;
}
//@Override
public int insertUserTransactionDetails(String jsonUserTransactions)
		throws BMSDAOException {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int updateBMSUser(String jsonUserDetails) throws BMSDAOException {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public String getUserStatements(String jsonTransactionDetails)
		throws BMSDAOException {
	// TODO Auto-generated method stub
	return null;
}

public DB getBMSMongoDB() throws BMSDAOException{
	MongoClient mongo = null;
	DB db = null;

	try {
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("projectBMSDataBase");
	} catch (Exception exc) {
		throw new BMSDAOException("Error while getting MongoDB Connection.");
	}

	return db;
}
public DBCollection getCollection( DB db,String colStrng){
	DBCollection col = db.getCollection(colStrng);
	return col;
	
}


}
