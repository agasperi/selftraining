#include <iostream>
#include <string>
#include <locale>

using namespace std;

string LetterChanges(string str) { 
  string change = "";
  locale loc;
  
  for (string::iterator it=str.begin(); it!=str.end(); ++it)
  {
    if (isalpha(*it,loc))
    {
        if (*it == 'z')
          change += 'a';
        else
        {
          char letra = *it + 1;
          if(letra == 'a' || letra == 'e' || letra == 'i'|| letra == 'o'|| letra == 'u')
            letra = toupper(letra,loc);
          change += letra;
        }
    }
    else change += *it;
  }
  return change; 
            
}

int main() { 
  
  // keep this function call here
  cout << LetterChanges(gets(stdin));
  return 0;
    
}


#include <iostream>
#include <string>
#include <locale>

using namespace std;

string SimpleSymbols(string str) { 
  string change = "true";
  locale loc;
  bool izq = false;
  bool letra = false;
  bool number = false;
  
  for (string::iterator it=str.begin(); it!=str.end(); ++it)
  {
    if (isalnum(*it,loc))
    {
        if(letra) return "false";
        if (isalpha(*it,loc))
        {
            number = false;
            letra = true;
            if(!izq)
              return "false";
        }
        else number = true;
    }
    else
    {
        if(*it == '+')
        {
         if(izq)
         {
             if(letra)
             {
                 letra = false;
             }
         }
         else
         {
             izq = true;
         }
        }
        else if (*it == '=')
        {
              if(izq && letra) return "false";
              izq = false;
        }
        else return "false";
        letra = false;
    }
  }
  if (letra) return "false";
  return change; 
}

int main() { 
  
  // keep this function call here
  cout << SimpleSymbols(gets(stdin));
  return 0;
    
}

#include <iostream>
#include <string>
#include <locale>
using namespace std;

string LongestWord(string sen) { 
  int count = 0;
  string word = "";
  string largest = "";
  std::locale loc;
  
  for(string::iterator it=sen.begin(); it!=sen.end(); ++it)  
  {
    if (isalpha(*it,loc))
    {
      word += *it;
      count++;
    }
    else
    {
        count = 0;
        if(word.length() > largest.length())
          largest = word;
        word = "";
    }
  }
  if(word.length() > largest.length()) largest = word;
  
  return largest;
}

int main() { 
  
  // keep this function call here
  cout << LongestWord(gets(stdin));
  return 0;
}

#include <iostream>
#include <string>
#include <sstream>

using namespace std;

string TimeConvert(int num) {
  int hora = num / 60;
  int minutos = num % 60;
  stringstream ss;
  ss << "" << hora << ":" << minutos;
  return ss.str(); 
            
}

int main() { 
  
  // keep this function call here
  cout << TimeConvert(gets(stdin));
  return 0;
    
}


int main() {
    // Declare a variable named 'input_string' to hold our input.
    string input_string; 
    
    // Read a full line of input from stdin (cin) and save it to our variable, input_string.
    getline(cin, input_string); 
    
    // Print a string literal saying "Hello, World." to stdout using cout.
    cout << "Hello, World." << endl;

    // TODO: Write a line of code here that prints the contents of input_string to stdout.

    return 0;
}

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

    return 0;
}


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

    switch (numero){
        case 1: cout << "one"; break;
        case 2: cout << "two"; break;
        case 3: cout << "three"; break;
        case 4: cout << "four"; break;
        case 5: cout << "five"; break;
        case 6: cout << "six"; break;
        case 7: cout << "seven"; break;
        case 8: cout << "eight"; break;
        case 9: cout << "nine"; break;
        default: cout << "Greater than 9"; break;
    }
	
int max_of_four(int a, int b, int c, int d){
    int mayor = a;
    
    mayor = a > b ? a : b;
    mayor = mayor > c ? mayor : c;
    mayor = mayor > d ? mayor : d;
    return mayor;
}

int main() {
    int n = 0;
    cin >> n;
    vector<int> a;
    int num = 0;
    
    for(int i = 0; i < n ; i++){
        cin >> num;
        a.push_back(num);
    }
    
    for(vector<int>::reverse_iterator it=a.rbegin(); it!=a.rend(); ++it){
        cout << *it << " ";
    }
    
    return 0;
}

int main(){
	int n; cin >> n;
	vector<int> v(n);
	foreach(v, i) {
		io(v)[i];
	}
	int mn = INF;
	int mx = -INF;
	foreach(v, i) {
		minimum(mn, v[i]);
		maximum(mx, v[i]);
	}
	int ans = mx - mn;
	cout << toStr(Result =) <<' '<< ans;
	return 0;

}