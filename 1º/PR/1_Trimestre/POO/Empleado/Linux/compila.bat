@echo off
echo Iniciado programa de compilacion
echo ...
echo #########################
echo Comienza la compilacion...
cd src
javac Ejecutable.java -d ../dist
echo Programa compilado
echo #########################
echo ...
echo ...
echo #########################
echo Construyendo documentacion
javadoc -d ../docs Ejecutable.java com.Utils com.Trabajo
echo #########################
echo ...
echo ...
echo #########################
echo Ejecutando el programa...
cd ..
cd dist
java Ejecutable
echo #########################
echo ...
echo ...
echo #########################
echo Programa terminado
cd ..
cd src
echo Gracias por usar el software de compilacion