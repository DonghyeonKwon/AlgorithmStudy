#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    vector<int> v;
    cin >> n;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        v.push_back(a);
    }
    int ret = 0;
    for(int i = n-1; i > 0; i--){
        if(v[i] <= v[i-1]){
            int temp = v[i] - 1;
            ret += (v[i-1] - temp);
            v[i-1] = temp;
        }
    }
    cout << ret << '\n';

    return 0;
}