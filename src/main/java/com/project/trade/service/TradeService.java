package com.project.trade.service;

import java.text.ParseException;
import java.util.List;

import com.project.trade.entity.Trade;

public interface TradeService {
	
	public List<Trade> getAllTrade();
	
	public Trade storeTrade(Trade trade) throws ParseException, Exception;

}
