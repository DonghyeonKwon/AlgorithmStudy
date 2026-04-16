#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    scanf("%d", &n);
    double a[n], b[n+1], _max = 0.0;
    for(int i = 0; i < n; i++) {
        scanf("%lf", &a[i]);
    }

    b[0] = a[0];
    for(int i = 1; i < n; i++){
        b[i] = max(b[i-1] * a[i], a[i]);
        _max = max(_max, b[i]);
    }

    printf("%.3f\n", _max);

    return 0;
}