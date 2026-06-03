# SalesSystem-JDBC

![Java](https://img.shields.io/badge/Java-SE%2017-ED8B00?style=flat&logo=openjdk&logoColor=white)
![JDBC](https://img.shields.io/badge/Persistência-JDBC%20Nativo-336791?style=flat&logo=postgresql&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-4169E1?style=flat&logo=postgresql&logoColor=white)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=flat)

> Sistema de vendas com persistência em PostgreSQL usando **JDBC puro**. O diferencial técnico é a implementação de um **mini-ORM via Reflection API e annotations customizadas**, eliminando SQL repetitivo sem depender de Hibernate ou outro framework externo.

---

## ✨ Destaques Técnicos

- **Mini-ORM proprietário** com `@Tabela`, `@ColunaTabela` e `@TipoChave` — o `GenericDAO` usa Reflection para mapear entidades para SQL automaticamente, sem Hibernate
- **`PreparedStatement` em 100% das queries** — zero risco de SQL Injection
- **Gerenciamento manual de transações** — commit/rollback explícito para garantir atomicidade em operações de venda (múltiplas tabelas)
- **Hierarquia de exceções de negócio** — `DAOException`, `MaisDeUmRegistroException`, `TableException`, separando erros de infraestrutura de erros de domínio
- **Padrão Factory** para hidratação de entidades a partir do `ResultSet`
- **Testes de integração** com banco real: 11 cenários de `VendaDAOTest`

---

## 🏗️ Arquitetura

```
┌─────────────────────────────────────┐
│           CAMADA DE SERVIÇO         │  ← Regras de negócio
│  ClienteService │ ProdutoService    │
└──────────────┬──────────────────────┘
               │ usa interface
┌──────────────▼──────────────────────┐
│            CAMADA DAO               │  ← Acesso ao banco
│  ClienteDAO │ ProdutoDAO │ VendaDAO │
│  └── GenericDAO<T, E> (Reflection)  │
└──────────────┬──────────────────────┘
               │ SQL via PreparedStatement
┌──────────────▼──────────────────────┐
│     PostgreSQL (vendas_online_2)    │
└─────────────────────────────────────┘
```

### Como o mini-ORM funciona

```java
// 1. Você anota a entidade:
@Tabela("TB_CLIENTE")
public class Cliente {
    @TipoChave("getCpf")
    @ColunaTabela(dbName = "cpf", setJavaName = "setCpf")
    private Long cpf;
}

// 2. O GenericDAO lê via Reflection e monta o SQL e o ResultSet automaticamente.
//    Sem código de mapeamento repetitivo em cada DAO.
```

---

## 🛠️ Tecnologias

| Tecnologia | Uso |
|:---|:---|
| Java SE 17 | Linguagem principal |
| JDBC (PostgreSQL Driver) | Integração direta com banco |
| Reflection API | Mapeamento ORM customizado |
| Annotations customizadas | Metadados de mapeamento (`@Tabela`, `@TipoChave`) |
| PostgreSQL | Banco de dados relacional |
| JUnit 4 | Testes de integração |

---

## 🚀 Como Executar

**Pré-requisitos:** JDK 17+, Docker, Eclipse ou IntelliJ IDEA

### 1. Suba o PostgreSQL via Docker Compose
Crie um arquivo `docker-compose.yml` na raiz com o conteúdo abaixo e execute:

```yaml
services:
  postgres:
    image: postgres:latest
    container_name: postgres_db
    environment:
      POSTGRES_USER: seu_usuario
      POSTGRES_PASSWORD: sua_senha
      POSTGRES_DB: vendas_online_2
    ports:
      - "5432:5432"
    volumes:
      - ./postgres_data:/var/lib/postgresql/data

  pgadmin:
    image: dpage/pgadmin4
    container_name: pgadmin_ui
    environment:
      PGADMIN_DEFAULT_EMAIL: seu@email.com
      PGADMIN_DEFAULT_PASSWORD: sua_senha
    ports:
      - "5050:80"
    volumes:
      - ./pgadmin_data:/var/lib/pgadmin
    depends_on:
      - postgres
```

```bash
docker-compose up -d
```

### 2. Configure a conexão
As credenciais estão em:
```
src/br/com/renan/dao/generic/jdbc/ConnectionFactory.java
```
Ajuste usuário e senha conforme seu ambiente se necessário.

### 3. Execute os testes na sua IDE
Este projeto usa Java puro (sem Maven). Importe no Eclipse ou IntelliJ como **Java Project** e execute `VendaDAOTest` via JUnit.

---

## 📌 Contexto no Portfólio

Este é o **projeto 3 de 5** da trilha de evolução técnica:

`UserControl (POO)` → `QualityGuard (Testes)` → **`SalesSystem-JDBC`** → `SalesPersistence-JPA` → `Sales-Microservices`

> *Dominar JDBC antes de usar JPA garante que problemas reais de performance (N+1, transações abertas, pool esgotado) sejam entendidos na raiz, não apenas contornados por um framework.*

---

*Desenvolvido por [Renan Queiroz Eliziario](https://www.linkedin.com/in/renaneliziario/) · [Portfólio completo no GitHub](https://github.com/Renaneliziario)*
