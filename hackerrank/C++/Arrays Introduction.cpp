#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


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


// Other options

#include <cstdio>
#include <cstdlib>

void update(int *a,int *b) {
    int temp = *a;
    *a = *a + *b;
    *b = abs(temp - *b);

}

int main() {
    int a, b;
    int *pa = &a, *pb = &b;
    
    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);

    return 0;
}