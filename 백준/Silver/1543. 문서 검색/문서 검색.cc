#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string a, b;
    getline(cin, a);
    getline(cin, b);
    int cnt = 0, pos;

    while((pos = a.find(b)) != string::npos){
        cnt++;
        a.erase(0, pos + b.length());
    }

    cout << cnt << '\n';

    return 0;
}