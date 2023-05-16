#include <stdio.h>
#include <string.h>

int main() {
    printf("WASM Ready - Testing with Emscripten HTML\n");
    return 1;
}

int getNum() {
    return 22;
}

int getDoubleNum(int x) {
  return 2 * x;
}

char greeting[50];
char* greet(char* name) {
    if(strlen(name) > 40) {
        return "Name too long";
    }
    strcpy(greeting, "Hello ");
    return strcat(greeting,name);
}
