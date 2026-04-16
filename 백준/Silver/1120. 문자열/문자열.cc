#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string a, b;
    cin >> a >> b;

    int _mn = 987654321;
    for(int i = 0; i <= b.size() - a.size(); i++){
        int cnt = 0;
        for(int j = 0; j < a.size(); j++){
            if(b[i + j] != a[j]) cnt++;
        }
        _mn = min(_mn, cnt);
    }
    cout << _mn << '\n';

    return 0;
}