package nl.colfield.bankappbe.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrialEndpoint {

	@GetMapping("trial")
	public String returnString() {
		return "De Bank applicatie is in de Lucht";
	}
}
