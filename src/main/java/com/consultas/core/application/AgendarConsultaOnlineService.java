package com.consultas.core.application;

import com.consultas.core.domain.Consulta;
import com.consultas.core.ports.in.AgendarConsultaOnlineUseCase;
import com.consultas.core.ports.out.ConsultaRepository;
import com.consultas.core.ports.out.PagamentoOnlinePort;
import org.springframework.stereotype.Service;

@Service
public class AgendarConsultaOnlineService implements AgendarConsultaOnlineUseCase {
    private final ConsultaRepository consultaRepository;
    private final PagamentoOnlinePort pagamentoPort;

    public AgendarConsultaOnlineService(ConsultaRepository consultaRepository, PagamentoOnlinePort pagamentoPort) {
        this.consultaRepository = consultaRepository;
        this.pagamentoPort = pagamentoPort;
    }

    @Override
    public Consulta agendar(Consulta consulta, double valorConsulta) {
        // Regra de negócio: Tenta processar o pagamento ANTES de confirmar o agendamento
        boolean pagamentoAprovado = pagamentoPort.processarPagamento(consulta.getIdpaciente(), valorConsulta);

        if (!pagamentoAprovado) {
            throw new IllegalStateException("Pagamento online recusado. O agendamento não pode ser concluído.");
        }

        return consultaRepository.salvar(consulta);
    }
}
