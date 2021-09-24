//programa que llama a proceso con excec que cree un directorio en la ruta home (con variables de entorno)

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char const *argv[])
{
    char *file = "/prueba";
    char *env = getenv("HOME");
    /**
     * concateno para obtener el path completo ~/prueba
     */
    char *path = strcat(env, file);
    char *args[] = {
        "/bin/mkdir",
        "mkdir",
    };

    /**
     * primer argumento la ruta del comando /bin/mkdir
     * segundo argumento el comando mkdir
     * primer argumento "~/prueba"
     * puntero a null
     */
    execl(args[0], args[1], env, (char *)NULL);
    return 0;
}
