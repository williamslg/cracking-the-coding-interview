#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/*	1. use strlen() to get the length of the string
	2. malloc the same length of memory to save the reverse string
	3. copy the reverse string to the original string
*/
void Reverse1(char *string)
{
	int length, i;
	char *newstring;
	length = strlen(string);

	newstring = (char *)malloc(sizeof(char)*(length+1));

	for(i=length-1; i>=0; i--) {
		newstring[length-i-1] = string[i];
	}

	for(i=0; i<length; i++) {
		string[i] = newstring[i];
	}
}

/*	A better version, same memory 
	1. get the length of the string either via strlen() or traversing the string
	2. set two pointers or indices, exchange the characters.
*/

void swap(char *a, char* b)
{
	if (a == NULL || b == NULL) {
		return;
	}
	char temp = *a;
	*a = *b;
	*b = temp;
}

void Reverse2(char *string)
{
	if(string == NULL) {
		return;
	}
	
	int length, i, j;
	length = strlen(string);
	i = 0;
	j = length-1;

	while (i<j) {
		swap(&string[i++], &string[j--]);
	}
}

void Reverse3(char *string)
{
	if (string == NULL) {
		return;
	}

	int length, i;
	length = 0;

	while (string[length]) {
		length++;
	}
	//length--; //lenght serves as an index. To get the length, there's no need to decrease it.

	for (i=0; i<length/2; i++) {
		swap(&string[i], &string[length-i]);
	}

}

/* This version uses index */
void Reverse4(char *string)
{
	if (string == NULL) {
		return;
	}
	
	int i, j;
	i = 0;
	j = 0;

	while (string[j]) {
		j++;
	}
	j--;

	while (i<j) {
		swap(&string[i++], &string[j--]);
	}

}

/* While this version uses pointers */
void Reverse5(char *string)
{
	if (string == NULL) {
		return;
	}

	char *p, *q;
	p = string;
	q = string;

	while (*q) {
		q++;
	}
	q--;

	while(p<q) {
		swap(p++, q--);
	}
}
int main()
{
	char string[] = "I love you!9876543210";
	char string1[] = "I love you9876543210";

	Reverse5(string);
	Reverse5(string1);

	printf("%s\n", string);
	printf("%s\n", string1);

	return 0;
}
