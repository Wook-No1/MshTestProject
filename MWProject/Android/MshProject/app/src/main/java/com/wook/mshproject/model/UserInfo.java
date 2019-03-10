package com.wook.mshproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserInfo implements Serializable {

	@SerializedName("manager")
	private String manager;

	@SerializedName("contact")
	private String contact;

	@SerializedName("company")
	private String company;

	public void setManager(String manager){
		this.manager = manager;
	}

	public String getManager(){
		return manager == null ? "" : manager;
	}

	public void setContact(String contact){
		this.contact = contact;
	}

	public String getContact(){
		return contact;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public String getCompany(){
		return company == null ? "11" : company;
	}

	@Override
 	public String toString(){
		return 
			"UserInfo{" + 
			"manager = '" + manager + '\'' + 
			",contact = '" + contact + '\'' + 
			",company = '" + company + '\'' + 
			"}";
		}
}