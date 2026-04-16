#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, a, _max = -1;
    vector<int> v;
    double sum = 0;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a;
        _max = max(_max, a);
        v.push_back(a);
    }
    for(int i : v)
        sum += (double)i/_max * 100;

    printf("%lf\n", (double)sum/n);

    return 0;
}