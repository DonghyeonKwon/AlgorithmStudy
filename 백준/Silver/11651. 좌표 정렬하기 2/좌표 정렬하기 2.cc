#include <bits/stdc++.h>
using namespace std;
int n;
vector<pair<int, int>> vp;
bool comp(pair<int,int> a, pair<int,int> b){
    if(a.second == b.second){
        return(a.first < b.first);
    }
    return (a.second < b.second); 
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;

    while(n){
        n--;
        int x, y;
        cin >> x >> y;
        vp.push_back({x,y});
    }
    
    sort(vp.begin(), vp.end(), comp);

    for(auto i : vp){
        cout << i.first << ' ' << i.second << '\n';
    }

    return 0;
}