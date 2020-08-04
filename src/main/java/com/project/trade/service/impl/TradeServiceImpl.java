package com.project.trade.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.trade.entity.Trade;
import com.project.trade.exception.TradeException;
import com.project.trade.repository.TradeRepository;
import com.project.trade.service.TradeService;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;

	/**
	 * @return list of Trades
	 */
	@Override
	public List<Trade> getAllTrade() {

		return tradeRepository.findAll();
	}

	/**
	 * Stores trade
	 * 
	 * @param trade
	 * @return stored trade
	 * @throws ParseException
	 * @throws Exception
	 */
	@Override
	public Trade storeTrade(Trade trade) throws ParseException {
		Optional<Trade> existingTrade = tradeRepository.findById(trade.getTradeId());
		if (existingTrade.isPresent() && (trade.getVersion() < existingTrade.get().getVersion())) {

			throw new TradeException("You are trying to store a lower version");
		}
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		Date todaysDate = dateFormatter.parse(dateFormatter.format(new Date()));
		Date maturityDate = dateFormatter.parse(dateFormatter.format(trade.getMaturityDate()));
		if (maturityDate.before(todaysDate)) {
			throw new TradeException("Maturity date should not be less than today's date");
		}
		return tradeRepository.save(trade);
	}

}
