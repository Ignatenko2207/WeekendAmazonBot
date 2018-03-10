package org.itstep.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Good {

	private String asin;
	private String name;
	private String shopUrl;
		
	public Good() {
	}

	public Good(String asin, String name, String shopUrl) {
		this.asin = asin;
		this.name = name;
		this.shopUrl = shopUrl;
	}
}
