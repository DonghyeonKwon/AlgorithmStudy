#include <bits/stdc++.h>
using namespace std;

int n, cnt = 0, _max = 50001;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    cnt = (n / 5);

    for(int i = 0; i <= cnt; i++){
        int nn = n - (i * 5);
        if(nn % 2 == 0){
            _max = min(_max, (i + nn / 2));
        }
    }
    cout << (_max == 50001 ? -1 : _max) << '\n';

    return 0;
}