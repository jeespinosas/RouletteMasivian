package co.back.test.masivian.data.dao.interfaces;

import java.util.List;

import co.back.test.masivian.common.dto.BetDTO;
import co.back.test.masivian.data.model.Roulette;

public interface IRouletteServiceRepo {

	public Long createRoulette();
	
	public Roulette openRoulette(Long idRoulette);
	
	public Roulette wagerNumberOrColor(BetDTO bet, Long idUser);
	
	public Roulette closeRoulette(Long idRoulette);
	
	public List<Roulette> getAllRoulettes();
}
