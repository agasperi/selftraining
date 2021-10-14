#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    long num1;
    long num2;
    
    cin >> num1;
    cin >> num2;
    
    for(long i = num1; i <= num2; i++)
    {
        switch (i){
        case 1: cout << "one" << endl; break;
        case 2: cout << "two" << endl; break;
        case 3: cout << "three" << endl; break;
        case 4: cout << "four" << endl; break;
        case 5: cout << "five" << endl; break;
        case 6: cout << "six" << endl; break;
        case 7: cout << "seven" << endl; break;
        case 8: cout << "eight" << endl; break;
        case 9: cout << "nine" << endl; break;
        default:
            if (i % 2)
              cout << "odd" << endl;
            else cout << "even" << endl;
            break;
        }
    }
        
    return 0;
}


// Other options

int main() {

    int a, b;
    string represent[10] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    cin >> a >> b;
    for(int i = a; i <= b; i++) {
        
        if(i > 9) {
            if(i % 2 == 0)
                cout << "even\n";
            else cout << "odd\n";
        }
        else {
            cout << represent[i]<<endl;
        }
    }
    return 0;
}