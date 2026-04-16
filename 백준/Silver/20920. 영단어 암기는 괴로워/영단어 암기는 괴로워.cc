#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

map<string, int> mp;
vector<pair<string, int>> v;

bool cmp(pair<string, int> a, pair<string, int> b){
    if(a.second == b.second){
        if(a.first.size() == b.first.size()){
            return a.first < b.first;
        }
        return a.first.size() > b.first.size();
    }
    return a.second > b.second;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;
    while(n--){
        string a;
        cin >> a;
        if(a.size() < m) continue;
        mp[a]++;
    }

    for(auto it : mp){
        v.push_back(it);
    }

    sort(v.begin(), v.end(), cmp);

    for(auto it : v){
        cout << it.first << '\n';
    }

    return 0;
}