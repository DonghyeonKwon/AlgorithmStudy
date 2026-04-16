#include <bits/stdc++.h>
using namespace std;

int h, m, a;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> h >> m;
    cin >> a;

    m += a;
    if(m >= 60){
        h += (m / 60);
        m %= 60;
    }
    if(h >= 24){
        h %= 24;
    }

    cout << h << " " << m << '\n';


    return 0;
}