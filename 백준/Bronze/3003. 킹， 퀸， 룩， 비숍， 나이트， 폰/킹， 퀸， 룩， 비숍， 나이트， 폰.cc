#include <bits/stdc++.h>
using namespace std;

int a[6];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    for(int i = 0; i < 6; i++){
        cin >> a[i];
    }

    cout << 1 - a[0] << " " << 1 - a[1] << " "  << 2 - a[2] << " "  << 2 - a[3] << " "  << 2 - a[4] << " " << 8 - a[5] << '\n';

    return 0;
}