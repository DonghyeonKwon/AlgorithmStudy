#include <iostream>
using namespace std;

int n, _mx = 0, ans = 0, arr[1000001];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        if(arr[a+1] > 0) arr[a+1]--;
        arr[a]++;
        if(_mx < a) _mx = a;
    }

    for(int i = 1; i <= _mx; i++){
        ans += arr[i];
    }
    cout << ans << '\n';

    return 0;
}