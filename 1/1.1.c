#include<stdio.h>
#include<string.h>

/* use an int array to record whether a ASCII character is unique */
int IsUnique1(char *string)
{
	int len, i, temp;
	int count[256] = {0};
	len = strlen(string);

	for (i=0; i<len; i++) {
		temp = (int)string[i];
		if (count[temp] == 0) {
			count[temp]++;
		}
		else {
			return 0;
		}
	}
	return 1;
}

/* using the bit in an 8 int(32 bits) array(256 bits total) to record whether a ASCII character is unique */
int IsUnique2(char *string)
{
	int len, i, temp, index, shift;
	int count[8] = {0};
	len = strlen(string);

	for (i=0; i<len; i++) {
		temp = (int)string[i];
		index = temp/32;
		shift = 1 << temp%32;
		if (count[index]&shift) {
			return 0;
		}
		else {
			count[index] |= shift;
		}
	}
	return 1;
}

int IsUnique3(char *string)
{
	int len, i, temp, shift;
	int check = 0;
	len = strlen(string);

	for (i=0; i<len; i++) {
		temp = (int)(string[i]-'a');
		shift = 1<<temp;
		
		if (check&shift) {
			return 0;
		}
		else {
			check |= shift;
		}
	}
	return 1;
}

int main(int argc, char *argv[])
{
	char *s1 = "This is a test!";
	char *s2 = "I loveu!";
	char *s3 = "abcdefgg";
	char *s4 = "abcdefgh";
	printf("%s %d\n", s1, IsUnique1(s1));
	printf("%s %d\n", s1, IsUnique2(s1));
	printf("%s %d\n", s2, IsUnique1(s2));
	printf("%s %d\n", s2, IsUnique2(s2));
	printf("%s %d\n", s3, IsUnique3(s3));
	printf("%s %d\n", s4, IsUnique3(s4));
	return 0;
}
