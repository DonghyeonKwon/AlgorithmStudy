#include <iostream>
#include <map>
#include <string>
using namespace std;

map<string, bool> mp;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    mp["ChongChong"] = true;
    cin >> n;
    while(n--){
        string a, b;
        cin >> a >> b;
        if(mp[a] || mp[b]){
            mp[a] = true;
            mp[b] = true;
        }
    }

    int cnt = 0;
    for(auto it : mp){
        if(it.second) cnt++;
    }

    cout << cnt << '\n';

    return 0;
}