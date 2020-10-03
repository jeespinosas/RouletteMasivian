package co.back.test.masivian.roulette.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.back.test.masivian.roulette.controller.interfaces.IRouletteController;
import co.back.test.masivian.roulette.dao.interfaces.IRouletteServiceRepo;
import co.back.test.masivian.roulette.dto.BetDTO;
import co.back.test.masivian.roulette.dto.RouletteDTO;
import co.back.test.masivian.roulette.util.ConstanstUtil;
import co.back.test.masivian.roulette.util.Response;

@RestController
@RequestMapping("/roulette")
public class RouletteController implements IRouletteController{

	@Autowired
	private IRouletteServiceRepo service;
	
	@Override
	@PostMapping(ConstanstUtil.CREATE_ROULETTE)
	public ResponseEntity<Response> createRoulette() {
		
		return ResponseEntity.ok(service.createRoulette());
	}

	@Override
	@PutMapping(ConstanstUtil.OPEN_ROULETTE + "/{idRoulette}")
	public ResponseEntity<Response> openRoulette(@PathVariable Long idRoulette) {
		
		return ResponseEntity.ok(service.openRoulette(idRoulette));
	}

	@Override
	@PutMapping(ConstanstUtil.WAGER + "/{idRoulette}")
	public ResponseEntity<Response> wagerNumberOrColor(@RequestBody BetDTO bet,
			@RequestHeader(value = "username") String username, @PathVariable Long idRoulette) {		
		if(username != null && bet != null && validBetAmount(bet) 
				&& (validBetValueColor(bet) || validBetValueNumber(bet))) {
			bet.setIdUser(username);
			return ResponseEntity.ok(service.wagerNumberOrColor(bet, idRoulette));
		}
		Response response = new Response();
		response.setStatus(HttpStatus.BAD_REQUEST.toString());
		
		return ResponseEntity.ok(response);
	}

	@Override
	@PutMapping(ConstanstUtil.CLOSE_ROULETTE + "/{id}")
	public ResponseEntity<RouletteDTO> closeRoulette(Long idRoulette) {
		
		return ResponseEntity.ok(service.closeRoulette(idRoulette));
	}

	@Override
	@GetMapping(ConstanstUtil.GET_ROULETTES)
	public ResponseEntity<List<RouletteDTO>> getAllRoulettes() {
		
		return ResponseEntity.ok(service.getAllRoulettes());
	}
	
	private boolean validBetAmount(BetDTO bet) {
		return (bet.getUserAmount() > 0 && bet.getUserAmount() < 10000);
	}

	private boolean validBetValueColor(BetDTO bet) {
		return (bet.getBetValue().equals(ConstanstUtil.RED_COLOR)
				|| bet.getBetValue().equals(ConstanstUtil.BLACK_COLOR));
	}

	private boolean validBetValueNumber(BetDTO bet) {
		try {
			Integer betValue = Integer.parseInt(bet.getBetValue());
			
			return (betValue >= 0 && betValue <= 36);
		} catch (Exception e) {
			
			return false;
		}
	}
}
