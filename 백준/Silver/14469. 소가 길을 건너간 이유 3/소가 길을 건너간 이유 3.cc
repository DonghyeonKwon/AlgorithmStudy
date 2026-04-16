#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;
    pair<int, int> p[n];
    for(int i = 0; i < n; i++){
        cin >> p[i].first >> p[i].second;
    }
    sort(p, p + n);
    int l = p[0].first;
    int r = p[0].second;
    int sum = l + r;
    for(int i = 1; i < n; i++){
        if(sum <= p[i].first){
            sum = (p[i].first + p[i].second);
        }
        else{
            sum += p[i].second;
        }
    }
    cout << sum << '\n';

    return 0;
}