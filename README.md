# Teste Prático (Java) - Atlantic Solutions

Solução criada para o teste prático proposto pela Atlantic Solutions. 
Dentro da aplicação é possível realizar LOGIN como usuário ou responsável

Quando você realiza o login como usuário, você será direcionado para o seu perfil. 
O perfil é uma pagina que mostra as informações do usuário, como: 
  - NOME
  - EMAIL
  - CPF
  - RESPONSÁVEL

Quando o login é realizado como um responsável, você será direcionado para uma tela que possui uma lista de todos os usuários que você é responsável. 
Você pode cadastrar novos usuários, editar usuário ja existentes e ativar/desativar a conta de um usuário.

## Tecnologias usadas

Projeto criado pelo Spring Initializr.
Configurado com padrão MAVEN e com as configurações do SPRING

Versão: Java 17
Banco de Dados: MySQL

- Dependências
  - Spring Boot DevTools
  - Thymeleaf
  - Spring Web
  - Spring Data JPA
  - MySQL Driver
  - Validation
  - Spring Security

## Instalação do projeto

1. Clonagem do projeto:

   - Abrir o terminal do seu sistema
   - Vá até a pasta onde deseja clonar o projeto
   - Execute o seguindo comando para clonar o projeto:

     `git clone <url_do_projeto>`

   - Depois de executar o **_git clone_** entre no diretório onde o projeto se encontra.
  
2. Instalação do IntelliJ:

   - Faça o download do IntelliJ em
   [Download IntelliJ](https://www.jetbrains.com/pt-br/idea/download/?section=windows).

3. Criar Banco de Dados (MySQL)

   - CREATE DATABASE teste_pratico
   - Importar o SQL que está localizado o arquivo do banco de dados
     [SQL](https://github.com/shifaltz/atlantic-solutions-teste/blob/master/banco_de_dados/AtlanticTeste.sql).

4. Configurando ApplicationProperties

  - É necessário verificar duas configurações no arquivo `ApplicationProperties`
    spring.datasource.username= {SEU USER NAME}
    spring.datasource.password= {SUA SENHA}

  
  


