#include <iostream>
#include <cmath>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int m, n;
    cin >> m >> n;
    int sum = -1, _mn = 987654321;
    for(int i = m; i <= n; i++){
        int a = sqrt(i);
        if(i != a * a) continue;
        if(sum == -1){
            _mn = i;
            sum = i;
        }
        else sum += i;
    }

    if(sum == -1){
        cout << sum << '\n';
    }
    else{
        cout << sum << '\n';
        cout << _mn << '\n';
    }

    return 0;
}