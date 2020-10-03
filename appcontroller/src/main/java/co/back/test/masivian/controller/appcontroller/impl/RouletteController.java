package co.back.test.masivian.controller.appcontroller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roulette")
public class RouletteController {

	@GetMapping("/prueba")
	public ResponseEntity<String> prueba() {
		return ResponseEntity.ok("Hola");
	}
}
