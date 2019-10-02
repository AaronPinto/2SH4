#include <stdio.h>

int main() {
    int i, sum = 0, x = 0;

    for (i = 0; i < 10; i++) {
        puts("Please input an integer: ");
        scanf("%d", &x);
        if (x % 2 == 1)
            sum += x;
    }

    printf("The sum is %d", sum);

	return 0;
}
