#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> v, v1;
    int n, m;
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        if(a < 0) v.push_back(a);
        else v1.push_back(a);
    }

    sort(v.begin(), v.end(), greater<>());
    sort(v1.begin(), v1.end());

    if(v.size() + v1.size() <= m){
        int a = (v.size() > 0) ? abs(v.back()) : 0;
        int b = (v1.size() > 0) ? v1.back() : 0;
        if(a > b) swap(a,b);
        cout << a * 2 + b << '\n';
        return 0;
    }
    
    vector<int> ret;
    for(int i = v.size() - 1; i - m + 1 >= 0; i -= m){
        int a = abs(v[i]);
        ret.push_back(a);
        int b = m;
        while(b--) v.pop_back();
    }
    for(int i = v1.size() - 1; i - m + 1 >= 0; i -= m){
        int a = v1[i];
        ret.push_back(a);
        int b = m;
        while(b--) v1.pop_back();
    }
    if(v.size()) ret.push_back(abs(v.back()));
    if(v1.size()) ret.push_back(v1.back());

    sort(ret.begin(), ret.end());

    int sum = 0;
    for(int i = 0; i < ret.size(); i++){
        if(i == ret.size()-1) sum += ret[i];
        else sum += ret[i] * 2;
    }
    cout << sum << '\n';

    return 0;
}