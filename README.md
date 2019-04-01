# participacaoNosLucrosStone

Projeto está no heroku para teste no link abaixo:

https://stone-participacoes-nos-lucros.herokuapp.com/stone/participacao-lucros/swagger-ui.html

- Utiliza o mongo db devido eu ter um banco na nuvem free na mlab.
- tem testes de Integração e Unitatios são poucos mas só pra demonstrar (Não utilizei mockito para gerar os mocks)
   Os testes se encontrar no package de test tem uma Suite de Testes na classe AllTests chamando os testes de integração (FuncionarioControllerTest) e os testes unitarios (FuncionarioServiceTest) no caso dos testes de integração os requests estão localizado na pasta resources/json/request nesse exemplo não validei a respostas com arquivos jsons devido ao tempo.
- é possivel acessar o Swagger da aplicação pela url :http://localhost:8080/stone/participacao-lucros/swagger-ui.html
- para rodar o projeto na IDE basta usar o Eclipse STS ou IntelliJ eles já são faceis de executar o projeto e como já existe um tomcat embutido não requer servidor de aplicação ou container.
- Não é necessario configurar o banco pois já está sendo utilizado o banco na nuvvem da mlab caso queira conectar no banco para testes só verificar no application.properties as credenciais.


Recomendações:

seria interessante mudar a forma que a entrada principalmente a moeda pois ela está entrando como String o que não é legal a responsabilidade da formatação da moeda e do FrontEnd talvez seja interesante usar o Padrão Money para moeda ou um tipo BigInteger.

