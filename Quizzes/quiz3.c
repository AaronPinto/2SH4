//#include <stdio.h>
//
//#define N 3
//
//void transpose(double mat[][N]) {
//    for (int i = 0; i < N; i++) {
//        for (int j = 0; j < i; j++) {
//            double temp = mat[i][j];
//            mat[i][j] = mat[j][i];
//            mat[j][i] = temp;
//        }
//    }
//}
//
//int main() {
//    double test[N][N] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//
//    puts("Original matrix");
//    for (int i = 0; i < N; i++) {
//        for (int j = 0; j < N; j++) {
//            printf("%f ", test[i][j]);
//        }
//        printf("\n");
//    }
//    puts("");
//
//    transpose(test);
//
//    puts("Transposed matrix");
//    for (int i = 0; i < N; i++) {
//        for (int j = 0; j < N; j++) {
//            printf("%f ", test[i][j]);
//        }
//        printf("\n");
//    }
//
//    return 0;
//}
