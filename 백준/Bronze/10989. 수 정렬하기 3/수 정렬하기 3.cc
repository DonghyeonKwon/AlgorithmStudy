#include <bits/stdc++.h>
using namespace std;
int n, v[10001] = {0,};
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        v[a]++;
    }
    for(int i = 1; i <= 10000; i++){
        while(v[i] > 0){
            v[i]--;
            cout << i << '\n';
        }
    }
    return 0;
}