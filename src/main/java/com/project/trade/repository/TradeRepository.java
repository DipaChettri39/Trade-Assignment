package com.project.trade.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.trade.entity.Trade;

public interface TradeRepository extends JpaRepository<Trade, String> {
	
	List<Trade> findAllByExpiredAndMaturityDateLessThan(Character isExpired, Date time);

}
