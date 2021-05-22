<h4 align="center"> 
	🚧  Safe City 🚀 Em construção...🚧
</h4>


# Safe City

Precisamos de um descritivo

## Organizar informações relevantes ao app

upload oracle drive maven

download

https://download.oracle.com/otn-pub/otn_software/jdbc/1910/ojdbc10.jar

no cmd navegue até onde está o drive e execute o comando abaixo

$ mvn install:install-file -Dfile=ojdbc10.jar -DgroupId=com.oracle -DartifactId=ojdbc10 -Dversion=19.10 -Dpackaging=jar

no pom.xml add



<dependency>
	<groupId>com.oracle</groupId>
	<artifactId>ojdbc10</artifactId>
	<version>19.10</version>
</dependency>



## Endpoints(em contrução e alteração):

Cadastrar categoria
http://localhost:8082/safecity/cadastrar

Listar todas categorias
http://localhost:8082/safecity/todas