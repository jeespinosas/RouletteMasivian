package co.back.test.masivian.roulette.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.back.test.masivian.roulette.controller.interfaces.IRouletteController;
import co.back.test.masivian.roulette.dao.interfaces.IRouletteServiceRepo;
import co.back.test.masivian.roulette.dto.BetDTO;
import co.back.test.masivian.roulette.util.ConstanstUtil;
import co.back.test.masivian.roulette.util.Response;

@RestController
@RequestMapping("/roulette")
public class RouletteController implements IRouletteController{

	@Autowired
	private IRouletteServiceRepo service;
	
	@Override
	@PostMapping(ConstanstUtil.POST_CREATE_ROULETTE)
	public ResponseEntity<Response> createRoulette() {
		Response response = new Response(HttpStatus.CREATED, ConstanstUtil.MESSAGE_CREATED);
		response.addPayload("idRoulette", service.createRoulette());
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Response> openRoulette(Long idRoulette) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response> wagerNumberOrColor(BetDTO bet, Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response> closeRoulette(Long idRoulette) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(ConstanstUtil.GET_ROULETTES)
	public ResponseEntity<Response> getAllRoulettes() {
		Response response = new Response(HttpStatus.OK, ConstanstUtil.OK);
		response.addPayload("roulettes", service.getAllRoulettes());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
