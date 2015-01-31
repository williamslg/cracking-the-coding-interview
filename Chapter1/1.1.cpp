#include<iostream>
#include<cstring>

using namespace std;

/* use a bool array to record whether a ASCII character is unique */
bool IsUnique1(string s)
{
	int len, i, temp;
	bool check[256] = {false};
	len = s.length();

	for (i=0; i<len; i++) {
		temp = (int)s[i];
		
		if (check[temp]) {
			return false;
		}
		else {
			check[temp] = true;
		}
	}
	return true;
}


/* using the bit in an 8 int(32 bits) array(256 bits total) to record whether a ASCII character is unique */
bool IsUnique2(string s)
{
	int len, i, temp, index, shift;
	int check[8] = {0};
	len = s.length();
	
	for (i=0; i<len; i++) {
		temp = (int)s[i];
		index = temp/32;
		shift = 1<<temp%32;

		if (check[index]&shift) {
			return false;
		}
		else {
			check[index] |= shift;
		}
	}
	return true;
}

/* if s only contains the alphabet 'a'-'z' or 'A'-'Z', just use an int variable */
bool IsUnique3(string s)
{
	int len, i, temp, shift;
	int check = 0;
	len = s.length();

	for (i=0; i<len; i++) {
		temp = (int)(s[i]-'a');
		shift = 1<<temp;

		if (check&shift) {
			return false;
		}
		else {
			check |= shift;
		}
	}
	return true;
}

int main(int argc, char *argv[])
{
	string s1 = "This is a test!";
	string s2 = "I loveu!";
	string s3 = "abcdefgg";
	string s4 = "abcdefgh";

	cout << s1 << IsUnique1(s1) << endl;
	cout << s2 << IsUnique1(s2) << endl;
	cout << s1 << IsUnique2(s1) << endl;
	cout << s2 << IsUnique2(s2) << endl;
	cout << s3 << IsUnique3(s3) << endl;
	cout << s4 << IsUnique3(s4) << endl;

}
