package lv.venta.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/simple")
public class SimpleController {
	
	@GetMapping("/page") //localhost:8080/simple/page
	public String getShowPage() {
		System.out.println("Controller has been called");
		return "show-page"; //show-page.html is shown, html files are put in templates
	}
	
	@GetMapping("/data")
	public String getDataInPage(Model model) {
		System.out.println("Data controller has been called");
		Random rand = new Random();
		String data = "@Elvijs " + rand.nextInt(1, 1000);
		model.addAttribute("package", data);
		return "show-data-page";
	}
}
