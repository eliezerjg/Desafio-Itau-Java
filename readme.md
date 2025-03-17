# Desafio Tecnico Itaú

#### Nivel: Júnior
#### Sobre: Desafio tecnico Programador Java
#### Tecnologias: Java /  Spring Boot

<br/>
<br/>

<hr />

### Dependencias
<br/>

##### MacOS - Brew
1 - rode no terminal: brew install openjdk@21 && brew install maven

<hr />
<br />

##### Windows - Chocolatey
2 - rode no terminal:
choco install openjdk --version=21.0.0 && choco install maven


<hr/> 
<br/><br/>

#### Rodar o projeto:
Opcao 1 - Sem docker:
<pre>
1 - Tenha o maven e o java instalaado
2 - Compile o projeto no "/"  (rodando o comando mvn package)
3 - Rode o projeto na pasta "/target" com o comando "java -jar service.jar"
</pre>

Opcao 2 - Com docker:
<pre>
1 - Compile o projeto no "/"  (rodando o comando mvn package)
2 - rode docker compose up -d no "/" do projeto 
3 - acesse http://ip-do-container:8080/swagger-ui/index.html#/
</pre>


<hr/>

#### Documentacao:
Opcao 1 - Sem docker:
<pre>
1 - Tenha o maven e o java instalaado
2 - Compile o projeto no "/"  (rodando o comando mvn package)
3 - Rode o projeto na pasta "/target" com o comando "java -jar service.jar" 
4 - Acesse http://localhost:8080/swagger-ui/index.html#/
5 - Se preferir pode baixar o OPEN API JSON em http://localhost:8080/v3/api-docs
6 - Pode ser utilizado o Swagger editor para ler o JSON
</pre>

Opcao 2 - Com docker:
<pre>
1 - rode docker compose up -d no "/" do projeto 
2 - acesse http://ip-do-container:8080/swagger-ui/index.html#/
</pre>


<hr/><br/>

EXTRAS:
<pre>
1 -  ✅ Testes automatizados: Sejam unitários e/ou funcionais, testes automatizados são importantes e ajudam a evitar problemas no futuro. Se você fizer testes automatizados, atente-se na efetividade dos seus testes! Por exemplo, testar apenas os "caminhos felizes" não é muito efetivo.
2 -  ✅ Containerização: Você consegue criar meios para disponibilizar sua aplicação como um container? OBS: Não é necessário publicar o container da sua aplicação!
3 -  ✅ Logs: Sua aplicação informa o que está acontecendo enquanto ela trabalha? Isso é útil para ajudar as pessoas desenvolvedoras a solucionar eventuais problemas que possam ocorrer.
4 -  ✅ Observabilidade: Sua API tem algum endpoint para verificação da saúde da aplicação (healthcheck)?
5 -  ✅ Performance: Você consegue estimar quanto tempo sua aplicação gasta para calcular as estatísticas?
6 -  ✅ Tratamento de Erros: O Spring Boot dá às pessoas desenvolvedoras ferramentas para se melhorar o tratamento de erros padrão. Você consegue alterar os erros padrão para retornar quais erros ocorreram?
7 -  ✅ Documentação da API: Você consegue documentar sua API? Existem ferramentas e padrões que podem te ajudar com isso!
8 -  ✅ Documentação do Sistema: Sua aplicação provavelmente precisa ser construída antes de ser executada. Você consegue documentar como outra pessoa que pegou sua aplicação pela primeira vez pode construir e executar sua aplicação?
9 -  ✅ Configurações: Você consegue deixar sua aplicação configurável em relação a quantidade de segundos para calcular as estatísticas? Por exemplo: o padrão é 60 segundos, mas e se o usuário quiser 120 segundos?
</pre>

<br/>
<hr/>

RODAR OS TESTES:
<pre>
    1 - instalar o maven e o java
    2 - executar o comando no "/" no terminal: mvn test
</pre>


SAUDE DA APLICACAO:
<pre>
    1 - rodar o projeto
    2 - acessar http://localhost:8080/actuator/health
</pre>

OBSERVABILIDADE DA APLICACAO:
<pre>
    1 - rodar o projeto
    2 - acessar http://localhost:8080/actuator/prometheus
</pre>