#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <sys/wait.h>
#include <sys/mman.h>

int main()
{
    int child;
    int *number = (int*)mmap(NULL, sizeof(int), PROT_READ | PROT_WRITE,
               MAP_SHARED | MAP_ANONYMOUS, -1, 0);
    int i;

    *number = 10;

    child = fork();

    if (child == -1)
    {
        exit(1);
    }
    else if (child == 0)
    {
        for (i = 0; i < 10; ++i)
        {
            usleep(100);
            printf("CHILD -- Number: %d\n", *number);
            *number = i;
        }
        exit(0);
    }
    else
    {
        for (i = 20; i < 30; ++i)
        {
            usleep(100);
            printf("MAIN -- Number: %d\n", *number);
            *number = i;
        }
    }
    wait(NULL);
    munmap(number, sizeof(int));

}