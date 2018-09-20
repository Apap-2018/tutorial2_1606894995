package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping(value = {"/challenge", "challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name","KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required = false, defaultValue = "0") int a, @RequestParam(value="b", required = false, defaultValue = "0") int b, Model model) {
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		String hasil = "";
		
		
		
		if (a == 0 && b == 0) {
			hasil = "hm";
		}
		else if (a == 0 && b>0) {
			String kata = "hm ";
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i<b; i++) {
				builder.append(kata);	
			}
			hasil = builder.toString();
			System.out.println(builder.toString());
			
		}
		else if (a>0 && b==0) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i<a; i++) {
				builder.append("m");	
			}
			hasil = "h" + builder.toString();
		}
		else if (a>0 && b>0) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i<a; i++) {
				builder.append("m");	
			}
			String satuHm = "h" + builder.toString() + " ";
			StringBuilder builder2 = new StringBuilder();
			for (int i = 0; i<b; i++) {
				builder2.append(satuHm);	
			}
			hasil = builder2.toString();
			
		}
		model.addAttribute("hasil", hasil);
		
		return "generator";
	}
}
