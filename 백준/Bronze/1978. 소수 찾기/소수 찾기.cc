#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int n, m, cnt = 0;
    cin >> n;
    while(n){
        n--;
        cin >> m;
        int c = 0;
        for(int i = 1; i <= m; i++)
            if(m%i == 0) c++;
        if(c == 2) cnt++;
    }
    cout << cnt << '\n';
    return 0;
}