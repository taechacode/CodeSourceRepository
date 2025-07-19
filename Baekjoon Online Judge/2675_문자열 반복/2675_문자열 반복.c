#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int T;
	scanf("%d", &T);

	for (int outerLoop = 0; outerLoop < T; outerLoop++) {
		int R;
		scanf("%d", &R);

		char* S = malloc(sizeof(char) * (20 + 1));
		scanf("%s", S);
		
		for (int SLoop = 0; S[SLoop] != '\0'; SLoop++) {
			for (int RLoop = 0; RLoop < R; RLoop++) {
				printf("%c", S[SLoop]);
			}
		}
		printf("\n");

		free(S);
	}

	return 0;
}