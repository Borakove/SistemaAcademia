# Sistema de Gerenciamento de Academia

Este é um projeto de um sistema desktop para gerenciamento de uma academia, desenvolvido em Java com interface gráfica e conexão com banco de dados MySQL.

## Motivação e Propósito

Este projeto foi desenvolvido como uma demonstração das minhas habilidades e conhecimentos adquiridos durante o **3º período do curso de Análise e Desenvolvimento de Sistemas**. O principal objetivo é aplicar e consolidar conceitos fundamentais, tais como:

* **Programação Orientada a Objetos (POO):** Modelagem de classes, herança e encapsulamento.
* **Integração com Banco de Dados:** Conexão e manipulação de dados utilizando JDBC (Java Database Connectivity) e SQL.
* **Arquitetura de Software:** Organização do código em camadas lógicas (DAO, Model e View) para manter a modularidade e a manutenibilidade do sistema.
* **Desenvolvimento de Interface Gráfica (GUI):** Construção de uma interface de usuário interativa e amigável.

## Descrição do Projeto

O sistema tem como objetivo centralizar e automatizar o controle de membros, planos de matrícula e pagamentos. Ele oferece uma interface amigável para que o administrador da academia possa realizar operações de forma eficiente e organizada.

## Funcionalidades Principais

* **Gerenciamento de Membros:**
    * Cadastro, edição e exclusão de membros.
    * Busca de membros por nome ou CPF.
    * Visualização de informações detalhadas e plano de cada membro.
* **Gerenciamento de Planos:**
    * Cadastro e controle de diferentes planos (ex: Mensal, Trimestral, Anual).
    * Edição e exclusão de planos existentes.
* **Gerenciamento de Pagamentos:**
    * Registro de pagamentos de mensalidades.
    * Visualização do histórico de pagamentos de cada membro.
    * Controle de pagamentos pendentes ou em atraso.

## Tecnologias Utilizadas

* **Linguagem:** Java
* **Interface Gráfica:** Swing ou JavaFX
* **Banco de Dados:** MySQL
* **Conexão com Banco:** JDBC (MySQL Connector/J)
* **IDE:** IntelliJ IDEA

## Pré-requisitos

Para executar este projeto, você precisará ter o seguinte instalado em sua máquina:

* **Java Development Kit (JDK):** Versão 11 ou superior.
* **MySQL Server:** Versão 8.0 ou superior.
* **MySQL Connector/J:** O driver JDBC para Java (baixe o arquivo `.jar`).

## Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/Borakove/SistemaAcademia.git
    cd SistemaAcademia
    ```
    *(Se você não for usar Git, basta criar o projeto no IntelliJ e seguir os próximos passos.)*

2.  **Configure o Banco de Dados:**
    * Abra o MySQL Workbench ou o terminal.
    * Crie o banco de dados `academia_db` e as tabelas usando os scripts SQL fornecidos (seção **Scripts SQL**).
    * Altere as credenciais de acesso no arquivo `ConexaoDB.java` conforme seu ambiente MySQL (usuário, senha, URL).

3.  **Adicione o Driver JDBC ao Projeto no IntelliJ:**
    * Copie o arquivo `.jar` do **MySQL Connector/J** para a pasta `lib` na raiz do seu projeto.
    * No IntelliJ, vá para **File > Project Structure... > Project Settings > Libraries**.
    * Clique no ícone `+`, selecione **Java**, navegue até a pasta `lib` e selecione o arquivo `.jar`. Clique em OK.

4.  **Execute a Aplicação:**
    * Abra a classe `Main.java`.
    * Clique no botão de 'Play' (executar) no método `main` para iniciar a aplicação.

## Scripts SQL

```sql
-- Crie o banco de dados
CREATE DATABASE academia_db;
USE academia_db;

-- Tabela de Planos
CREATE TABLE Planos (
    id_plano INT PRIMARY KEY AUTO_INCREMENT,
    nome_plano VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    valor DECIMAL(10, 2) NOT NULL
);

-- Tabela de Membros
CREATE TABLE Membros (
    id_membro INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    data_nascimento DATE,
    telefone VARCHAR(20),
    email VARCHAR(100),
    id_plano INT,
    data_adesao DATE NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (id_plano) REFERENCES Planos(id_plano)
);

-- Tabela de Pagamentos
CREATE TABLE Pagamentos (
    id_pagamento INT PRIMARY KEY AUTO_INCREMENT,
    id_membro INT NOT NULL,
    data_pagamento DATE NOT NULL,
    valor_pago DECIMAL(10, 2) NOT NULL,
    mes_referencia DATE,
    status_pagamento VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_membro) REFERENCES Membros(id_membro)
);