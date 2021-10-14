#include <iostream>
#include <cstdio>
#include <iomanip> 

using namespace std;

int main() {
    int num1;
    long num2;
    long long num3;
    char num4;
    float num5;
    double num6;
    
    cin >> num1;
    cout << num1 << endl;
    
    cin >> num2;
    cout << num2 << endl;
    
    cin >> num3;
    cout << num3 << endl;
    
    cin >> num4;
    cout << num4 << endl;
    
    cin >> num5;
    cout << fixed << setprecision(3) << num5 << endl;
    
    cin >> num6;
    cout << fixed << setprecision(9) << num6 << endl;
    
    return 0;
}

// Other options

int main() {
    
    int a;
    long b;
    char c;
    float d;
    double e;
    cin >> a >> b >> c >> d >> e;
    cout<< a << '\n' << b << '\n' << c << '\n';
    cout << std::fixed << std::setprecision(3) << d << '\n';
    cout << std::fixed << std::setprecision(9) << e << '\n';
    
    return 0;
}