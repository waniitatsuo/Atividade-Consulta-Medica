# Sistema de Gestão de Consultas e Prontuários Médicos
Este projeto consiste num sistema de software especializado para a gestão de consultas e prontuários médicos de uma clínica de pediatria, desenvolvido para atender os requisitos académicos do **Instituto Federal do Maranhão (IFMA)** na disciplina de **Padrões de Software e Refatoração**.

A aplicação foi projetada seguindo rigorosamente os princípios da **Arquitetura Hexagonal (Ports and Adapters)**, garantindo o desacoplamento total das regras de negócio em relação a frameworks de mercado, tecnologias de persistência e APIs externas.

---

## Desenho Arquitetural (Arquitetura Hexagonal)

O ecossistema do projeto está dividido em três grandes camadas concêntricas independentes:

1. **Core Domain:** Contém as entidades de negócio puras (POJOs), livres de anotações como `@Entity` ou dependências do framework Jakarta/Spring.
2. **Core Application:** Define os Casos de Uso (`Use Cases`) que ditam o comportamento do sistema, além das interfaces que regulam a saída de dados (`Ports`).
3. **Adapters:** Camada tecnológica contendo controladores REST (entrada), repositórios Spring Data JPA com mapeadores isolados, e implementações de simulação de terceiros (saída).

### Estrutura de Pacotes da Aplicação

```text
com.consultas
│
├── core/                               
│   ├── domain/                         
│   │   ├── Consulta.java
│   │   ├── Prontuario.java
│   │   ├── Paciente.java
│   │   ├── Prescricao.java
│   │   ├── Medicamento.java
│   │   ├── Exame.java
│   │   ├── Medico.java
│   │   ├── Endereco.java
│   │   ├── Telefone.java
│   │   ├── PlanoSaude.java
│   │   └── Avaliacao.java
│   │
│   ├── ports/                          
│   │   ├── in/                         
│   │   │   ├── RegistrarProntuarioUseCase.java
│   │   │   ├── AgendarConsultaOnlineUseCase.java
│   │   │   ├── AvaliarAtendimentoUseCase.java
│   │   │   ├── ConsultarHistoricoProntuarioUseCase.java
│   │   │   └── ListarConsultasDoDiaUseCase.java
│   │   └── out/                        
│   │       ├── ConsultaRepository.java
│   │       ├── ProntuarioRepository.java
│   │       ├── PacienteRepository.java
│   │       ├── PagamentoOnlinePort.java
│   │       └── ... (Outras interfaces de persistência)
│   │
│   └── application/                    
│       ├── RegistrarProntuarioService.java
│       ├── AgendarConsultaOnlineService.java
│       └── AvaliarAtendimentoService.java
│
├── adapters/                           
│   ├── in/
│   │   └── web/                        
│   │       ├── ProntuarioController.java
│   │       └── ProntuarioRequestDTO.java
│   └── out/
│       ├── persistence/                
│       │   ├── entities/               
│       │   ├── springdata/             
│       │   └── ...RepositoryAdapter.java 
│       └── external/                   
│           └── MockPagamentoAdapter.java
│
├── ConsultasApplication.java
└── DataLoader.java
```
## Planeamento de Evolução do Sistema 

Abaixo consta o resumo das novas funcionalidades implementadas e o plano para as futuras demandas.

### Funcionalidades Implementadas nesta Etapa

* **I. Atendimento Online (Apenas Pagamentos Online)**
  * **O que já existe:** Foi criada a porta de saída `PagamentoOnlinePort` e o caso de uso `AgendarConsultaOnlineUseCase`. O serviço `AgendarConsultaOnlineService` valida e exige o pagamento aprovado antes de salvar o agendamento. Foi fornecido o `MockPagamentoAdapter` que simula a aprovação na camada de infraestrutura (tecnologia) sem poluir o Core de negócios.
  * **Futura Evolução:** O ciclo da `Consulta` adotará o padrão **State** (Estados: *Agendada*, *Online*, *Realizada*) e o adaptador de pagamento chamará um gateway real (Stripe/PayPal) via HTTP, mantendo o Core intocado (**Princípio Aberto-Fechado - OCP**).

* **V. Sistema de Avaliação e Comentários**
  * **O que já existe:** Implementado através do caso de uso `AvaliarAtendimentoUseCase` e do serviço `AvaliarAtendimentoService`. A classe de domínio `Avaliacao` executa a regra de negócio que valida notas estritamente entre 1 e 5. O `AvaliacaoRepositoryAdapter` faz a persistência usando o Spring Data de forma isolada, protegendo a integridade do domínio.

---

### Planeamento para Futuras Demandas (Teórico)

* **II. Notificações e Lembretes (Consultas e Retornos)**
  * **Padrões:** *Observer* (Event-Driven).
  * **Evolução:** Ao agendar ou encerrar consultas, o Core publicará eventos (ex: `ConsultaAgendadaEvent`). Adaptadores assíncronos na infraestrutura (*Listeners*) capturarão o evento e farão os disparos por SMS ou WhatsApp, mantendo alta coesão e responsabilidade única (**SRP**).

* **III. Compartilhamento e Integração (Sistemas de Saúde e CRM externo)**
  * **Padrões:** *Adapter* e *Facade*.
  * **Evolução:** Serão criadas portas de saída isoladas (`RegistroSaudeNacionalPort` e `ValidadorCRMPort`). Os adaptadores concretos farão a conversão para formatos de prontuário (HL7/FHIR) ou requisições HTTP para a API do Conselho de Medicina, protegendo o Core contra mudanças em APIs de terceiros.

* **IV. Suporte a Múltiplas Clínicas e Médicos (Escalabilidade)**
  * **Padrões:** *Strategy* e abordagem *Multitenancy*.
  * **Evolução:** O banco será isolado incluindo um campo identificador (`TenantId`) em cada registro. Caso clínicas diferentes exijam regras ou taxas distintas, o padrão **Strategy** injetará o algoritmo de preço correto dinamicamente com base no contexto, eliminando blocos de `if/else` complexos.
