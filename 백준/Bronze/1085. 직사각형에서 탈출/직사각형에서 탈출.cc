#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int x, y, w, h;
    cin >> x >> y >> w >> h;

    x = (x < w-x) ? x : w-x;
    y = (y < h-y) ? y : h-y;
    cout << ((x <= y) ? x : y) << '\n';
    
    return 0;
}