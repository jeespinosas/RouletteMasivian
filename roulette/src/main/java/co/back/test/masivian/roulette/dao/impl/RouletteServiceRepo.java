package co.back.test.masivian.roulette.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.back.test.masivian.roulette.dao.interfaces.IRouletteServiceRepo;
import co.back.test.masivian.roulette.dto.BetDTO;
import co.back.test.masivian.roulette.dto.RouletteDTO;
import co.back.test.masivian.roulette.mapper.RouletteMapper;
import co.back.test.masivian.roulette.model.Roulette;
import co.back.test.masivian.roulette.repo.IRouletteRepo;
import co.back.test.masivian.roulette.util.ConstanstUtil;
import co.back.test.masivian.roulette.util.Response;

@Service
@Transactional
public class RouletteServiceRepo implements IRouletteServiceRepo {

	@Autowired
	private IRouletteRepo repository;

	@Override
	public Response createRoulette() {
		Roulette roulette = new Roulette();
		roulette.setState(ConstanstUtil.CLOSED);
		Response response = new Response();
		response.setStatus(HttpStatus.CREATED.toString());
		response.setMessage(ConstanstUtil.MESSAGE_CREATED);
		response.setInfoMessage("id ruleta " + repository.save(roulette).getIdRoulette());

		return response;
	}

	@Override
	public Response openRoulette(Long idRoulette) {
		Optional<Roulette> roulette = repository.findById(idRoulette);
		Response response = new Response();
		if (roulette.isPresent()) {
			Roulette rouletteEntity = roulette.get();
			response.setStatus(HttpStatus.ACCEPTED.toString());
			response.setMessage(ConstanstUtil.OK);
			rouletteEntity.setState(ConstanstUtil.OPEN);
			repository.save(rouletteEntity);
		}
		response.setStatus(HttpStatus.BAD_REQUEST.toString());
		response.setMessage(ConstanstUtil.FAILED);

		return response;
	}

	@Override
	public Response wagerNumberOrColor(BetDTO bet, Long idRoulette) {
		Response response = new Response();
		Optional<Roulette> roulette = repository.findById(idRoulette);
		if (roulette.isPresent()) {
			Roulette rouletteEntity = roulette.get();
			if(rouletteEntity.getState().equals(ConstanstUtil.OPEN)) {
				rouletteEntity.setOneBet(bet);
				repository.save(rouletteEntity);
				response.setMessage(HttpStatus.ACCEPTED.toString());
				response.setInfoMessage("Apuesta realizada con exito");
			} else {
				response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
				response.setInfoMessage("La apuesta no se realizo con exito");
				
				return response;
			}
		}
		response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		response.setInfoMessage("La apuesta no se realizo con exito");
		
		return response;
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
		for (Roulette roulette : listRoulettes) {
			listRoulettesDTO.add(mapper.toRouletteDTO(roulette));
		}

		return listRoulettesDTO;
	}
}
