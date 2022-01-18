#include <sys/types.h> 
#include <sys/wait.h> 
#include <unistd.h> 
#include <stdio.h> 
#include <string.h> 
#include <errno.h> 
#include <fcntl.h> 
 
int main(int argc, char const *argv[]) 
{ 
    while(1){ 
        printf("HOLA JUANCARLOS con PID: %d \n",getpid()); 
        sleep(5); 
    } 
    return 0; 
}