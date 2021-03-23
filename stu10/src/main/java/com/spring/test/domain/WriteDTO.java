package com.spring.test.domain;

public class WriteDTO {
	private Integer uid; // ex_uid    // ★ int 대신 Integer 사용하는 것을 추천
	private String name; // ex_name
	private String con; // ex_con
	private Integer price; // ex_price
	

	// 우리의 기본 생성자
	public WriteDTO() {
		super();
	}
		
	
	public WriteDTO(Integer uid, String name, String con, Integer price) {
		super();
		this.uid = uid;
		this.name = name;
		this.con = con;
		this.price = price;
		System.out.printf("WriteDTO(%d, %s, %s, %d) 객체 생성\n", uid, name, con, price);
	}


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCon() {
		return con;
	}


	public void setCon(String con) {
		this.con = con;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}	
	
}	// end WriteDTO()
	





