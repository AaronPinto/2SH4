//
// Created by aaron on 2019-09-25.
//
#include <stdio.h>

static int sort(int d[], int size) {
    int i, j;
    for (i = 1; i < size; i++) {
        int tmp = d[i];
        for (j = i; j >= 1 && tmp < d[j - 1]; j--)
            d[j] = d[j - 1];
        d[j] = tmp;
    }
}

void addEff(int val1[], int val2[], int val3[], int pos1[], int pos2[], int pos3[], int k1, int k2) {
    int v3index = 0, maxNumOfPos = k1 + k2, posAddedFrom1 = 0, posAddedFrom2 = 0;

    for (int i = 0; i < k1; i++) {
        for (int j = 0; j < k2; j++) {
            if (pos1[i] == pos2[j]) {
                if (val1[i] + val2[j] == 0) {
                    maxNumOfPos -= 2;
                } else {
                    maxNumOfPos--;
                }
            }
        }
    }

    for (int k = 0; k < k1; k++) {
        for (int i = 0; i < k2; i++) {
            if (pos1[k] == pos2[i] && val1[k] + val2[i] == 0) {
                goto end1; // I know I really shouldn't use goto statements but I got fed up :P
            }
        }
        posAddedFrom1++;
        pos3[v3index++] = pos1[k];

        end1:;
    }

//    for (int l = 0; l < maxNumOfPos; l++) {
//        printf("%d ", pos3[l]);
//    }
//    puts("");

    for (int k = 0; k < k2; k++) {
        for (int i = 0; i < k1; i++) {
            if (pos2[k] == pos1[i]) { // dont check for sum = 0 because we already did that
                goto end2;
            }
        }
        posAddedFrom2++;
        pos3[v3index++] = pos2[k];

        end2:;
    }

    sort(pos3, maxNumOfPos);

    puts("Pos 3: ");
    for (int l = 0; l < maxNumOfPos; l++) {
        printf("%d ", pos3[l]);
    }
    puts("\n");

    for (int m = 0; m < maxNumOfPos; m++) {
        for (int i = 0; i < k1; i++) {
            if (pos1[i] == pos3[m]) {
                val3[m] += val1[i];
            }
        }

        for (int i = 0; i < k2; i++) {
            if (pos2[i] == pos3[m]) {
                val3[m] += val2[i];
            }
        }
    }

    puts("Val 3: ");
    for (int l = 0; l < maxNumOfPos; l++) {
        printf("%d ", val3[l]);
    }
}

#define sumNonZero 4
void question7() {
    int v1[] = {5, 10, 15}, p1[] = {1, 2, 5}, v2[] = {-10, 7, -10, -3}, p2[] = {2, 5, 6, 8}, v3[sumNonZero] = {0}, p3[sumNonZero] = {0};
    addEff(v1, v2, v3, p1, p2, p3, sizeof(v1) / sizeof(v1[0]), sizeof(v2) / sizeof(v2[0]));
}

//int main() {
//    question7();
//    return 0;
//}
