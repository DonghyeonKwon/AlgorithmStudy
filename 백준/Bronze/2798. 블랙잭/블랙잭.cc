#include <bits/stdc++.h>
using namespace std;
int n, m, a[100], _max = -1;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }

    for(int i = 0; i < n-2; i++){
        for(int j = i+1; j < n-1; j++){
            for(int k = j + 1; k < n; k++){
                int sum = a[i] + a[j] + a[k];
                if(m >= sum && _max < sum) _max = sum;
            }
        }
    }

    cout << _max << '\n';

    return 0;
}