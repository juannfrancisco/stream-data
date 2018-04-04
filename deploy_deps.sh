# Este Archivo contiene los comandos necesarios para deployar librerias en un repositorio remoto.
# URL Repositorio Remoto : http://localhost:8081/repository/internal/.
# ID Repositorio Remoto : archiva.internal.
# @author Juan Francisco.
mvn deploy:deploy-file -DgroupId=com.google.code.gson -DartifactId=gson -Dpackaging=jar -Dversion=2.2.4 -Dfile=/Users/jmaldonado/Desarrollo/workspaces/concentrador-bfal_/stream-data/target/stream-data/WEB-INF/lib/gson-2.2.4.jar -DgeneratePom=true  -DrepositoryId=archiva.internal -Durl=http://localhost:8081/repository/internal/
mvn deploy:deploy-file -DgroupId=commons-logging -DartifactId=commons-logging -Dpackaging=jar -Dversion=1.1.1 -Dfile=/Users/jmaldonado/Desarrollo/workspaces/concentrador-bfal_/stream-data/target/stream-data/WEB-INF/lib/commons-logging-1.1.1.jar -DgeneratePom=true  -DrepositoryId=archiva.internal -Durl=http://localhost:8081/repository/internal/
