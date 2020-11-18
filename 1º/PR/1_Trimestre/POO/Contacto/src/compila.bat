@echo off
echo Programa de compilacion
echo Comienza la compilacion...
javac Ejecutable.java -d ../dist
echo Programa compilado
echo Comienza la ejecucion
cd ..
cd dist
java Ejecutable
echo Programa terminado
cd ..
cd src
echo Gracias por usar el software de compilacion
