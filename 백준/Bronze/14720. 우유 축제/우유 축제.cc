#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, milk = 0, cnt = 0;
    cin >> n;
    vector<int> v(n);
    for(int i = 0; i < n; i++){
        cin >> v[i];
        if(v[i] == milk % 3){
            cnt++;
            milk++;
        }
    }
    cout << cnt << '\n';

    return 0;
}