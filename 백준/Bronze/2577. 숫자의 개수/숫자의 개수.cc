#include <iostream>
#include <vector>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a, b, c;
    vector<int> v(10, 0);
    cin >> a >> b >> c;
    
    a *= b;
    a *= c;

    while(a != 0){
        b = a % 10;
        v[b]++;
        a /= 10;
    }

    for(int i = 0; i < 10; i++) cout << v[i] << '\n';

    return 0;
}