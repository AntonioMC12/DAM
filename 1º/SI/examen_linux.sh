#!bin/zsh

#1- Haz un listado recursivo del directorio examenlinux y todos los archivos y directorios que contiene.
/tmp/examenlinux 
➜ ls -R 

#2- Copia todos los ficheros que contengan los caracteres "83"  del directorio admin al directorio backup.
cp admin/*83* backup/

#3- Copia todos los ficheros que acaben en "t"  del directorio examenlinux al directorio gest.
cp *t /gest

#4- Borra los ficheros que empiezan por "1" del directorio som.
rm 1*

#5- Copia todos los ficheros que contienen los caracteres "file" seguido de un caracteres y con extensión "doc" del directorio admin al directorio gest.
cp admin/*file?.doc gest/

#6 -Borra todos los ficheros del directorio bbdd.
rm -f *.*

#7- Borra con un solo comando el directorio gest y todo lo que contiene.
rm -rf gest/

#8- Mueve el directorio backup al directorio admin.
mv backup/ admin/

#9- Muestra únicamente el total del espacio ocupado por el directorio examenlinux en bytes.
du . -sbc

#10- Crea un enlace simbólico en tu directorio personal que permita acceder directamente al directorio examenlinux, el enlace se llamará "examen"
ln -s /tmp/examenlinux ~/examen

#11- Busca todos los ficheros del disco duro con extensión cvs evitando que se muestren errores por pantalla.
find -name "tmp" 2>/dev/null
