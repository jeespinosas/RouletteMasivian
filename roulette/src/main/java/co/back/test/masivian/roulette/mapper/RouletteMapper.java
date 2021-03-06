package co.back.test.masivian.roulette.mapper;

import co.back.test.masivian.roulette.dto.RouletteDTO;
import co.back.test.masivian.roulette.model.Roulette;

public class RouletteMapper {

	public Roulette toRoulette(RouletteDTO rouletteDTO) {
		Roulette roulette = new Roulette();
		roulette.setIdRoulette(rouletteDTO.getIdRoulette());
		roulette.setState(rouletteDTO.getState());
		roulette.setBets(rouletteDTO.getBets());
		
		return roulette;
	}
	
	public RouletteDTO toRouletteDTO(Roulette roulette) {
		RouletteDTO rouletteDTO = new RouletteDTO();
		rouletteDTO.setIdRoulette(roulette.getIdRoulette());
		rouletteDTO.setState(roulette.getState());
		rouletteDTO.setBets(roulette.getBets());
		
		return rouletteDTO;
	}
}
