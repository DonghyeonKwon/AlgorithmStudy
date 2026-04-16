#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int _max = -1, i_max, j_max, a;

    for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
            cin >> a;
            if(_max < a){
                _max = a;
                i_max = i;
                j_max = j;
            }
        }
    }

    cout << _max << '\n' << i_max+1 << ' ' << j_max+1 << '\n';

    return 0;
}