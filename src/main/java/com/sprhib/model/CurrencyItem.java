package com.sprhib.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_currency")
public class CurrencyItem implements Serializable{

	private static final long serialVersionUID = -3068480253563367468L;

	@Id
	@GeneratedValue
	private String code;
	
	private String caption;
	
	private Float valueUSD;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Float getValueUSD() {
		return valueUSD;
	}
	public void setValueUSD(Float valueUSD) {
		this.valueUSD = valueUSD;
	}
	
	@Override
	public String toString() {
		return code;
	}

	public CurrencyItem(String code, String caption, Float valueUSD) {
		this.code = code;
		this.caption = caption;
		this.valueUSD = valueUSD;
	}
	
	public CurrencyItem() {}
}
