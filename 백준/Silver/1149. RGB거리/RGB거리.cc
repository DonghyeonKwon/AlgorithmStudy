#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int rgb[1001][3], n;
    rgb[0][0] = 0;
    rgb[0][1] = 0;
    rgb[0][2] = 0;

    cin >> n;
    for(int i = 1; i <= n; i++){
        int a, b, c;
        cin >> a >> b >> c;
        rgb[i][0] = min(rgb[i-1][1], rgb[i-1][2]) + a;
        rgb[i][1] = min(rgb[i-1][0], rgb[i-1][2]) + b;
        rgb[i][2] = min(rgb[i-1][1], rgb[i-1][0]) + c;
    }
    cout << min(rgb[n][0], min(rgb[n][1], rgb[n][2])) << '\n';

    return 0;
}