package com.bms.dao;

/**
 * User defined BMS DAO layer exception class.
 * 
 * @author BMS Administrator
 *
 */
public class BMSDAOException extends Exception {
	
	public BMSDAOException(){
		
	}
	public BMSDAOException(String exception) {
		super(exception);
	}
}
