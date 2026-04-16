#include <bits/stdc++.h>
using namespace std;

void go(int a[], int b[], int i){
    if(i == -1) return;
    go(a, b, b[i]);
    cout << a[i] << ' ';
    return;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, ret = -1, idx;
    cin >> n;
    int a[n], cnt[n+1], b[n+1];
    for(int i = 0; i < n; i++) cin >> a[i];
    fill(b, b+n+1, -1);
    fill(cnt, cnt+n+1, 1);
    for(int i = 0; i < n; i++){
        for(int j = 0; j < i; j++){
            if(a[j] < a[i] && cnt[j]+1 > cnt[i]){
                cnt[i] = cnt[j] + 1;
                b[i] = j;
            }
        }
        if(ret < cnt[i]){
            ret = cnt[i];
            idx = i;
        }
    }

    cout << ret << '\n';
    go(a, b, idx);
    cout << '\n';

    return 0;
}