#define _CRT_SECURE_NO_WARNINGS
#define MAX_LEN 101
#include <stdio.h>
#include <stdlib.h>

int main()
{
	char input[MAX_LEN];
	scanf("%s", input);

	for (char outerLoop = 'a'; outerLoop < 'z' + 1; outerLoop++) {
		for (int innerLoop = 0; innerLoop < MAX_LEN; innerLoop++) {
			if (outerLoop == input[innerLoop]) {
				printf("%d ", innerLoop);
				break;
			}

			if (input[innerLoop] == '\0') {
				printf("%d ", -1);
				break;
			}
		}
	}	

	return 0;
}