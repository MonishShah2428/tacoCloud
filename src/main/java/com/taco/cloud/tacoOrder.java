package com.taco.cloud;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.ArrayList;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Digits;
import org.hibernate.validator.constraints.CreditCardNumber;
import jakarta.validation.constraints.Pattern;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class tacoOrder {
	@NotBlank(message="required")
	private String deliveryName;
	@NotBlank(message="required")
	private String deliveryStreet;
	@NotBlank(message="required")
	private String deliveryCity;
	@NotBlank(message="required")
	private String deliveryState;
	@NotBlank(message="required")
	private String deliveryZip;
	@CreditCardNumber(message="Invalid card number")
	private String ccNumber;
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY")
	private String ccExpiration;
	@Digits(integer=3, fraction=0, message="Invalid CVV")
	private String ccCVV;
	private List<taco> tacos = new ArrayList<>();

	public void addTaco(taco taco) {
		this.tacos.add(taco);
	}
}