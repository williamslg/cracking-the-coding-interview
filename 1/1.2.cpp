#include<iostream>
#include<cstring>

using namespace std;

void swap(char &a, char &b)
{
	char temp = a;
	a = b;
	b = temp;
}

/*	XOR version swap()
	The complier efficiency is not as good as the normal swap();
	If a == b, there is no problem. But if a == a, i.e., we are passing the same reference.
	The result will always 0;
*/
void swap1(char &a, char &b)
{
	a = a^b;
	b = a^b;
	a = a^b;
}
void Reverse1(char *string)
{
	if (string == NULL) {
		return;
	}

	int n = strlen(string);

	for (int i=0; i<n/2; i++) {
		swap1(string[i], string[n-i-1]);
	}
}

int main()
{
	char string[] = "0123456789";
	char string1[] = "012345678";
	Reverse1(string);
	Reverse1(string1);

	cout<< string <<endl;
	cout<< string1 <<endl;
}
