#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int a, b, c, _max, other_sum = 0;
    cin >> a >> b >> c;

    if(a < b){
        _max = b;
        other_sum += a;
    }
    else{
        _max = a;
        other_sum += b;
    }

    if(_max < c){
        other_sum += _max;
        _max = c;
    }
    else{
        other_sum += c;
    }

    if(_max >= other_sum){
        cout << other_sum * 2 - 1 << '\n';
    }
    else{
        cout << other_sum + _max << '\n';
    }

    return 0;
}