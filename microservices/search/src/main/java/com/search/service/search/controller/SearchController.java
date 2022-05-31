package com.search.service.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

import com.search.service.search.models.FormData;
import com.search.service.search.models.Room;
import com.search.service.search.service.SearchService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/rooms")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@PostMapping("/search")
	public List<Room> search(@RequestBody FormData data) throws Exception{
		return searchService.search(data);
	}
	
	@GetMapping("/locations")
	public List<String> search() throws Exception{
		return searchService.locations();
	}
}
