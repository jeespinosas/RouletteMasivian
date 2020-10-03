package co.back.test.masivian.roulette.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BetDTO {

	@JsonProperty("idUser")
	private Long idUser;
	
	@JsonProperty("betValue")
	private String betValue;
	
	@JsonProperty("userAmount")
	private Integer userAmount;
	
	@JsonProperty("betResult")
	private String betResult;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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
}
