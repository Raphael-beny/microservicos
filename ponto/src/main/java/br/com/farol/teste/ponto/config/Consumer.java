package br.com.farol.teste.ponto.config;
//
//import java.util.ArrayList; 
//import java.util.List; 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener; 
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.farol.teste.ponto.model.Colaborador;
import br.com.farol.teste.ponto.repository.ColaboradorRepository;
import lombok.RequiredArgsConstructor; 

@RequiredArgsConstructor
@Component 
public class Consumer { 

	
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;

    @JmsListener (destination = "fila.colaborador") 
    public void listen (String mensagem) { 
        System.out.println (mensagem); 
        Colaborador colaborador = new Colaborador(); 
        try { 
        	Gson gson = new Gson (); 
        	colaborador = gson.fromJson(mensagem, Colaborador.class);
        	System.out.println(colaborador.getNome());
        	System.out.println(colaborador.getId());
        	System.out.println(colaborador.getId().getClass(). getSimpleName());
    		
        	colaboradorRepository.save(colaborador);
        	
        	System.out.println("ponto do funcionario "+colaborador.getNome()+" registrado com sucesso!");
        } catch (Exception e) { 
    	  System.out.println(e);
        } 
        
    } 

}
