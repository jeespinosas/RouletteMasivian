package co.back.test.masivian.roulette.dao.interfaces;

import java.util.List;

import co.back.test.masivian.roulette.dto.BetDTO;
import co.back.test.masivian.roulette.dto.RouletteDTO;
import co.back.test.masivian.roulette.model.Roulette;
import co.back.test.masivian.roulette.util.Response;

public interface IRouletteServiceRepo {

	public Response createRoulette();
	
	public Response openRoulette(Long idRoulette);
	
	public Response wagerNumberOrColor(BetDTO bet, Long idRoulette);
	
	public Roulette closeRoulette(Long idRoulette);
	
	public List<RouletteDTO> getAllRoulettes();
}
