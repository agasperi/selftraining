Day 0: Hello, World.

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    // Declare a variable named 'input_string' to hold our input.
    string input_string; 
    
    // Read a full line of input from stdin (cin) and save it to our variable, input_string.
    getline(cin, input_string); 
    
    // Print a string literal saying "Hello, World." to stdout using cout.
    cout << "Hello, World." << endl;

    // TODO: Write a line of code here that prints the contents of input_string to stdout.
    cout << input_string;

    return 0;
}

Day 1: Data Types

#include <iostream>
#include <iomanip>
#include <limits>

using namespace std;

int main() {
    int i = 4;
    double d = 4.0;
    string s = "HackerRank ";

    // Declare second integer, double, and String variables.
    int j;
    double e;
    string str;
    // Read and save an integer, double, and String to your variables.
    //cin >> j;
    cin >> j;
    cin >> e;
    getline(cin,str);
    getline(cin,str);
    // Print the sum of both integer variables on a new line.
    cout << i + j << endl;
    // Print the sum of the double variables on a new line.
    cout << fixed << setprecision(1) << d + e << endl;
    // Concatenate and print the String variables on a new line
    // The 's' variable above should be printed first.
    cout << s.append(str) << endl;

    return 0;
}

Day 2: Operators

#include <iostream>
#include <cmath>

using namespace std;

int main() {
    double mealCost = 0.0;
    int tipPercent = 0;
    int taxPercent = 0;
    
    cin >> mealCost;
    cin >> tipPercent;
    cin >> taxPercent;
    
    double tip = mealCost * ((double)tipPercent / 100);
    double tax = mealCost * ((double)taxPercent / 100);
    long totalCost = lround(mealCost + tip + tax);
    
    cout << "The total meal cost is " << totalCost << " dollars.";
    return 0;
}

Day 3: Intro to Conditional Statements

#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
using namespace std;


int main(){
    int N;
    cin >> N;
    if(N % 2 != 0){
        cout << "Weird";
    }
    else{
        if(N > 20){
            cout << "Not Weird";
        }
        else{
            if( N >= 6){
                cout << "Weird";
            }
            else{
                if(N >= 2){
                    cout << "Not Weird";
                }
            }
        }
    }
    return 0;
}

Day 4: Class vs. Instance

using namespace std;
#include <iostream>

class Person{
    public:
        int age;
        Person(int initialAge);
        void amIOld();
        void yearPasses();
    };

    Person::Person(int initialAge){
        // Add some more code to run some checks on initialAge
        if(initialAge < 0){
            age = 0;
            cout << "Age is not valid, setting age to 0." << endl;
        }
        else age = initialAge;
    }

    void Person::amIOld(){
        // Do some computations in here and print out the correct statement to the console
        if(age >= 18){
            cout << "You are old." << endl;
        }
        else{
            if(age >= 13){
                cout << "You are a teenager." << endl;
            }
            else{
                cout << "You are young." << endl;
            }
        }
    }

    void Person::yearPasses(){
        // Increment the age of the person in here
        age++;
    }

int main(){
    int t;
	int age;
    cin >> t;
    for(int i=0; i < t; i++) {
    	cin >> age;
        Person p(age);
        p.amIOld();
        for(int j=0; j < 3; j++) {
        	p.yearPasses(); 
        }
        p.amIOld();
      
		cout << '\n';
    }

    return 0;
}

Day 5: Loops

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n = 0;
    cin >> n;
    
    for (int i = 1; i <= 10; i++)
        cout << n << " x " << i << " = " << n * i << endl;
        
    return 0;
}

Day 6: Let's Review

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n = 0;
    string str = "";
    string even = "";
    string odd = "";
    
    cin >> n;
    
    for(int i = 0; i < n; i++){
        cin >> str;
        even = "";
        odd = "";
        
        for(int j = 0; j < str.length(); j++){
            if(j % 2)
                odd += str[j];
            else
                even += str[j];
        }
        
        cout << even << " " << odd << endl;
    }
    
    return 0;
}

Day 7: Arrays

#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;


int main(){
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int arr_i = 0;arr_i < n;arr_i++){
       cin >> arr[arr_i];
    }
    
    for(vector<int>::reverse_iterator it = arr.rbegin(); it != arr.rend(); ++it){
        cout << *it << " ";
    }
    
    return 0;
}

