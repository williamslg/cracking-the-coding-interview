#include "stdio.h"

void reverse(char* str)
{
    if (str == NULL) return;
    int len = 0;
    char* tmp = str;
    while (*tmp) {
        len++;
        tmp++;
    }
    int low = 0;
    int high = len - 1;
    while (low < high) {
        char tmp = str[low];
        str[low] = str[high];
        str[high] = tmp;
        low++;
        high--;
    }
}


int main()
{
   char str[] = "I love you!";
   reverse(str); 
   printf("%s\n", str);
}
