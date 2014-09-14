package com.sprhib.service;

import java.util.List;

import com.sprhib.model.CurrencyItem;

public interface CurrencyItemService {
	public List<CurrencyItem> getCurrencyItems();
	public Float getConvertedMoney(float money, String code1, String code2);
}
