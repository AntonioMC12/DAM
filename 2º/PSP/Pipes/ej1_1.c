#include <stdio.h>

#include <stdlib.h>
#include <unistd.h>   //pid_t
#include <errno.h>    //tratamiento de errores
#include <sys/wait.h> //waits
#include <string.h>

int main(int argc, char const *argv[])
{
    pid_t pid, child_1, child_2, grandson_1, grandson_2; //variables para los pid de los hijos y los nietos
    int status; //variable entera para usar en waitpid()
    printf("soy el padre, mi pid es %d\n",getpid());
    child_1 = fork(); //generamos el primer hijo

    char *ruta = getenv("HOME"); //ruta en un pricipio tiene la ruta del usuario que esté trabajando, por ejemplo /home/mcarmen
    char comando[100]; //esta variable cadena, servirá para generar aquí lo difentes comandos en los diferentes procesos

   
      
    if(child_1==-1){
        printf ("Error al realizar la llamada fork \n");
        return -1;
    }else if (child_1 == 0){ //hijo1
        grandson_1=fork();
        if (grandson_1==-1){
             //fallo
        }else if(grandson_1==0){//nieto1 trabajando
             printf("\nNieto 1 con pid: %d,con padre:%d, acabo de crear el directorio NIETO1",getpid(),getppid());
             sprintf(comando,"mkdir %s/NIETO1",ruta);
             system(comando);
             getchar();
             exit(0);
        
        }else{//hijo 1 trabajando
             waitpid(grandson_1,&status,0);//esperamos a Nieto1 
             
             //Hijo1 muestra su mensaje y el contenido de la carpeta home del usuario
             printf("\nHijo 1 con pid: %d,con padre:%d",getpid(),getppid());
             sprintf(comando,"ls %s",ruta);   
              printf("\nContenido de %s, cuando ha acabado Nieto1\n",ruta);
             system(comando);
             getchar();
             exit(0);
        }
    }else{
        //estamos en el padre
        waitpid(child_1,&status,0); //h espera a hijo1
        child_2 = fork(); //generamos el segundo hijo
        if(child_2==-1){
            printf ("Error al realizar la llamada fork \n");
            return -1;
        }else if (child_2 == 0){//estamos en hijo2
           
            grandson_2 = fork(); //generamos el nieto2, hijo de child_2
            
            if(grandson_2==-1){
            	printf ("Error al realizar la llamada fork \n");
            	return -1;
            }else if (grandson_2 == 0){//estamos en nieto2
                 
                  printf("\nNieto 2 con pid: %d,con padre:%d, acabo de crear el directorio NIETO2\n", getpid(), getppid());                
                  sprintf(comando,"mkdir %s/NIETO2",ruta);
                  system(comando);
                  getchar();
                  exit(0);
            }else{//estamos en hijo 2
                waitpid(grandson_2,&status,0);//esperamos a N2
                
                printf("\nHijo 2 con pid: %d,con padre:%d\n", getpid(), getppid());
                printf("\nContenido de %s cuando ha acabado Nieto2\n",ruta);
                sprintf(comando,"ls %s",ruta);   
                system(comando);
                
                exit(0);
            }
        }
     
    }

     
    return 0;
}