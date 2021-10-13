#include <iostream> 
#include <string> 

using namespace std; 

void printInfo(string &s) {
        cout << "content =\"" << s << "\" " << endl;
		cout << "length = " << s.length() << endl;
        cout << "capacity = " << s.capacity() << endl;
        cout << "max size = " << s.max_size() << endl;
		cout << "is empty? " << (s.empty() ? "yes" : "no") << endl;
        cout << "---------" << endl;
}

class Class {
	int *data;
public:
	Class(int value) {
		 data = new int;
		*data = value;
	}
	void increment(void) { (*data)++; }
	int value(void) { return *data; }
};
int main(void) {
	Class o1(123);
	Class o2 = o1;
	Class o3(o2);
	o1.increment();
	cout << o1.value() << endl;
	cout << o2.value() << endl;
	cout << o3.value() << endl;
	return 0;
}