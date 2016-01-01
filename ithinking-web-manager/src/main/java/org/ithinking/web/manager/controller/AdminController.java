package org.ithinking.web.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "Hello World!";
	}
}
