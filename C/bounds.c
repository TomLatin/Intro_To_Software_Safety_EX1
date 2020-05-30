#include <stdio.h>
//This class demonstrating the issues of bounds bugs
int main()
{
    int arr[5]={0}; //make new arr
    arr[-1]=8; // add in invalid place
    return 0;
}