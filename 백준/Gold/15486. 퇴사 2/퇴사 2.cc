#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int n;
int day[1500002] = {0, }, pay[1500002] = {0, };
ll res[1500002] = {0,};

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> day[i] >> pay[i];
    }

    for(int i = n; i > 0; i--){
        int deadline = i + day[i];

        if(deadline > n + 1){
            res[i] = res[i+1];
        }
        else{
            res[i] = max((ll)(res[i+day[i]] + pay[i]), (ll)res[i+1]);
        }
    }
    cout << res[1] << '\n';

    return 0;
}