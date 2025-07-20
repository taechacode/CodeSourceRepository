#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int N, M;
	scanf("%d", &N);
	scanf("%d", &M);

	int* basket = calloc(N, sizeof(int));

	for (int outerLoop = 0; outerLoop < M; outerLoop++) {
		int i, j, k;
		scanf("%d", &i);
		scanf("%d", &j);
		scanf("%d", &k);

		for (int innerLoop = i; innerLoop < j + 1; innerLoop++) {
			basket[innerLoop - 1] = k;
		}
	}

	for (int loop = 0; loop < N; loop++) {
		printf("%d ", basket[loop]);
	}

	printf("\n");

	free(basket);

	return 0;
}