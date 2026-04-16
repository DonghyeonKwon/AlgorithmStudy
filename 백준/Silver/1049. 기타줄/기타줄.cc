#include <bits/stdc++.h>
using namespace std;

int n, m, line6[50], line1[50];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for(int i = 0; i < m; i++){
        cin >> line6[i] >> line1[i];
    }
    sort(line6, line6 + m);
    sort(line1, line1 + m);

    int a = n / 6, b = n % 6;
    
    int _min;
    if(b > 0){
        _min = min(line6[0] * a + b * line1[0], min(line6[0] * (a+1), line1[0] * n));
    }else{
        _min = min(line6[0] * a, line1[0] * n);
    }

    cout << _min << '\n';

    return 0;
}