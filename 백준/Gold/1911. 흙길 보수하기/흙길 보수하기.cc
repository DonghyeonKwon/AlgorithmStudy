#include <bits/stdc++.h>
using namespace std;

int n, l, sp = 0, cnt = 0;
vector<pair<int, int>> vp;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> l;

    for(int i = 0; i < n; i++){
        int s, e;
        cin >> s >> e;
        vp.push_back({s, e});
    }
    sort(vp.begin(), vp.end());

    for(pair<int, int> it : vp){
        if(sp >= it.second) continue;
        sp = max(sp, it.first);
        int c = (it.second - (sp + 1)) / l + 1;
        cnt += c;
        sp += l * c;
    }
    cout << cnt << '\n';

    return 0;
}