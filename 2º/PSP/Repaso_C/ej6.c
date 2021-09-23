#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
    printf("Mi nombre es: %s\n", argv[0]);
    printf("Mi PID es: %d \n\n\n", getppid());
    char *args[] = {
        "ej5",
        (char *)argv[1],
        NULL};
    execv("./ej5", args);
}