#include <bits/stdc++.h>
using namespace std;

int n;
long long sum = 0;
vector<int> v;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 1; i <= n; i++){
        int input;
        cin >> input;
        v.push_back(input);
    }
    sort(v.begin(), v.end());
    for(int i = 1; i <= n; i++){
        sum += abs(i - v[i-1]);
    }
    cout << sum << '\n';

    return 0;
}