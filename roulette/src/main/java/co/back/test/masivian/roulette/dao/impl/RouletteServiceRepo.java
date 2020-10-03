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
		if (roulette.isPresent() 
				&& !roulette.get().getState().equals(ConstanstUtil.OPEN)) {
			Roulette rouletteEntity = roulette.get();
			response.setStatus(HttpStatus.ACCEPTED.toString());
			response.setMessage(ConstanstUtil.OK);
			rouletteEntity.setState(ConstanstUtil.OPEN);
			repository.save(rouletteEntity);
			
			return response;
		}
		response.setStatus(HttpStatus.BAD_REQUEST.toString());
		response.setMessage(ConstanstUtil.FAILED);
		response.setInfoMessage("La ruleta se encuentra abierta");
		return response;
	}

	@Override
	public Response wagerNumberOrColor(BetDTO bet, Long idRoulette) {
		Response response = new Response();
		Optional<Roulette> roulette = repository.findById(idRoulette);
		if (roulette.isPresent()) {
			Roulette rouletteEntity = roulette.get();
			if (rouletteEntity.getState().equals(ConstanstUtil.OPEN)) {
				rouletteEntity.setOneBet(bet);
				repository.save(rouletteEntity);
				response.setStatus(HttpStatus.CREATED.toString());
				response.setMessage("Apuesta realizada con exito");
			} else {
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
				response.setMessage("La apuesta no se realizo con exito");

				return response;
			}
		} else { 
			response.setStatus(HttpStatus.NOT_FOUND.toString());
			response.setMessage("La ruleta no se encuentra");
		}
		return response;
	}

	@Override
	public RouletteDTO closeRoulette(Long idRoulette) {
		Optional<Roulette> roulette = repository.findById(idRoulette);
		RouletteDTO rouletteDTO = new RouletteDTO();
		RouletteMapper mapper = new RouletteMapper();
		List<BetDTO> bets = new ArrayList<>();
		if (roulette.isPresent()) {
			Roulette rouletteEntity = roulette.get();
			for (BetDTO bet : rouletteEntity.getBets()) {
				int winningNumber = (int) (Math.random() * 36);
				String winningColor = selectColor(winningNumber);
				bets.add(validatePrice(bet, winningColor, winningNumber));
			}
			rouletteEntity.setState(ConstanstUtil.CLOSED);
			rouletteEntity.setBets(new ArrayList<>());
			repository.save(rouletteEntity);
			rouletteEntity.setBets(bets);
			rouletteDTO = mapper.toRouletteDTO(rouletteEntity);

			return rouletteDTO;
		}

		return rouletteDTO;
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

	private String selectColor(int number) {
		if (number % 2 == 0) {

			return ConstanstUtil.RED_COLOR;
		} else {

			return ConstanstUtil.BLACK_COLOR;
		}
	}

	private boolean validateWIn(String betValue, int winningNumber, String winningColor) {
		
		return (betValue.equals(winningColor) 
				|| betValue.equals(String.valueOf(winningNumber)));
	}

	private BetDTO validatePrice(BetDTO bet, String winningColor, int winningNumber) {
		if(bet.getBetValue().equals(winningColor) 
				&& validateWIn(bet.getBetValue(), winningNumber, winningColor)) {
			bet.setBetResult(ConstanstUtil.WINNER);
			bet.setResultAmount(bet.getUserAmount() * 1.8);
			
			return bet;
		}
		else if(bet.getBetValue().equals(String.valueOf(winningNumber)) 
				&& validateWIn(bet.getBetValue(), winningNumber, winningColor)) {
			bet.setBetResult(ConstanstUtil.WINNER);
			bet.setResultAmount(Double.valueOf(bet.getUserAmount())* 5);
			
			return bet;
		}
		else {
			bet.setBetResult(ConstanstUtil.LOSER);
			bet.setResultAmount(0.0);

			return bet;
		}
	}
}
