# SalesSystem-JDBC: Integração Direta com Banco de Dados e SQL Nativo

Este projeto demonstra o domínio técnico sobre a camada de persistência em Java utilizando **JDBC (Java Database Connectivity)**. Diferente de frameworks ORM, aqui o foco é o controle total sobre a execução de queries SQL, gerenciamento de conexões e transações nativas com o banco de dados **PostgreSQL**.

---

## 🏗️ Arquitetura de Persistência

O sistema foi estruturado para demonstrar como o Java se comunica diretamente com motores de banco de dados relacionais:

1.  **JDBC Nativo:** Uso de `PreparedStatement` para proteção contra SQL Injection e ganho de performance em consultas parametrizadas.
2.  **Gerenciamento de Conexões:** Implementação de uma camada de infraestrutura para abertura e fechamento resiliente de conexões com o driver PostgreSQL.
3.  **Transacionalidade:** Controle manual de `commit` e `rollback`, garantindo a atomicidade das operações complexas de venda (onde múltiplos registros em tabelas diferentes são alterados simultaneamente).

---

## 🛠️ Stack Tecnológica

*   **Java SE (LTS):** Core da aplicação e lógica de negócio.
*   **JDBC (PostgreSQL Driver):** Camada de integração direta com o banco de dados.
*   **PostgreSQL:** Banco de dados relacional robusto utilizado para armazenamento persistente.
*   **Maven:** Automação de build e gerenciamento de dependências.

---

## 🧩 Modelo de Dados e SQL

O projeto gerencia entidades complexas com foco em normalização e integridade:

| Entidade | Responsabilidade |
| :--- | :--- |
| **Cliente** | Gestão de dados cadastrais e identificação única por CPF. |
| **Produto** | Catálogo com controle de estoque e precificação. |
| **Venda** | Orquestração de transações comerciais vinculando clientes e produtos. |

**Destaque Técnico:** Todas as operações de CRUD (Create, Read, Update, Delete) foram escritas em **SQL ANSI**, demonstrando proficiência em scripts de banco de dados e modelagem relacional.

---

## 🚀 Como Executar

### Pré-requisitos
*   Java JDK 17 ou superior.
*   Instância do **PostgreSQL** rodando localmente (porta padrão 5432).
*   Driver JDBC do PostgreSQL configurado no projeto.

### Passos
1.  Importe o projeto em sua IDE (Eclipse/VS Code).
2.  Crie a database `vendas_online_2` no seu PostgreSQL.
3.  Configure as credenciais de acesso no arquivo de configuração de conexão (geralmente em `dao/generic`).
4.  Execute a classe principal para iniciar o sistema e realizar as operações no banco.

---

## 📌 Evolução Técnica
Este projeto é o terceiro estágio da trilha de formação, servindo de ponte entre a lógica em memória e os frameworks de persistência modernos. O domínio do JDBC é o que garante que o desenvolvedor saiba debugar problemas complexos de performance e transações que frameworks automáticos podem ocultar.

---
*Desenvolvido por Renan Queiroz Eliziario como prova de conceito de persistência de dados e SQL nativo.*
