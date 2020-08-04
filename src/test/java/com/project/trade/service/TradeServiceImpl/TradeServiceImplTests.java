package com.project.trade.service.TradeServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.trade.entity.Trade;
import com.project.trade.repository.TradeRepository;
import com.project.trade.service.impl.TradeServiceImpl;

@RunWith(SpringRunner.class)
public class TradeServiceImplTests {
	
	protected Logger log = LoggerFactory.getLogger(TradeServiceImplTests.class);
	
	@InjectMocks
	TradeServiceImpl tradeServiceImpl;
	
	@Mock
	private TradeRepository tradeRepository;
	
	@Test
	public void getAllTradeTest() {
		List<Trade> expectedTradeList = new ArrayList<Trade>();
		Trade expectedTrade = new Trade();
		expectedTrade.setTradeId("T0");
		expectedTradeList.add(expectedTrade);
		
		when(tradeRepository.findAll()).thenReturn(expectedTradeList);
		List<Trade> actualTradeList = tradeServiceImpl.getAllTrade();
		assertEquals(expectedTrade.getTradeId(), actualTradeList.get(0).getTradeId());
	}
	
	@Test
	public void storeTradeTest() {
		try {   
		Trade expectedTrade = new Trade();
		expectedTrade.setTradeId("T0");
		
		when(tradeRepository.save(any())).thenReturn(expectedTrade);
		
		Trade actualTrade = tradeServiceImpl.storeTrade(expectedTrade);
		assertEquals(expectedTrade.getTradeId(), actualTrade.getTradeId());
		} catch (Exception e) {
			log.info("Exception occurred:::" , e.getMessage());
		}
	}

}
