#include <stdio.h>
#include <string.h>

void Remove(char *s);

void Remove(char *s)
{
	if (s == NULL) {
		return;
	}

	int len, i, j, p;
	p = 0;
	len = strlen(s);
	if (len < 2) {
		return;
	}
	for (i = 0; i < len; i++) {
		if (s[i] != '\0') {
			s[p++] = s[i];
			for (j = i + 1; j < len; j++) {
				if (s[j] == s[i]) {
					s[j] = '\0';
				}
			}
		}
	}
	s[p] = '\0';
}

int main(int argc, char *argv[])
{
	char s1[] = "";
	char s2[] = "aaaaaa";
	char s3[] = "aaabbb";
	char s4[] = "abcabc";
	char s5[] = "abcdef";
	Remove(s3);
	Remove(s4);
	Remove(s5);
	Remove(s1);
	Remove(s2);
	printf("%s\n", s1);
	printf("%s\n", s2);
	printf("%s\n", s3);
	printf("%s\n", s4);
	printf("%s\n", s5);
	return 0;
}
