package br.com.cast.Weather.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.Weather.client.WeatherClient;
import br.com.cast.Weather.dto.ResponseWeatherDTO;
import br.com.cast.Weather.dto.WeatherDTO;
import br.com.cast.Weather.dto.WeatherDataDTO;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherClient wc;
	
	public List<ResponseWeatherDTO> getWeathersByCity(String cidade){
		WeatherDTO weatherDTO = wc.getWeathersByCity(cidade);
		List<ResponseWeatherDTO> responses = new ArrayList<>();
		
		for (WeatherDataDTO data : weatherDTO.getList()) {
			ResponseWeatherDTO result = new ResponseWeatherDTO();
			
			result.setData(data.getData());
			result.setHumidity(data.getMain().getHumidity());
			result.setPressure(data.getMain().getPressure());
			result.setTempMax(data.getMain().getTempMax());
			result.setTempMin(data.getMain().getTempMin());
			
			responses.add(result);
			
		}
	
		return responses;
	}
}
