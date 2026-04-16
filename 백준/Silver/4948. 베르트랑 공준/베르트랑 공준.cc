#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    bool a[246913] = {false,};
    a[1] = true;
    for(int i = 2; i <= 246912; i++){
        if(a[i]) continue;
        for(int j = i*2; j <= 246912; j += i){
            a[j] = true;
        }
    }

    int n;
    while(1){
        cin >> n;
        if(n == 0) break;
        int cnt = 0;
        for(int i = n+1; i <= 2*n; i++){
            if(!a[i]) cnt++;
        }
        cout << cnt << '\n';
    }

    return 0;
}