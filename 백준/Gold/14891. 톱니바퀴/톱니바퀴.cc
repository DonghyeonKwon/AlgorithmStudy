#include <bits/stdc++.h>
using namespace std;

int a[5] = {0, 0, 0, 0, 0}, t, n, d;
int dd[5] = {0, 0, 0, 0, 0};

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    for(int i = 1; i <= 4; i++){
        string str;
        cin >> str;
        for(int j = 7; j >= 0; j--){
            if(str[j] == '1') a[i] |= (1 << (7-j));
        }
    }

    cin >> t;
    while(t--){
        cin >> n >> d;
        dd[n] = d;
        //현재 상태 점검
        for(int i = n; i > 1; i--){
            if(dd[i] == 0) { dd[i-1] = 0; continue; }
            int l = a[i] & (1 << 1)? 1 : 0, r = a[i-1] & (1 << 5) ? 1: 0;
            if(l != r) dd[i-1] = dd[i] * -1;
            else dd[i-1] = 0;
        }
        for(int i = n; i < 4; i++){
            if(dd[i] == 0) { dd[i+1] = 0; continue; }
            int l = a[i] & (1 << 5)? 1 : 0, r = a[i+1] & (1 << 1) ? 1: 0;
            if(l != r) dd[i+1] = dd[i] * -1;
            else dd[i+1] = 0;
        }
        for(int i = 1; i <= 4; i++){
            if(dd[i] == 0) continue;
            if(dd[i] == 1){
                int temp = a[i] & 1;
                a[i] = a[i] >> 1;
                if(temp) a[i] |= (1 << 7);
            }
            else{
                int temp = a[i] & (1 << 7);
                a[i] = a[i] << 1;
                if(temp) a[i] |= 1;
            }
        }
    }
    int ret = 0;
    for(int i = 1; i <= 4; i++){
        if(a[i] & (1<<7)) ret |= (1 << (i-1));
    }
    cout << ret << '\n';
    
    return 0;
}