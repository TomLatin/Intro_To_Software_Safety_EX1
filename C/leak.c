#include<malloc.h>

//This class demonstrating the issues of leak of memory
//I allocate 2 pointers but I only released one pointer thing that made a memory leak
//If I run the program normally I will not see an induction that was a memory leak but with I run the software
// with -fsanitize = leak it would give an induction that was a memory leak
int main()
{
    char * ptr1 = (char *) malloc (20); // allocating 20 bytes
    char * ptr2 = (char *) calloc (20, sizeof(char)); // allocating 20 bytes
    free(ptr2); // make free to ptr2
    return 0;
}

