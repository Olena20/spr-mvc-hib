package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.CurrencyItem;

public interface CurrencyItemDAO {
	public CurrencyItem getCurrencyItem(String code);
	public List<CurrencyItem> getCurrencyItems();
	
}
