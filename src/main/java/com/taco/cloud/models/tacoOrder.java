package com.taco.cloud.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Digits;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Pattern;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("taco_order")
@Entity
public class tacoOrder implements Serializable {
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
	//@CreditCardNumber(message="Invalid card number")
	private String ccNumber;
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY")
	private String ccExpiration;
	@Digits(integer=3, fraction=0, message="Invalid CVV")
	private String ccCVV;
	@OneToMany(cascade = CascadeType.ALL)
	private List<taco> tacos = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date placedAt;
	public void addTaco(taco taco) {
		this.tacos.add(taco);
	}
}
