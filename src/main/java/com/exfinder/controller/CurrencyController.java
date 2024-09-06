package com.exfinder.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exfinder.dto.CurrencyDto;
import com.exfinder.service.CurrencyService;

@Controller
@RequestMapping("/currency/*")
public class CurrencyController {
	
	private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);
	
	@Autowired
	private CurrencyService service;
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(@RequestParam("c_code") String c_code, @RequestParam("rate_date") String rate_date, Model model) throws Exception {
		logger.info("read..........", c_code, rate_date);
		CurrencyDto currency = service.read(c_code, rate_date);
		model.addAttribute("currencyDto", currency); 
		return "currency/read"; 
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("listAll..........");
		List<CurrencyDto> list = service.listAll();
		System.out.println(list);
		model.addAttribute("list", list);
	}
	
	
}
