package com.spacex.api.spacexApp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SpacexController {

	@Autowired
	private SpacexService service;

	@GetMapping("/api.spacexdata.com")
	public String home() {
		log.info("Running home method");
		return "home";
	}

	@GetMapping("/api.spacexdata.com/v2/launch")
	public String launch(Model model) {
		log.info("Running launch method");
		List<SpacexDto> dto = service.getAll();
		dto.forEach(c -> log.info(c.toString()));
		model.addAttribute("alldto", dto);
		return "launch";
	}

	@PostMapping("/api.spacexdata.com/v2/filter")
	public String filter(@RequestParam int yearFrom, @RequestParam int yearTo, @RequestParam boolean successful,
			@RequestParam boolean manned, Model model) {
		log.info("Running filter method");
		List<SpacexDto> dto = service.getFiltered(yearFrom, yearTo, successful, manned);
		dto.forEach(c -> log.info(c.toString()));
		model.addAttribute("filteredDto", dto);
		return "filter";
	}

	@PostMapping("/api.spacexdata.com/v2/search")
	public String search(@RequestParam String name, Model model) {
		if (name.equalsIgnoreCase("SUCCESSFUL MISSIONS")) {
			List<SpacexDto> dto = service.getCategory1();
			dto.forEach(c -> System.out.println(c));
			model.addAttribute("successDto", dto);
			return "search";
		} else if (name.equalsIgnoreCase("MANNED MISSIONS")) {
			List<SpacexDto> dto = service.getCategory2();
			dto.forEach(c -> System.out.println(c));
			model.addAttribute("mannedDto", dto);
			return "search";
		}
		List<SpacexDto> dto = service.getSearchByName(name);
		model.addAttribute("name", dto);
		return "search";
	}

}