#include <bits/stdc++.h>
using namespace std;
int h, w, n, _mx = 0;
vector<pair<int, int>> vp;
vector<pair<int, int>> temp;

void count(){
    int a1 = temp[0].first, a2 = temp[0].second;
    int b1 = temp[1].first, b2 = temp[1].second;
    int sum = (a1 * a2) + (b1 * b2);
    int nh = h - a1, nw = w - a2;
   
    if((b1 <= nh && b2 <= w) || (b1 <= h && b2 <= nw) || (b2 <= nh && b1 <= w) || (b2 <= h && b1 <= nw)){
        if(_mx < sum) _mx = sum;
        return;
    }
    if(!(a2 <= h && a1 <= w)) return;
    nh = h - a2;
    nw = w - a1;
    if((b1 <= nh && b2 <= w) || (b1 <= h && b2 <= nw) || (b2 <= nh && b1 <= w) || (b2 <= h && b1 <= nw)){
        if(_mx < sum) _mx = sum;
        return;
    }
}

void go(int idx, int cnt){
    if(cnt == 2){
        count();
        return;
    }

    for(int i = idx; i < vp.size(); i++){
        temp.push_back(vp[i]);
        go(i+1, cnt+1);
        temp.pop_back();
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> h >> w;
    cin >> n;
    for(int i = 0; i < n; i++){
        int a, b;
        cin >> a >> b;
        if(a <= h && b <= w){
            vp.push_back({a, b});
        }
        else if(b <= h && a <= w){
            vp.push_back({b, a});
        }
    }

    go(0, 0);
    cout << _mx << '\n';

    return 0;
}