package com.osrs.action;

import org.apache.struts2.interceptor.ServletRequestAware;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class TransactionAction extends ActionSupport implements ServletRequestAware, Preparable{
	Transaction newTransaction;
	

	HttpServletRequest request ;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		newTransaction= new Transaction();
	}
	@SkipValidation
	public String getInputForm(){
		return SUCCESS;
	}
	
	public String doPayment(){
		String Response = null;
		osrsTraveler user = new osrsTraveler();
		String DomainResponse = user.doPayment(newTransaction);
		this.addActionMessage(DomainResponse);
		Response = SUCCESS;
		return Response;
	}
	
	
	
	
	
///////////////////////////////////////////////////////////////////
	public Transaction getNewTransaction() {
		return newTransaction;
	}
	public void setNewTransaction(Transaction newTransaction) {
		this.newTransaction = newTransaction;
	}
}
