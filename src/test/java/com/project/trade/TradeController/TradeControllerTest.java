package com.project.trade.TradeController;

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
import org.springframework.http.ResponseEntity;

import com.project.trade.controller.TradeController;
import com.project.trade.entity.Trade;
import com.project.trade.service.TradeService;

@RunWith(SpringRunner.class)
public class TradeControllerTest {

	protected Logger log = LoggerFactory.getLogger(TradeControllerTest.class);

	@InjectMocks
	private TradeController tradeController;

	@Mock
	private TradeService tradeService;

	@Test
	public void getAllTradeTest() {
		List<Trade> expectedTradeList = new ArrayList<Trade>();
		Trade expectedTrade = new Trade();
		expectedTrade.setTradeId("T0");
		expectedTradeList.add(expectedTrade);

		when(tradeService.getAllTrade()).thenReturn(expectedTradeList);

		ResponseEntity<List<Trade>> actualTradeList = tradeController.getAllTrade();
		assertEquals(expectedTrade.getTradeId(), actualTradeList.getBody().get(0).getTradeId());
	}

	@Test
	public void storeTradeTest() {
		try {
			Trade expectedTrade = new Trade();
			expectedTrade.setTradeId("T0");

			when(tradeService.storeTrade(any())).thenReturn(expectedTrade);

			ResponseEntity<Trade> actualTrade = tradeController.storeTrade(expectedTrade);
			assertEquals(expectedTrade.getTradeId(), actualTrade.getBody().getTradeId());
		} catch (Exception e) {
			log.info("Exception occurred:::", e.getMessage());
		}
	}

}
