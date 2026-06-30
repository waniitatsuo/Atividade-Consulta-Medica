package com.consultas.core.ports.out;

public interface PagamentoOnlinePort {
    boolean processarPagamento(int idpaciente, double valor);
}
