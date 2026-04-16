#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<int> v, sums;
long long ret = 0;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    v.resize(n);
    sums.resize(n);
    for(int i = 0; i < n; i++){
        cin >> v[i];
        if(i == 0) sums[i] = v[i];
        else sums[i] = sums[i-1] + v[i];   
    }

    for(int i = 1; i < n-1; i++){
        int cur = (sums[i] - sums[0]) + (sums[n-2] - sums[i-1]);
        if(ret < cur) ret = cur;
    }

    for(int i = 1; i < n-1; i++){
        int cur = sums[n-2] + sums[i-1] - v[i];
        if(ret < cur) ret = cur;
    }

    for(int i = 1; i < n-1; i++){
        int cur = sums[n-1] - sums[0] + (sums[n-1] - sums[i]) - v[i];
        if(ret < cur) ret = cur;
    }

    cout << ret << '\n';

    return 0;
}