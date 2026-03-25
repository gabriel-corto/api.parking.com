### Parking API

A Parking API é uma solução robusta para o gerenciamento de pátios de estacionamento, permitindo o controle completo sobre o fluxo de veículos, ocupação de vagas e histórico de utilizações.

### Descrição

Esta API fornece um conjunto de endpoints REST para automatizar as operações de check-in e check-out de veículos, monitoramento de vagas em tempo real e persistência de dados históricos. O sistema foi projetado com foco em escalabilidade e manutenção, seguindo princípios de arquitetura limpa e separação de preocupações.

### Funcionalidades Principais

- Realização de Check-in de veículos com validação de placa e disponibilidade de vaga.
- Realização de Check-out com cálculo automático de permanência e liberação de vaga.
- Consulta de veículos atualmente estacionados no pátio.
- Listagem detalhada de todas as vagas e seu status de ocupação.
- Consulta de vagas disponíveis para novos estacionamentos.
- Acesso ao histórico completo de tickets gerados pelo sistema.

### Tecnologias Utilizadas

- Linguagem: Java 21 (OpenJDK Temurin).
- Framework: Spring Boot com Spring Data JPA e Spring Web.
- Banco de Dados: PostgreSQL 15.
- Gerenciamento de Dependências: Gradle.
- Containerização: Docker e Docker Compose.
- Build: Docker Multi-stage para otimização de imagem.

### Abordagens Técnicas e Arquiteturais

- Clean Architecture: Divisão clara entre as camadas de domínio, aplicação e infraestrutura para garantir independência de frameworks e facilidade de teste.
- Use Case Pattern: Implementação da lógica de negócio através de casos de uso específicos, promovendo o princípio da responsabilidade única.
- Repository Pattern: Abstração da camada de dados para facilitar a substituição ou evolução do mecanismo de persistência.
- Tratamento Global de Exceções: Sistema centralizado para captura e formatação de erros, fornecendo respostas HTTP dinâmicas e informativas.
- Dockerização Avançada: Utilização de multi-stage builds para separar o ambiente de compilação do ambiente de execução, resultando em imagens de produção seguras e de tamanho reduzido.
- Toolchain Java 21: Aproveitamento dos recursos mais recentes da JVM para performance e produtividade.

### Como Executar?

Para iniciar a aplicação e o banco de dados simultaneamente, utilize o comando:

```bash
docker compose up --build
```

A API estará disponível em `http://localhost:8080`

### Documentação

A documentação da API está disponível em `http://localhost:8080/swagger-ui.html`
