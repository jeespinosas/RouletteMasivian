package co.back.test.masivian.roulette.dao.interfaces;

import java.util.List;

import co.back.test.masivian.roulette.dto.BetDTO;
import co.back.test.masivian.roulette.dto.RouletteDTO;
import co.back.test.masivian.roulette.model.Roulette;

public interface IRouletteServiceRepo {

	public Long createRoulette();
	
	public Roulette openRoulette(Long idRoulette);
	
	public Roulette wagerNumberOrColor(BetDTO bet, Long idUser);
	
	public Roulette closeRoulette(Long idRoulette);
	
	public List<RouletteDTO> getAllRoulettes();
}
