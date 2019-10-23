//
// Created by aaron on 2019-10-09.
//
#include <stdio.h>
#include <stdlib.h>

char **read_words(const char *input_filename, int *nPtr) {
    FILE *input = fopen(input_filename, "r");

    fscanf(input, "%d", nPtr);

    char **words = calloc(*nPtr, sizeof(char *));

    for (int i = 0; i < *nPtr; i++)
        fscanf(input, "%ms", &words[i]);

    fclose(input);

    return words;
}

int strCmp(const char *s1, const char *s2) {
    while (*s1 && *s1 == *s2)
        s1++, s2++;
    return *(const unsigned char *) s1 > *(const unsigned char *) s2;
}

void sort_words(char **list, int size) {
    // Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
    // At each iteration, insertion sort removes one element from the input data, finds the location it belongs
    // within the sorted list, and inserts it there. It repeats until no input elements remain.
    int i, j;
    char *temp;
    for (i = 1; i < size; i++) {
        temp = list[i];
        for (j = i; j > 0 && strCmp(list[j - 1], temp); j--)
            list[j] = list[j - 1];
        list[j] = temp;
    }
}

void merge(char *arr[], int l, int m, int r) {
    int i, j, k, n1 = m - l + 1, n2 = r - m;

    char *left[n1], *right[n2];

    for (i = 0; i < n1; i++)
        left[i] = arr[l + i];
    for (j = 0; j < n2; j++)
        right[j] = arr[m + 1 + j];

    i = 0; // Initial index of first subarray
    j = 0; // Initial index of second subarray
    k = l; // Initial index of merged subarray
    while (i < n1 && j < n2) {
        if (strCmp(left[i], right[j])) {
            arr[k] = right[j];
            j++;
        } else {
            arr[k] = left[i];
            i++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = left[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = right[j];
        j++;
        k++;
    }
}

void sort2_words(char **arr, int l_index, int r_index) {
    // Conceptually, a merge sort works as follows, divide the unsorted list into n sublists, each containing
    // one element (a list of one element is considered sorted), then repeatedly merge sublists to produce new
    // sorted sublists until there is only one sublist remaining. This will be the sorted list.
    if (l_index < r_index) {
        int m = l_index + (r_index - l_index) / 2;

        sort2_words(arr, l_index, m);
        sort2_words(arr, m + 1, r_index);

        merge(arr, l_index, m, r_index);
    }
}

void output_words(char **list, int size) {
    for (int i = 0; i < size; i++)
        printf("%s\n", list[i]);
}

void question3() {
    puts("Read words");
    int numWords;
    char **words = read_words("words.txt", &numWords);

    puts("\nOutput words");
    output_words(words, numWords);

    puts("\nInsertion sort words");
    sort_words(words, numWords);
    output_words(words, numWords);

    puts("\nRead words");
    int numWords2;
    char **words2 = read_words("words.txt", &numWords2);

    puts("\nOutput words");
    output_words(words2, numWords2);

    puts("\nMerge sort words");
    sort2_words(words2, 0, numWords2 - 1);
    output_words(words2, numWords2);
}

//int main() {
//    question3();
//    return 0;
//}
