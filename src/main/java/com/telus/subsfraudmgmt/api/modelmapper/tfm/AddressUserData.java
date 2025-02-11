package com.telus.subsfraudmgmt.api.modelmapper.tfm;

/**
 * Introduced to make mapping Address user data easier.
 * 
 * @author Harry Xu
 *
 */
public class AddressUserData {
	private String addressLineFiveTxt;
	private String adrStreetName;
	private String civicNo;
	private String homeProvince;
	public String getHomeProvince() {
		return homeProvince;
	}
	public void setHomeProvince(String homeAddress) {
		this.homeProvince = homeAddress;
	}
	public String getAddressLineFiveTxt() {
		return addressLineFiveTxt;
	}
	public void setAddressLineFiveTxt(String addressLineFiveTxt) {
		this.addressLineFiveTxt = addressLineFiveTxt;
	}
	public String getAdrStreetName() {
		return adrStreetName;
	}
	public void setAdrStreetName(String adrStreetName) {
		this.adrStreetName = adrStreetName;
	}
	public String getCivicNo() {
		return civicNo;
	}
	public void setCivicNo(String civicNo) {
		this.civicNo = civicNo;
	}
	
	
}
