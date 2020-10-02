package co.back.test.masivian.common.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RouletteDTO {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("bets")
	private List<BetDTO> bets;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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