package br.com.farol.teste.ponto.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.farol.teste.ponto.dto.InfoColaboradorDto;

@FeignClient("colaborador")
public interface ColaboradorClient {

	@RequestMapping("/info/{id}")
	InfoColaboradorDto getInfoColaboradorPorId(@PathVariable long id);
	
		
}
