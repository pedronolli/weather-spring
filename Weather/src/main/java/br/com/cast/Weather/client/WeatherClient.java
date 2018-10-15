package br.com.cast.Weather.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.Weather.dto.WeatherDTO;

@Component
public class WeatherClient {
	
	private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/forecast?q={cidade},br&units=metric&mode=json&appid={appid}&lang=pt";
	private static final String APPID = "a0494905f44014dba8941b67ae064ce2";
	
	private RestTemplate restTemplate;
	
	public WeatherClient(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	public WeatherDTO getWeathersByCity(String cidade) {
		WeatherDTO weatherDTO = this.restTemplate.getForObject(WEATHER_URL, WeatherDTO.class,
																	cidade, APPID);
		return weatherDTO;
	}
	
	

}
