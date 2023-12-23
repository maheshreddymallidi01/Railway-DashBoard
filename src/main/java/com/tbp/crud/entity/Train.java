package com.tbp.crud.entity;

public class Train {
    private int id;
    private String tname;
    private String platform;
    private String toa;
    
    
	public Train(int id, String tname, String platform, String toa) {
		super();
		this.id = id;
		this.tname = tname;
		this.platform = platform;
		this.toa = toa;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getToa() {
		return toa;
	}
	public void setToa(String toa) {
		this.toa = toa;
	}
    
    
}
