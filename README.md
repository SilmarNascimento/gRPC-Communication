[JAVA__BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[gRPC__BADGE]: https://img.shields.io/badge/gRPC-%2300B3E6.svg?style=for-the-badge&logo=grpc&logoColor=white

<h1 align="center" style="font-weight: bold;" id="top">Comunicação gRPC 💻</h1>

<h1 align="center">

  <span>![java][JAVA__BADGE]</span>
  <span>![gRPC][gRPC__BADGE]</span>
</h1>

<p align="center">
  <a href="#about">Sobre o Projeto</a> •
  <a href="#project-architecture">Arquitetura do Projeto</a> •
  <a href="#tech">Tecnologias Utilizadas</a> •
  <a href="#started">Como Executar</a> •
  <a href="#author">Autor</a>
</p>

<h2 id="about">📌 Sobre o Projeto</h2>

Este projeto foi desenvolvido com o objetivo de explorar e aplicar os conceitos de comunicação gRPC entre serviços. Ele consiste em dois módulos principais: um atuando como Servidor e outro como Cliente, demonstrando como serviços podem interagir de forma eficiente usando o protocolo gRPC.

Além de implementar e compreender os fundamentos do gRPC, o projeto busca demonstrar as vantagens dessa tecnologia em relação a outros padrões de comunicação, como REST, através do uso de Protocol Buffers (Protobuf) permite a serialização binária das mensagens, reduzindo o tamanho das requisições e respostas.

[Voltar ao Início](#top)

<br>

<h2 id="project-architecture">🏛️ Arquitetura do Projeto</h2>

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

- [JDK 8](https://www.oracle.com/java/technologies/downloads/?er=221886)
- [Maven](https://maven.apache.org/)

### Cloning

Para clonar o projeto, abra o terminal e execute o seguinte comando:

```bash
git clone git@github.com:SilmarNascimento/gRPC-Communication.git
```

### Executar o Projeto Localmente

Como são dois projetos separados simulando os serviços de cliente e servidor, navegue até a pasta de cada projeto e instale as dependências dos serviços executando os seguintes comandos:

```bash
# entrar na pasta do serviço Client
cd gRPC-communication/gRPCClient

# instalar as dependências do projeto
mvn clean install

# entrar na pasta do serviço Server
cd ../gRPCServer

# instalar as dependências do projeto
mvn clean install
```

Após a instalação das dependências do servidor, você pode subir a aplicação por sua IDE ou executando o seguinte comando:

```bash
# empacotar o projeto num .jar
mvn package

# subir o serviço Server rodando o .jar
java -jar target/Server-1.0-SNAPSHOT.jar
```

Esse comando irá iniciar o servidor da aplicação que estará rodando por padrão na porta `8999`.

Agora que o Server está rodando, podemos subir o Client da aplicação por sua IDE escolhida ou seguindo os passos abaixo:

```bash
# Entrar na pasta do frontend
cd ../gRPCClient

# empacotar o projeto num .jar
mvn package

# subir o serviço Client rodando o .jar
java -jar target/Client-1.0-SNAPSHOT.jar
```

Ao rodar o CLient, a conexão irá fechar após receber a seguinte mensagem:

```bash
Hello gRPC

Process finished with exit code 0
```

[Voltar ao Início](#top)

<br>

<h2 id="author">📝 Autor</h2>

Silmar Fernando do Nascimento

[Linkedin](https://www.linkedin.com/in/silmarnascimento/)

[Voltar ao Início](#top)

<br>
