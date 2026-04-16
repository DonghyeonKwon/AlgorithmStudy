#include <bits/stdc++.h>
using namespace std;

int t, k, a[1001] = {0 ,}, n, d, cnt = 0;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> t;
    for(int i = 1; i <= t; i++){
        string s;
        cin >> s;
        for(int j = 0; j < 8; j++){
            if(s[j] == '1') a[i] |= (1 << (7 - j));
        }
    }

    // cout << "\n\n";
    // for(int i = 1; i <= t; i++){
    //     cout << bitset<8>(a[i]) << '\n';
    // }
    

    cin >> k;
    for(int i = 0; i < k; i++){
        cin >> n >> d;
        int ch[t];
        fill(ch, ch + t, 0);
        ch[n] = d;
        for(int j = n - 1; j > 0; j--){
            if(ch[j+1] == 0) {
                ch[j] = 0;
                continue;
            }
            int m = ((a[j+1] & (1 << 1)) > 0) ? 1 : 0;
            int l = ((a[j] & (1 << 5)) > 0) ? 1 : 0;
            if(m == l) ch[j] = 0;
            else ch[j] = ch[j+1] * -1;
        }
        for(int j = n+1; j <= t; j++){
            if(ch[j-1] == 0){
                ch[j] = 0;
                continue;
            }
            int m = ((a[j-1] & (1 << 5)) > 0) ? 1 : 0;
            int l = ((a[j] & (1 << 1)) > 0) ? 1 : 0;
            if(m == l) ch[j] = 0;
            else ch[j] = ch[j-1] * -1;
        }

        // for(int j = 1; j <= t; j++){
        //     cout << ch[j] << ' ';
        // }cout << '\n';

        for(int j = 1; j <= t; j++){
            if(ch[j] == 0) continue;
            if(ch[j] == 1){
                int m = a[j] & 1;
                a[j] = (a[j] >> 1);
                if(m == 1) a[j] |= (1 << 7);
            } 
            else if(ch[j] == -1){
                int m = a[j] & (1 << 7);
                a[j] = (a[j] << 1);
                a[j] &= ~(1 << 8);
                // cout << j << ' ' << m << '\n';s
                if(m == 128) a[j] |= (1 << 0);

            }
        }
        // cout << "\n\n";
        // for(int i = 1; i <= t; i++){
        //     cout << bitset<8>(a[i]) << '\n';
        // }
    }
    
    for(int i = 1; i <= t; i++){
        if(a[i] & (1 << 7)) cnt++;
    }
    cout << cnt << '\n';

    return 0;
}
