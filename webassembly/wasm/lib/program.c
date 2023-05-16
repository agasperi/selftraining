#include <string.h>

void numLog(int x);
void strLog(char* offset, length);

int main() { 
  return 42;
}

void greet() {
  char* str = "Hello from C!";
  strLog(str, strlen(str));
}

void getDoubleNum(int x) {
  numLog(2 * x);
}
