package com.exfinder.service;

import java.util.ArrayList;

import com.exfinder.dto.ExchangeRateDto;

public interface ExchangeRateService {
	public ArrayList<ExchangeRateDto> exchangeRateSelect(String currency,String start_date,String end_date) throws Exception;
	public int exchangeRateInsert(ExchangeRateDto dto) throws Exception;
	public ArrayList<ExchangeRateDto> checkExchange(String curreny,String startDate,String endDate) throws Exception;
}