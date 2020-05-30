#include<malloc.h>
//This class demonstrating the issues of use-after-free bugs
int main()
{
    char * ptr1 = (char *) malloc (20); // allocating 20 bytes
    char * ptr2 = (char *) calloc (20, sizeof(char)); // allocating 20 bytes
    free(ptr1); // make free to ptr1
    free(ptr2); // make free to ptr2
    char c='t';// make a new char to add to ptr2
    ptr2[0]=c;//but ptr2 is already free
    return 0;
}
