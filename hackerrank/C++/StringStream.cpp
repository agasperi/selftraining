#include <sstream>
#include <vector>
#include <iostream>
using namespace std;

vector<int> parseInts(string str) {
    int numero;
    vector<int> numeros;
	stringstream ss(str);

    while (ss >> numero){
        numeros.push_back(numero);
        if(ss.peek() == ',') ss.ignore(); 
    }

    return numeros;
}

int main() {
    string str;
    cin >> str;
    vector<int> integers = parseInts(str);

    for(int i = 0; i < integers.size(); i++) {
        cout << integers[i] << "\n";
    }
    
    return 0;
}
