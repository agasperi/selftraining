#include <emscripten.h>
#include <stdio.h>

// Declare a reusable JS function
EM_JS(void, jsFunction, (int n), {
    console.log("Call from EM_JS: ", + n);
})

int main() {
    printf("WASM Ready\n");

    // Call JS function (eval)
    emscripten_run_script("console.log('Hello from C!')");

    // Call JS function ASYNC (eval)
    emscripten_async_run_script("alert('Hello from C - ASYNC!')", 2000);

    // Call return value from JS function - int
    int jsVal = emscripten_run_script_int("getNumero()");
    printf("Value from getNumero(): %d\n", jsVal);

    // Call return value from JS function - String
    char* jsValStr = emscripten_run_script_string("getString()");
    printf("Value from getString(): %s\n", jsValStr);

    // Execute EM_JS fn
    jsFunction(144);

    return 1;
}
