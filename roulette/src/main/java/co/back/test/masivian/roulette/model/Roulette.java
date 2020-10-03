package co.back.test.masivian.roulette.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.back.test.masivian.roulette.dto.BetDTO;


@RedisHash("Roulette")
public class Roulette {

	@Id
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
	
	public void setOneBet(BetDTO bet) {
		this.bets.add(bet);
	}
}
