#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    vector<int> v;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        v.push_back(a);
    }

    sort(v.begin(), v.end(), greater<>());

    int sum = 0;
    for(int i = 0; i < n; i += 3){
        if(i + 3 <= n){
            sum += v[i] + v[i+1];
        }
        else{
            while(i < n){
                sum += v[i++];
            }
        }
    }

    cout << sum << '\n';

    return 0;
}