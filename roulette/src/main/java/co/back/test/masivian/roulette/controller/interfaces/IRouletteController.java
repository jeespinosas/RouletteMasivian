package co.back.test.masivian.roulette.controller.interfaces;

import org.springframework.http.ResponseEntity;

import co.back.test.masivian.roulette.dto.BetDTO;
import co.back.test.masivian.roulette.util.Response;

public interface IRouletteController {

	public ResponseEntity<Response> createRoulette();
	
	public ResponseEntity<Response> openRoulette(Long idRoulette);
	
	public ResponseEntity<Response> wagerNumberOrColor(BetDTO bet, Long idUser);
	
	public ResponseEntity<Response> closeRoulette(Long idRoulette);
	
	public ResponseEntity<Response> getAllRoulettes();
}
