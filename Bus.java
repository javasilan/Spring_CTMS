package com.example.mvccrud.ctms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String slNo;
    private String busNo;
    private String route;
    private String driverName;
    private String driverMobile;
    
	
    
    public Bus() {
    }
    
	public Long getId() {
		return id;
	}
	/**
	 * @return the slNo
	 */
	public String getSlNo() {
		return slNo;
	}
	/**
	 * @return the busNo
	 */
	public String getBusNo() {
		return busNo;
	}
	/**
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}
	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}
	/**
	 * @return the driverMobile
	 */
	public String getDriverMobile() {
		return driverMobile;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param slNo the slNo to set
	 */
	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}
	/**
	 * @param busNo the busNo to set
	 */
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	/**
	 * @param route the route to set
	 */
	public void setRoute(String route) {
		this.route = route;
	}
	/**
	 * @param driverName the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	/**
	 * @param driverMobile the driverMobile to set
	 */
	public void setDriverMobile(String driverMobile) {
		this.driverMobile = driverMobile;
	}
	public Bus(Long id, String slNo, String busNo, String route, String driverName, String driverMobile) {
		super();
		this.id = id;
		this.slNo = slNo;
		this.busNo = busNo;
		this.route = route;
		this.driverName = driverName;
		this.driverMobile = driverMobile;
	}

    
}
