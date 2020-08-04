package com.project.trade.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.project.trade.constants.ExpiryConstants;
import com.project.trade.entity.Trade;
import com.project.trade.repository.TradeRepository;

@Component
public class TradeScheduler {

	@Autowired
	private TradeRepository tradeRepository;
	

	@Scheduled(fixedRateString="${fixedDelay}")  // Runs after every 20 seconds
	public void tradeExpirationProcess() throws ParseException {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date todayDate = dateFormatter.parse(dateFormatter.format(new Date()));
		List<Trade> expiredTrades = tradeRepository
				.findAllByExpiredAndMaturityDateLessThan(ExpiryConstants.NOT_EXPIRED.getIsExpired(), todayDate);
		for(Trade trade: expiredTrades) {
			trade.setExpired(ExpiryConstants.EXPIRED.getIsExpired());
		}
		this.tradeRepository.saveAll(expiredTrades);

	}

}
