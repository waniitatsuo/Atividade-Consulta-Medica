package com.consultas;

import com.consultas.adapters.out.persistence.*;
import com.consultas.adapters.out.persistence.springdata.SpringDataConsultaRepository;
import com.consultas.adapters.out.persistence.springdata.SpringDataExameRepository;
import com.consultas.adapters.out.persistence.springdata.SpringDataMedicamentoRepository;
import com.consultas.core.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DataLoader implements CommandLineRunner {

    private final EnderecoRepositoryAdapter enderecoRepository;
    private final PlanoSaudeRepositoryAdapter planoSaudeRepository;
    private final PacienteRepositoryAdapter pacienteRepository;
    private final SpringDataMedicamentoRepository medicamentoRepository;
    private final SpringDataExameRepository exameRepository;
    private final SpringDataConsultaRepository consultaRepository;

    public DataLoader(EnderecoRepositoryAdapter enderecoRepository,
                      PlanoSaudeRepositoryAdapter planoSaudeRepository,
                      PacienteRepositoryAdapter pacienteRepository,
                      SpringDataMedicamentoRepository medicamentoRepository,
                      SpringDataExameRepository exameRepository,
                      SpringDataConsultaRepository consultaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.planoSaudeRepository = planoSaudeRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicamentoRepository = medicamentoRepository;
        this.exameRepository = exameRepository;
        this.consultaRepository = consultaRepository;
    }

    @Override
    public void run(String... args) {
        // Evita duplicar dados se já existirem
        if (consultaRepository.count() > 0) return;

        // --- ENDEREÇOS ---
        Endereco endereco1 = enderecoRepository.save(
                new Endereco(0, "Rua das Flores", "123", "Apto 2", "Centro", "São Luís", "MA", "65000-000"));
        Endereco endereco2 = enderecoRepository.save(
                new Endereco(0, "Av. Principal", "456", null, "Jardim", "São Luís", "MA", "65010-000"));

        // --- PLANOS DE SAÚDE ---
        PlanoSaude plano1 = planoSaudeRepository.save(new PlanoSaude(0, "Unimed"));
        PlanoSaude plano2 = planoSaudeRepository.save(new PlanoSaude(0, "Bradesco Saúde"));

        // --- PACIENTES ---
        Paciente paciente1 = new Paciente(0, "João Silva", "Maria Silva", 20180510, "M", endereco1.getIdendereco());
        paciente1.vincularPlanoSaude(plano1.getIdplanoSaude());
        paciente1 = pacienteRepository.salvar(paciente1);

        Paciente paciente2 = new Paciente(0, "Ana Souza", "Carlos Souza", 20200315, "F", endereco2.getIdendereco());
        paciente2 = pacienteRepository.salvar(paciente2);

        // --- MEDICAMENTOS ---
        Medicamento med1 = medicamentoRepository.save(new Medicamento(0, "Dipirona 500mg"));
        Medicamento med2 = medicamentoRepository.save(new Medicamento(0, "Amoxicilina 250mg"));
        Medicamento med3 = medicamentoRepository.save(new Medicamento(0, "Ibuprofeno 300mg"));

        // --- EXAMES ---
        Exame exame1 = exameRepository.save(new Exame(0, "Hemograma Completo"));
        Exame exame2 = exameRepository.save(new Exame(0, "Raio-X Tórax"));
        Exame exame3 = exameRepository.save(new Exame(0, "Urina Tipo I"));

        // --- CONSULTAS ---
        Consulta consulta1 = new Consulta(0, paciente1.getIdpaciente(), 1, 20240625, false);
        consultaRepository.save(consulta1);

        Consulta consulta2 = new Consulta(0, paciente2.getIdpaciente(), 1, 20240625, true);
        consultaRepository.save(consulta2);

        System.out.println("=== DADOS DE TESTE CARREGADOS ===");
        System.out.println("Paciente 1 ID: " + paciente1.getIdpaciente() + " - João Silva");
        System.out.println("Paciente 2 ID: " + paciente2.getIdpaciente() + " - Ana Souza");
        System.out.println("Consulta 1 ID: " + consulta1.getIdconsulta() + " (paciente 1)");
        System.out.println("Consulta 2 ID: " + consulta2.getIdconsulta() + " (paciente 2)");
        System.out.println("=================================");
    }
}