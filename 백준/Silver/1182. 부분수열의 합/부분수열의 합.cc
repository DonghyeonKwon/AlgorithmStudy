#include <bits/stdc++.h>
using namespace std;

int n, s, arr[20], ret = 0;

void go(int idx, int sum, int cnt, int c){
    if(cnt == c){
        if(sum == s) ret++;
        return;
    }

    for(int i = idx; i < n; i++){
        sum += arr[i];
        go(i+1, sum, cnt + 1, c);
        sum -= arr[i];
    }
}

void func(int idx, int sum){
    if(idx == n){
        if(sum == s) ret++;
        return;
    }
    func(idx+1, sum);
    func(idx+1, sum + arr[idx]);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> s;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    // for(int i = 1; i <= n; i++){
    //     go(0, 0, 0, i);
    // }
    func(0, 0);
    if(s == 0) ret--;

    cout << ret << '\n';

    return 0;
}