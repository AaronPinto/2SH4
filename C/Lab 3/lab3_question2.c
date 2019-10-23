//
// Created by aaron on 2019-10-09.
//
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct {
    int id;
    char firstName[15];
    char lastName[15];
    int proj1Grade;
    int proj2Grade;
    float finalGrade;
} student;

student **create_class_list(char *filename, int *sizePtr) {
    FILE *input = fopen(filename, "r");

    fscanf(input, "%d", sizePtr);

    student **list = calloc(*sizePtr, sizeof(student));

    for (int i = 0; i < *sizePtr; i++) {
        student *s = calloc(1, sizeof(student));
        fscanf(input, "%d", &s->id);
        fscanf(input, "%s", s->firstName);
        fscanf(input, "%s", s->lastName);
        list[i] = s;
    }

    fclose(input);

    return list;
}

int find(int idNo, student **list, int size) {
    // Binary search cuz y not xd
    int left = 0, right = size - 1, m, val;

    while (left <= right)  {
        m = (int) (left + right) / 2;
        val = list[m]->id;

        if (val < idNo)
            left = m + 1;
        else if (val > idNo)
            right = m - 1;
        else
            return m;
    }

    return -1;
}

void input_grades(char *filename, student **list, int size) {
    FILE *input = fopen(filename, "r");
    int id, index;

    for (int i = 0; i < size; i++) {
        fscanf(input, "%d", &id);
        index = find(id, list, size);
        fscanf(input, "%d", &list[index]->proj1Grade);
        fscanf(input, "%d", &list[index]->proj2Grade);
    }

    fclose(input);
}

void compute_final_course_grades(student **list, int size) {
    for (int i = 0; i < size; i++)
        list[i]->finalGrade = (list[i]->proj1Grade + list[i]->proj2Grade) / 2.0;
}

void output_final_course_grades(char *filename, student **list, int size) {
    FILE *output = fopen(filename, "w");

    fprintf(output, "%d\n", size);

    for (int i = 0; i < size; i++)
        fprintf(output, "%d %f\n", list[i]->id, list[i]->finalGrade);

    fclose(output);
}

void print_list(student **list, int size) {
    for (int i = 0; i < size; i++)
        printf("ID: %d, Name: %s %s, Project 1 Grade: %d, Project 2 Grade: %d, Final Grade: %f\n", list[i]->id,
                list[i]->firstName, list[i]->lastName, list[i]->proj1Grade, list[i]->proj2Grade, list[i]->finalGrade);
}

void withdraw(int idNo, student **list, int *sizePtr) {
    int index;

    if ((index = find(idNo, list, *sizePtr)) != -1) {
        (*sizePtr)--;
        free(list[index]);

        for (int i = index; i < *sizePtr; i++)
            list[i] = list[i + 1];
    } else
        puts("The student is not in the list!");
}

void destroy_list(student **list, int *sizePtr) {
    for (int i = 0; i < *sizePtr; i++)
        free(list[i]);

    free(list);
    *sizePtr = 0;
}

void question2() {
    int size;
    student **list = create_class_list("classlist.txt", &size);
    puts("Initial List");
    print_list(list, size);

    puts("");
    printf("Find index of ID No 4580: %d\n", find(4580, list, size));

    puts("\nInput grades");
    input_grades("classgrades.txt", list, size);
    print_list(list, size);

    puts("\nCompute final course grades");
    compute_final_course_grades(list, size);
    print_list(list, size);

    puts("\nOutput final course grades to classfinalgrades.txt");
    output_final_course_grades("classfinalgrades.txt", list, size);

    puts("\nWithdraw ID No 1200");
    withdraw(1200, list, &size);
    print_list(list, size);

    puts("\nWithdraw ID No 1234");
    withdraw(1234, list, &size);
    print_list(list, size);

    puts("\nWithdraw ID No 9000");
    withdraw(9000, list, &size);
    print_list(list, size);

    puts("\nDestroy List");
    destroy_list(list, &size);
    printf("Size of destroyed list: %d", size);
}

//int main() {
//    question2();
//    return 0;
//}
