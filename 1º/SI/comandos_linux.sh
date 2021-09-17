#!bin/zsh

#Copia todos los ficheros que contengan los caracteres "bl" con extensión blt del directorio ejersii al directorio bdor
cp *bl*.blt admin/bbdd/bdor

#Copia todos los ficheros que contengan los caracteres "bl" seguidos exactamente de dos caracteres y la letra "a" con extensión blt del directorio ejersii al directorio oodb
cp *bl*??a.blt 

#Mueve el directorio bdor y todo lo que contiene al directorio oodb.
mv admin/bbdd/bdor /admin/bbdd/oodb

#Borra exactamente los ficheros indicados en el ejercicio 2 de la carpeta ejersii.
rm -f *bl*??a.blt

#Copia todos los ficheros que contienen los caracteres "file" y con extension txt del directorio admin al directorio gest
cp *file*.txt /admin/prog

#Borra todos los ficheros con extensión txt del directorio admin.
rm -f *file

#Lista todos los ficheros que empieran por "a", contienen los caracteres "file" y cuya extensión termine en "c" del directorio admin en formato largo.
ls -l a*file*.*a

#Borra con un solo comando el directorio som y todo lo que contiene.
rm -rf admin/som 

#Oculta el directorio prog
mv admin/prog admin/.prog

#Crea un enlace simbólico del directorio ejersii al directorio bdor que se llame "atajo"
ln -s /home/user/ejerssii admin/bbdd/oodb/bdor/atajo

#Muestra el espacio total ocupado por el directorio ejersii xen multiplos de byte.
du -sh

#Muestra el espacio ocupado y libre del disco duro en multiplos de byte.
df -h

#Localiza todos los ficheros del disco duro todos los ficheros y directorios que contengan los caracteres "tmp" sin comillas. No mostrar los errores en la salida.
find -name "tmp" 2>/dev/null

#Listar todo menos archivos .doc
ls -d *[!".doc"]
