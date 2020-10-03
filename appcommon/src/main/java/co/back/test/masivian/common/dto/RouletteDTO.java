package co.back.test.masivian.common.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RouletteDTO {

	@JsonProperty("id")
	private Long idRoulette;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("bets")
	private List<BetDTO> bets;

	public Long getIdRoulette() {
		return idRoulette;
	}

	public void setIdRoulette(Long idRoulette) {
		this.idRoulette = idRoulette;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<BetDTO> getBets() {
		return bets;
	}

	public void setBets(List<BetDTO> bets) {
		this.bets = bets;
	}
}
