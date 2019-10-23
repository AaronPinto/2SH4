cmake_minimum_required(VERSION 3.14)
project(2SH4 C)
set(CMAKE_C_STANDARD 11)

file(GLOB LAB1 "Lab 1/*.h" "Lab 1/*.c")
file(GLOB LAB2 "Lab 2/*.h" "Lab 2/*.c")
file(GLOB LAB3 "Lab 3/*.h" "Lab 3/*.c")
file(GLOB QUIZZES "Quizzes/*.c")

add_executable(2SH4 ${LAB3} main.c sizeOfArray.c)
