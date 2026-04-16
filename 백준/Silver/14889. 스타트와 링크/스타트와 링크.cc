#include <bits/stdc++.h>
using namespace std;
int n, a[21][21];
int sumTeamNum(vector<int> &v){
    int sum = 0;
    for(int i = 0; i < v.size()-1; i++){
        for(int j = i+1; j < v.size(); j++){
            // cout << i << ' ' << j << ':' << a[v[i]][v[j]] << ' ' << a[v[j]][v[i]] << '\n';
            sum += (a[v[i]][v[j]] + a[v[j]][v[i]]);
        }
    }
    // cout << sum <<'\n';
    return sum;
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 1; i <= n; i++){
        for(int j = 1 ; j <= n; j++){
            cin >> a[i][j];
        }
    }
    int _min = 987654321;
    for(int s = 0; s < (1 << (n+1)); s++){
        if(s & 1) continue;
        vector<int> s1, s2;
        int k = 0;
        for(int i = 1; i < n+1; i++){
            if((s & (1<<i))) {
                s1.push_back(i);
            }
            else{
                s2.push_back(i);
            }
        }
        // cout << "s1.size() = " << s2.size() << '\n';
        if(s1.size() != n/2) continue;
        int sA = 0, sB = 0;
        sA = sumTeamNum(s1);
        sB = sumTeamNum(s2);
        k = abs(sA - sB);
        
        _min = min(_min, k);
    }

    cout << _min << '\n';

    return 0;
}