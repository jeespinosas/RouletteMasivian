package co.back.test.masivian.data.mapper;

import co.back.test.masivian.common.dto.RouletteDTO;
import co.back.test.masivian.data.model.Roulette;

public class RouletteMapper {

	public Roulette toRoulette(RouletteDTO rouletteDTO) {
		Roulette roulette = new Roulette();
		roulette.setId(rouletteDTO.getId());
		roulette.setState(rouletteDTO.getState());
		roulette.setBets(rouletteDTO.getBets());
		
		return roulette;
	}
}
