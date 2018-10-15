package br.com.cast.Weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.Weather.dto.ResponseWeatherDTO;
import br.com.cast.Weather.service.WeatherService;

@RestController
@RequestMapping(path="/previsao")
public class WeatherController {
	
	@Autowired
	private WeatherService ws;
	
	@GetMapping
	public List<ResponseWeatherDTO> getWeatherByCity(@RequestParam("cidade") String cidade) {
		List<ResponseWeatherDTO> responses = ws.getWeathersByCity(cidade);
		return responses;
	}
}
