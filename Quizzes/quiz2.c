//#include <stdio.h>
//
//int main() {
//    int i, sequence[20];
//
//    for (i = 0; i < 20; i++) {
//        printf("Please input an integer: ");
//        scanf("%d", &sequence[i]);
//    }
//
//    int previous = sequence[0];
//
//    for (i = 1; i < 20; i++) {
//        if (sequence[i] < previous) {
//            puts("The sequence is not increasing");
//            return 0;
//        }
//        previous = sequence[i];
//    }
//    puts("The sequence is increasing");
//
//    return 0;
//}
