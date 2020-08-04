package com.project.trade.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Trade {

	@Id
	private String tradeId;
	
	private Integer version;
	
	private String counterPartyId;
	
	private String bookId;
	
    @JsonFormat(pattern="dd-MM-yyyy")
	private Date maturityDate;
	 
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date createdDate;
	 
	private Character expired;
	
	public Trade(){
		
	}

	public Trade(String tradeId, Integer version, String counterPartyId, String bookId, Date maturityDate,
			Date createdDate, Character expired) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trade [tradeId=");
		builder.append(tradeId);
		builder.append(", version=");
		builder.append(version);
		builder.append(", counterPartyId=");
		builder.append(counterPartyId);
		builder.append(", bookId=");
		builder.append(bookId);
		builder.append(", maturityDate=");
		builder.append(maturityDate);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", expired=");
		builder.append(expired);
		builder.append("]");
		return builder.toString();
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Character getExpired() {
		return expired;
	}

	public void setExpired(Character expired) {
		this.expired = expired;
	}


}