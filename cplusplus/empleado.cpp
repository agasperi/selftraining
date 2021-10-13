#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool horasRestantes(vector<int> &horas, int horasRestante, int pos){
	cout << "horasRestante " << horasRestante  << " pos " << pos << endl;
	if(horas[pos] == horasRestante){
		cout << "Aqui a" << endl;
		horasRestante -= horas[pos];
		return true;
	}
	else {
		if (horas.size() <= pos + 1){
			cout << "Aqui b" << endl;
			return false;
		}
		
		if (horasRestante < horas[pos+1]){
			cout << "Aqui c" << endl;
			return false;
		}
			
		else{
			cout << "Aqui d" << endl;
			if (horasRestantes(horas, horasRestante,pos+1))
				return true;
			else {
				horasRestante -= horas[pos];
				return horasRestantes(horas, horasRestante,pos+1);
			}
		}
	}
}

int main() {
    int k = 0;
	cout << "Cuantos empleados dispone Mahisoft: ";
    cin >> k;
	
	vector<int> horas_empleados;
	int horas;
	int totalHoras = 0;
	for (int i = 0; i < k; i++){
		cout << "Horas disponibles para el empleado " << i+1 << ": ";
		cin >> horas;
		totalHoras += horas;
		horas_empleados.push_back(horas);
	}
	
	cout << "Horas disponibles de los empleados" << endl;
	cout << '[';
	for (vector<int>::iterator it = horas_empleados.begin(); it != horas_empleados.end(); it++)
		cout << *it << ',';
	cout << ']' << endl;
	
	cout << "Total de horas disponibles: " << totalHoras << endl;
	
	int t = 0;
	cout << "Por cuantas horas desea la contratacion: ";
	cin >> t;
	
	string respuesta = "no";
	
	if(totalHoras >= t){
		if (horasRestantes(horas_empleados,t,0))
			respuesta = "si";
	}
	
	cout << "La respuesta de disponibilidad es: " << respuesta << endl;
	
	return 0;
}
