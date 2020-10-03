package co.back.test.masivian.roulette.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BetDTO {

	@JsonProperty("idUser")
	private String username;
	
	@JsonProperty("betValue")
	private String betValue;
	
	@JsonProperty("userAmount")
	private Integer userAmount;
	
	@JsonProperty("betResult")
	private String betResult;
	
	@JsonProperty("resultAmount")
	private Double resultAmount;

	public String getIdUser() {
		return username;
	}

	public void setIdUser(String username) {
		this.username = username;
	}

	public String getBetValue() {
		return betValue;
	}

	public void setBetValue(String betValue) {
		this.betValue = betValue;
	}

	public Integer getUserAmount() {
		return userAmount;
	}

	public void setUserAmount(Integer userAmount) {
		this.userAmount = userAmount;
	}

	public String getBetResult() {
		return betResult;
	}

	public void setBetResult(String betResult) {
		this.betResult = betResult;
	}

	public Double getResultAmount() {
		return resultAmount;
	}

	public void setResultAmount(Double resultAmount) {
		this.resultAmount = resultAmount;
	}
}
