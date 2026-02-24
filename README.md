
# 🛒 Sistema de Vendas

Sistema de gerenciamento de vendas desenvolvido em **Java** para praticar conceitos fundamentais de desenvolvimento backend.

## 📋 Funcionalidades
- Cadastro de produtos
- Cadastro de clientes  
- Registro de vendas
- Relatórios básicos

## 🛠️ Tecnologias
- **Java 17+**
- **Maven**
- **JDBC** (acesso direto ao banco)
- **PostgreSQL/MySQL**

## 🚀 Como executar
```bash
# 1. Clonar repositório
git clone https://github.com/Renaneliziario/sistemaVendas.git

# 2. Configurar banco de dados
# Criar database 'vendas'

# 3. Executar
mvn compile exec:java -Dexec.mainClass="br.com.renan.Main"
