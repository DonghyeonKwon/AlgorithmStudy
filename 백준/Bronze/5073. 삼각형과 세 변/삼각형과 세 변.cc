#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    while(1){
        int a, b, c;
        cin >> a >> b >> c;
        if(a == 0 && b == 0 && c == 0) break;

        int _max = 0, other_sum = 0;

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
            cout << "Invalid\n";
            continue;
        }
        if(a == b && b == c) cout << "Equilateral\n";
        else if(a == b || b == c || a == c) cout << "Isosceles\n";
        else cout << "Scalene\n";
        
    }

    return 0;
}