package com.sprhib.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.config.Messages;
import com.sprhib.model.CurrencyItem;
import com.sprhib.service.CurrencyItemService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CurrencyItemController {
	
	
    @Autowired
	private CurrencyItemService currencyItemService;
	
    @RequestMapping(value = "/currencylist", method = RequestMethod.GET)
    public @ResponseBody List<CurrencyItem> getAllEmployees() {
        return currencyItemService.getCurrencyItems();
    }
    
    @RequestMapping(value = "/convertation/{money}/{code1}/{code2}", method = RequestMethod.GET)
    public @ResponseBody Float createEmployee(@PathVariable("money") float money,@PathVariable("code1") String code1, @PathVariable("code2") String code2) {
    	if (money <= 0) {
    		throw new IllegalArgumentException(Messages.ERROR_MESSAGE_POSITIVE);
    	}
    	return currencyItemService.getConvertedMoney(money, code1, code2);
    }
    
		
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public Map<String,String> errorResponse(Exception ex, HttpServletResponse response) {
		Map<String,String> errorMap = new HashMap<String,String>();
		errorMap.put("errorMessage",ex.getMessage());

		return errorMap;

	}
}
