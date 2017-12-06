package com.bms.dao;

import com.bms.model.Customer;

public interface BmsMongoRepositoryDao {
	public int registerBMSUser(Customer customer) throws BMSDAOException;

	/*public String getRegisteredBMSUser(String jsonUserDetails)
			throws BMSDAOException;*/
	
	public boolean userNameExistsInBMS(String bmsUserName)throws BMSDAOException;

	/*public int insertUserTransactionDetails(String jsonUserTransactions)
			throws BMSDAOException;*/
	//public int insertUserTransactionDetails(Transaction transaction)
		//	throws BMSDAOException;

	public String getRegisteredBMSUserByAccountNo(String accountNumber)
			throws BMSDAOException;

	public int updateBMSUser(String jsonUserDetails) throws BMSDAOException;

	public String getUserStatements(String jsonTransactionDetails)
			throws BMSDAOException;

	String getRegisteredBMSUser(String userID, String pwd)
			throws BMSDAOException;

}
