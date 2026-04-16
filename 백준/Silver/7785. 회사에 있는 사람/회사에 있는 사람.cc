#include <bits/stdc++.h>
using namespace std;

int n;
map<string, bool> mp;
vector<string> v;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        string a, b;
        cin >> a >>  b;
        if(b == "enter"){
            mp[a] = true;
        }
        else{
            mp[a] = false;
        }
    }
    for(auto i : mp){
        if(i.second) v.push_back(i.first);
    }
    sort(v.begin(), v.end(), greater<>());
    for(string i : v){
        cout << i << '\n';
    }

    return 0;
}