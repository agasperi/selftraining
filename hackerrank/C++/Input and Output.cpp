#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int num1, num2, num3;
    
    cin >> num1;
    cin >> num2;
    cin >> num3;
    
    cout << num1 + num2 + num3 << endl;
    return 0;
}


// Other options

int main() {

    int sum = 0;
    int x, y, z;

    cin >> x >> y >> z;
    sum = x + y + z;
    cout << sum << endl;

    return 0;
}