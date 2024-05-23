package hvl.no.firma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registerAnsatt")
public class AnsattController {
	
	@GetMapping
	public String getRegisterSide() {
		return "registerAnsatt";
	}

}
