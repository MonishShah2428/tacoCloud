package com.taco.cloud.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Digits;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.oss.driver.api.core.uuid.Uuids;

import jakarta.validation.constraints.Pattern;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("taco_orders")
public class tacoOrder implements Serializable {
	@PrimaryKey
	private UUID id = Uuids.timeBased();

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
	@Column("tacos")
	private List<tacoUDT> tacos = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	private Date placedAt;
	public void addTaco(tacoUDT taco) {
		this.tacos.add(taco);
	}
}
