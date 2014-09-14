package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.config.Messages;
import com.sprhib.dao.CurrencyItemDAO;
import com.sprhib.model.CurrencyItem;

@Service
@Transactional
public class CurrencyItemServiceImpl implements CurrencyItemService {

	@Autowired
	private CurrencyItemDAO currencyItemDAO;

	private CurrencyItem getCurrencyItem(String code) {
		CurrencyItem item = currencyItemDAO.getCurrencyItem(code);
		if (item == null) {
			throw new IllegalArgumentException(Messages.ERROR_MESSAGE_INCORRECT_CODE + code);
		}
		return item;
	}

	public List<CurrencyItem> getCurrencyItems() {
		return currencyItemDAO.getCurrencyItems();
	}
	
	public Float getConvertedMoney(float money, String code1, String code2) {
		Float ans = money * getCurrencyItem(code1).getValueUSD() / getCurrencyItem(code2).getValueUSD();
		return ans;
	}
}
