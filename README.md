[JAVA__BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[gRPC__BADGE]: https://img.shields.io/badge/gRPC-%2300B3E6.svg?style=for-the-badge&logo=grpc&logoColor=white

<h1 align="center" style="font-weight: bold;" id="top">Cadastro de Clientes 💻</h1>

<h1 align="center">

  <span>![java][JAVA__BADGE]</span>
  <span>![gRPC][gRPC__BADGE]</span>
</h1>

<p align="center">
  <a href="#about">Sobre o Projeto</a> •
  <a href="#tech">Tecnologias Utilizadas</a> •
  <a href="#started">Como Executar</a> •
  <a href="#routes">Rotas da Aplicação</a> •
  <a href="#author">Autor</a>
</p>

<h2 id="about">📌 Sobre o Projeto</h2>

Este projeto foi desenvolvido com o objetivo de explorar e aplicar os conceitos de comunicação gRPC entre serviços. Ele consiste em dois módulos principais: um atuando como Servidor e outro como Cliente, demonstrando como serviços podem interagir de forma eficiente usando o protocolo gRPC.

Além de implementar e compreender os fundamentos do gRPC, o projeto busca demonstrar as vantagens dessa tecnologia em relação a outros padrões de comunicação, como REST, através do uso de Protocol Buffers (Protobuf) permite a serialização binária das mensagens, reduzindo o tamanho das requisições e respostas.

[Voltar ao Início](#top)

<br>

<h2 id="project-architecture">🚀 Arquitetura do Projeto</h2>

O contrato da comunicação entre Cliente e Servidor foi definido em um arquivo chamado `gRPC.proto`. Esse arquivo contém:

- A especificação dos serviços (métodos RPC) disponíveis no servidor.
- A definição das mensagens que serão enviadas e recebidas durante a comunicação.

Com o auxílio do compilador `protoc`, foram geradas automaticamente as classes necessárias para ambos os serviços, incluindo:

- **Mensagens**: Representações das entidades definidas no .proto (serializáveis em formato binário).
- **Stubs**: Classes que encapsulam a lógica de chamada remota (usadas pelo cliente para invocar métodos no servidor).
- **Skeletons**: Interfaces ou bases que servem como ponto de partida para implementar os serviços no lado do servidor.

### Detalhes de Implementação

#### Servidor

- Foi implementada uma classe de serviço derivada do skeleton gerado pelo compilador. Essa classe contém a lógica dos métodos RPC definidos no arquivo gRPC.proto.

- O serviço implementado foi registrado em um servidor gRPC, configurado para escutar requisições na porta 8999. O servidor fica responsável por processar as chamadas recebidas e enviar as respostas adequadas ao cliente.

#### Cliente

- O cliente foi configurado para se conectar ao servidor através de um canal (Channel), que representa a conexão lógica entre ambos.

- A partir desse canal, foram criados stubs, que permitem ao cliente invocar os métodos RPC do servidor de forma simples e transparente. Esses métodos correspondem diretamente às definições do arquivo `gRPC.proto`.

[Voltar ao Início](#top)

<br>

<h2 id="tech">🖥️ Tecnologias Utilizadas</h2>

### Serviço

- [Java](https://www.oracle.com/java/technologies/java-se-glance.html)
- [Spring Boot](https://github.com/spring-projects/spring-boot)
- [gRPC](https://grpc.io/)

[Voltar ao Início](#top)

<br>

<h2 id="started">🚀 Como Executar</h2>

### Pre-requisitos

Os pré-requisitos para rodar localmente o projeto são:

- [NodeJS](https://github.com/nodejs/nodejs.org) >= 18
- [JDK 8](https://www.oracle.com/java/technologies/downloads/?er=221886)
- [Maven](https://maven.apache.org/)

O projeto também pode ser executado por containers, sendo assim os pré-requisitos são:

- [Docker](https://www.docker.com/)

### Cloning

Para clonar o projeto, abra o terminal e execute o seguinte comando:

```bash
git clone git@github.com:SilmarNascimento/test-fullstack-gerenciamento-de-cliente.git
```

### Executar o Projeto Localmente

Antes de iniciar o backend, é necessário subir o banco de dados PostgreSQL localmente. Se você já tem o PostgreSQL instalado, inicie o serviço e crie o banco de dados necessário para o projeto. Se preferir, pode usar o Docker para subir o banco rapidamente. Certifique-se de que o banco está rodando na porta `5432` e guarde as credenciais para configurar o backend.

Após iniciar o serviço de banco de dados, instale as dependências do backend java executando os seguintes comandos:

```bash
# entrar na pasta do backend
cd test-fullstack-gerenciamento-de-cliente/backend

# instalar as dependências do projeto
mvn clean install
```

Como a aplicação precisa se conectar a um banco de dados, será necessário configurar as credenciais corretas no arquivo de propriedades do Spring Boot. Para isso, você precisará definir as variáveis de ambiente no arquivo application-dev.properties.

```bash
# entrar na pasta de recursos do backend
cd src/main/resources
```

No arquivo application-dev.properties, você verá as seguintes configurações de conexão com o banco de dados de modo que será necessário substituir as variáveis `${DATABASE_URL}`, `${DATABASE_USERNAME}`, e `${DATABASE_PASSWORD}` pelos valores reais:

```bash
# substituir os valores abaixo pelas variáveis
spring.datasource.url=${DATABASE_URL}
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
```

Após substituir os valores no arquivo de propriedades, você pode subir a aplicação backend executando o seguinte comando:

```bash
# subir a aplicação backend
mvn spring-boot:run
```

Esse comando irá iniciar o servidor da aplicação backend. Por padrão, ele estará disponível em <http://localhost:8080>

Agora que o backend está rodando, você pode subir o frontend da aplicação. Siga os passos abaixo:

```bash
# Entrar na pasta do frontend
cd ../../../../frontend

# Instalar as dependências do frontend
npm install
```

Para iniciar o frontend da aplicação siga o seguinte comando:

```bash
# Subir a aplicação frontend
npm run dev
```

O frontend estará disponível em <http://localhost:3000> e se comunicará com o backend que está rodando em <http://localhost:8080>.

Com esses passos, o projeto estará rodando localmente com o banco de dados, backend e frontend funcionando.

### Executar o Projeto com Docker

Caso queira executar o projeto usando docker, após clonar o projeto, abra o arquivo docker-compose.yaml na raiz do projeto e edite as variáveis de ambiente no serviço de backend para a conexão com o banco de dados. Para a configuração dos endpoints para a requisição do frontend e configuração do CORS da aplicação, renomeie o arquivo `.env.exemple` para `.env` e altere as variáveis abaixo se necessário:

```bash
# Frontend environment variables
VITE_BACKEND_DOMAIN=localhost
VITE_BACKEND_PORT=8080

# Backend environment variables
FRONTEND_DOMAIN=localhost
FRONTEND_PORT=3000
```

Após a configuração das variáveis de ambiente, abra o terminal e execute as instruções abaixo:

```bash
# entrar na pasta raiz do projeto e executar o comando docker
cd test-fullstack-gerenciamento-de-cliente
docker-compose up -d
```

O frontend estará disponível em <http://localhost:3000> e se comunicará com o backend que está rodando em <http://localhost:8080>.

[Voltar ao Início](#top)

<br>

<h2 id="routes">📍 Rotas da Aplicação</h2>

### Rotas do Frontend

Na tabela abaixo encontra-se as rotas de cada página do frontend e suas descrições:
​

| URL               | Descrição
|----------------------|-----------------------------------------------------
| <kbd>/</kbd>     | página para listar todos os usuários cadastrados
| <kbd>/create/users</kbd>     | página para cadastrar um novo usuário
| <kbd>/edit/users/:userId</kbd>     | página para editar um usuário já cadastrado

## Rotas do Backend (API)

Na tabela abaixo encontra-se os endpoints da API e suas descrições:

| Método          | URL     | Descrição
|-----------------|-----|-----------------------------------------------------
| `GET` | <kbd>/api/users</kbd>     | endpoint para listar os usuários cadastrados em páginas
| `GET` | <kbd>/api/users/:userId</kbd>     | endpoint para recuperar um usuário pelo seu Id
| `POST` | <kbd>/api/users</kbd>     | endpoint para cadastrar um usuário
| `PUT` | <kbd>/api/users/:userId</kbd>     | endpoint para alterar algum atributo de um cliente

Para mais detalhes sobre as rotas da API e exemplos detalhados de requisições e respostas, [clique aqui](./backend/API_DOCUMENTATION.md)

[Voltar ao Início](#top)

<br>

<h2 id="author">📝 Autor</h2>

Silmar Fernando do Nascimento

[Linkedin](https://www.linkedin.com/in/silmarnascimento/)

[Voltar ao Início](#top)

<br>
