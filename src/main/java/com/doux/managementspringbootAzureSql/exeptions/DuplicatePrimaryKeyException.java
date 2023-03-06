package com.doux.managementspringbootAzureSql.exeptions;

public class DuplicatePrimaryKeyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public DuplicatePrimaryKeyException(String msg) {
		super(msg);
	}

}
