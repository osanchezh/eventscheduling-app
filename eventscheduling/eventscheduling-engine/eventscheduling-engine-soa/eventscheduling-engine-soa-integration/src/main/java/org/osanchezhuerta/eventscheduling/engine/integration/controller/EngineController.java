package org.osanchezhuerta.eventscheduling.engine.integration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/engine")
public class EngineController {

	@RequestMapping("/all")
	public @ResponseBody String getAll() {
		return "example";
	}

}
