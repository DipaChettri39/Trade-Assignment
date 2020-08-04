package com.project.trade.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.trade.entity.Trade;
import com.project.trade.service.TradeService;

@RestController
public class TradeController {

	protected Logger log = LoggerFactory.getLogger(TradeController.class);
	
	@Autowired
	private TradeService tradeService;

	/**
	 * 
	 * @return list of Trades
	 */
	@RequestMapping("/getAllTrade")
	public ResponseEntity<List<Trade>> getAllTrade() {
		List<Trade> tradeList = tradeService.getAllTrade();
		log.debug("Trade List :", tradeList.toString());
		return new ResponseEntity<List<Trade>>(tradeList, HttpStatus.OK);
	}
	
	/**
	 * Stores trade
	 * 
	 * @param trade
	 * @return stored trade
	 * @throws ParseException
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/storeTrade")
	public ResponseEntity<Trade> storeTrade(@RequestBody Trade trade) throws ParseException, Exception {
	   log.debug("Trade received :", trade.toString());
	   Trade tradeStored = tradeService.storeTrade(trade);
	   return new ResponseEntity<Trade>(tradeStored, HttpStatus.OK);
	}

}
