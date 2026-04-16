#include <bits/stdc++.h>
using namespace std;

int n, t, here = 100, _min = 987654321;
bool noNum[10];

bool checkNum(int a){
    string s = to_string(a);
    for(char c : s){
        if(!noNum[c - '0']) return false;
    }
    return true;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    fill(noNum, noNum + 10, true);
    cin >> t;
    for(int i = 0; i < t; i++){
        int a;
        cin >> a;
        noNum[a] = false;
    }

    _min = min(_min, abs(n - here));

    for(int i = 0; i <= 1000000; i++){
        if(checkNum(i)){
            _min = min(_min, abs(i - n) + (int)to_string(i).size());
        }
    }
    
    cout << _min << '\n';

    return 0;
}