package co.back.test.masivian.roulette.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.back.test.masivian.roulette.dao.interfaces.IRouletteServiceRepo;
import co.back.test.masivian.roulette.dto.BetDTO;
import co.back.test.masivian.roulette.dto.RouletteDTO;
import co.back.test.masivian.roulette.mapper.RouletteMapper;
import co.back.test.masivian.roulette.model.Roulette;
import co.back.test.masivian.roulette.repo.IRouletteRepo;
import co.back.test.masivian.roulette.util.ConstanstUtil;

@Service
@Transactional
public class RouletteServiceRepo implements IRouletteServiceRepo{

	@Autowired
	private IRouletteRepo repository;
	
	@Override
	public Long createRoulette() {
		Roulette roulette = new Roulette();
		roulette.setState(ConstanstUtil.ROULETTE_OPEN);
		
		return repository.save(roulette).getIdRoulette();
	}

	@Override
	public Roulette openRoulette(Long idRoulette) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roulette wagerNumberOrColor(BetDTO bet, Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roulette closeRoulette(Long idRoulette) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RouletteDTO> getAllRoulettes() {
		Iterable<Roulette> listRoulettes = repository.findAll();
		List<RouletteDTO> listRoulettesDTO = new ArrayList<>();
		RouletteMapper mapper = new RouletteMapper();
		for(Roulette roulette : listRoulettes) {
			listRoulettesDTO.add(mapper.toRouletteDTO(roulette));
		}
		return listRoulettesDTO;
	}
}
