package br.com.farol.teste.colaborador.jms;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

import br.com.farol.teste.colaborador.model.ColaboradorFila;

@Component
@RequiredArgsConstructor
public class Producer {

	@Autowired
    private JmsTemplate jmsTemplate;

    @Value("fila.colaborador")
    private String destinationQueue;

    public void send(ColaboradorFila colaborador){
        Gson gson = new Gson();
        String dadosFunc = gson.toJson(colaborador);
        jmsTemplate.convertAndSend(destinationQueue, dadosFunc);
    }

}
