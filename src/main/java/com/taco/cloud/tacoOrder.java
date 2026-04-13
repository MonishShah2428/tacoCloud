package com.taco.cloud;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class tacoOrder {
	private String deliveryName;
	private String deliveryStreet;
	private String deliveryCity;
	private String deliveryState;
	private String deliveryZip;
	private String ccNumber;
	private String ccExpiration;
	private String ccCVV;
	private List<taco> tacos = new ArrayList<>();

	public void addTaco(taco taco) {
		this.tacos.add(taco);
	}
}