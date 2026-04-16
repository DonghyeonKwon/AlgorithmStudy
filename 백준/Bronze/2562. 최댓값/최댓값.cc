#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a, ii, _max = -1;
    for(int i = 1; i <= 9; i++){
        cin >> a;
        if(_max < a){
            ii = i;
            _max = a;
        }
    }

    cout << _max << '\n' << ii << '\n';

    return 0;
}