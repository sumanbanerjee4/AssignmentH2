package com.example.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Devices {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column
	String deviceName;

	@Column
	String deviceIp;

	public Devices() {}

	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceIp() {
		return deviceIp;
	}
	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}
	public Devices(String deviceName, String deviceIp) {

		this.deviceName = deviceName;
		this.deviceIp = deviceIp;
	}
}