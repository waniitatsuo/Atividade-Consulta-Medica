package com.consultas.adapters.out.external;

import com.consultas.core.ports.out.PagamentoOnlinePort;
import org.springframework.stereotype.Component;

@Component
public class MockPagamentoAdapter implements PagamentoOnlinePort {
    @Override
    public boolean processarPagamento(int idpaciente, double valor) {
        // Aqui entraria a chamada HTTP (RestTemplate/FeignClient) para a API do banco.
        // Como é um mock para a atividade, vamos aprovar pagamentos acima de 0.
        System.out.println("Processando pagamento via API Externa para o paciente: " + idpaciente);
        return valor > 0;
    }
}