Day 8: Dictionaries and Maps

#include <map>
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n = 0;
    string nombre = "";
    string phone = "";
    string query = "";
    map<string,string> guia;
    map<string,string>::iterator it;
    
    cin >> n;
    
    for(int i = 0; i < n; i++){
        cin >> nombre;
        cin >> phone;
        guia.insert(pair<string,string>(nombre,phone));
    }
    
    cin.clear();
    cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    
    while(getline(cin,query)){
        it = guia.find(query);
        if(it != guia.end())
            cout << query << "=" << it->second << endl;
        else
            cout << "Not found" << endl;
    }
    
    return 0;
}

Day 9: Recursion

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

long factorial(long valor){
    long result = 0;
    if(valor <= 1)
        return 1;
    else
        return (valor *  factorial(valor - 1));
    return result;
}

int main() {
    int n = 0;
    cin >> n;
    cout << factorial(n);
    return 0;
}

Day 10: Binary Numbers

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    long resto = 0;
    long numero = 0;
    long consecutivos = 0;
    long maxUnosConsecutivos = 0;
    bool anteriorCero = false;
    cin >> numero;
    
    while(numero > 0){
        resto = numero % 2;
        numero /= 2;
        if(resto == 1){
            consecutivos++;
            if(consecutivos > maxUnosConsecutivos)
                maxUnosConsecutivos = consecutivos;
        }
        else{
            consecutivos = 0;
        }
    }
    
    cout << maxUnosConsecutivos;
    
    return 0;
}

Day 11: 2D Arrays

#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
using namespace std;

int sumaHourGlass(vector< vector<int> > &arr, int x, int y){
    int suma = 0;
    for(int i = x; i < (x + 3); i++)
    {
        suma += arr[y][i];
    }
    y++;
    suma += arr[y][x+1];
    y++;
    for(int i = x; i < (x + 3); i++)
    {
        suma += arr[y][i];
    }
    return suma;
}

int main(){
    int suma = 0;
    int maxSuma = -63;
    vector< vector<int> > arr(6,vector<int>(6));
    
    for(int arr_i = 0;arr_i < 6;arr_i++){
       for(int arr_j = 0;arr_j < 6;arr_j++){
          cin >> arr[arr_i][arr_j];
       }
    }
    
    for(int arr_i = 0;arr_i < 4;arr_i++){
       for(int arr_j = 0;arr_j < 4;arr_j++){
          suma = sumaHourGlass(arr,arr_i,arr_j);
          if(suma > maxSuma)
              maxSuma = suma;
       }
    }
    
    cout << maxSuma;
    return 0;
}

Day 12: Inheritance

#include <iostream>
#include <vector>

using namespace std;


class Person{
	protected:
		string firstName;
		string lastName;
		int id;
	public:
		Person(string firstName, string lastName, int identification){
			this->firstName = firstName;
			this->lastName = lastName;
			this->id = identification;
		}
		void printPerson(){
			cout<< "Name: "<< lastName << ", "<< firstName <<"\nID: "<< id << "\n"; 
		}
	
};

class Student :  public Person{
	private:
		vector<int> testScores;  
	public:
  		Student(string firstName, string lastName, int identification, vector<int> &scores) : Person(firstName, lastName, identification){
            testScores = scores;
        }
  
  		string calculate(){
            int suma = 0;
            
            for(vector<int>::iterator it = testScores.begin();it != testScores.end();++it){
                suma += *it;
            }
            
            long promedio = suma / testScores.size();
            
            if(promedio >= 90)
                return "O";
            else if(promedio >= 80)
                return "E";
            else if(promedio >= 70)
                return "A";
            else if(promedio >= 55)
                return "P";
            else if(promedio >= 40)
                return "D";
            else return "T";
        }
};

int main() {
	string firstName;
  	string lastName;
	int id;
  	int numScores;
	cin >> firstName >> lastName >> id >> numScores;
  	vector<int> scores;
  	for(int i = 0; i < numScores; i++){
	  	int tmpScore;
	  	cin >> tmpScore;
		scores.push_back(tmpScore);
	}
	Student* s = new Student(firstName, lastName, id, scores);
	s->printPerson();
	cout << "Grade: " << s->calculate() << "\n";
	return 0;
}