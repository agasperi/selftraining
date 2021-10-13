#include <iostream>
#include <string>

using namespace std;

int main() {
    int repeticiones = 0;
	string cadena0;
	string cadena1;
	cout << "String principal: ";
    getline(cin, cadena0);
	cout << "String a buscar: ";
	getline(cin, cadena1);
	
	size_t pos_encontrado = cadena0.find(cadena1);
	while(pos_encontrado!=string::npos){
		repeticiones++;
		pos_encontrado = cadena0.find(cadena1,pos_encontrado+1);
	}
	
	cout << "Numero de repeticiones del string buscado: " << repeticiones << endl;
	return 0;
}
