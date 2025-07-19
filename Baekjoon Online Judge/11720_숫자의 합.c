#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int N;
	scanf("%d", &N);

	int result = 0;
	char *input = malloc(sizeof(char) * (N + 1));
	scanf("%s", input);

	for (int roop = 0; roop < N; roop++) {
		result += input[roop] - '0';
	}

	printf("%d", result);

	free(input);

	return 0;
}