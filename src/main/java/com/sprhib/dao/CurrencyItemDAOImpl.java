package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.CurrencyItem;

@Repository
public class CurrencyItemDAOImpl implements CurrencyItemDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public CurrencyItem getCurrencyItem(String code) {
		CurrencyItem currencyItem = (CurrencyItem) getCurrentSession().get(CurrencyItem.class, code);
		return currencyItem;
	}

	@SuppressWarnings("unchecked")
	public List<CurrencyItem> getCurrencyItems() {
		return getCurrentSession().createQuery("from CurrencyItem").list();
	}

}
