package co.back.test.masivian.roulette.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.back.test.masivian.roulette.dto.BetDTO;
import co.back.test.masivian.roulette.dto.RouletteDTO;
import co.back.test.masivian.roulette.util.Response;

public interface IRouletteController {

	public ResponseEntity<Response> createRoulette();
	
	public ResponseEntity<Response> openRoulette(Long idRoulette);
	
	public ResponseEntity<Response> wagerNumberOrColor(BetDTO bet, String username, Long Roulette);
	
	public ResponseEntity<RouletteDTO> closeRoulette(Long idRoulette);
	
	public ResponseEntity<List<RouletteDTO>> getAllRoulettes();
}
