#include <bits/stdc++.h>
using namespace std;

int e, s, m;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> e >> s >> m;
    
    int de = 1, ds = 1, dm = 1, cnt = 1;
    while(!(de == e && ds == s && dm == m)){
        de++;
        ds++;
        dm++;
        cnt++;
        if(de > 15) de = 1;
        if(ds > 28) ds = 1;
        if(dm > 19) dm = 1;
    }
    cout << cnt << '\n';
    return 0;
}