#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

//la diferencia entre system y excec están en que el system genera un proceso propio y mantiene el proceso que lo ha generado.
//el excec reemplaza al proceso padre.

int main(int argc, char const *argv[])
{
    printf("Ejemplo de Exec()\n");
    printf("\n\n");
    execl("/bin/ls","ls","-l",(char *)NULL);
    //system(execl("/bin/ls","ls","-l",(char *)NULL));
    printf("Hello There");
    return 0;
}
