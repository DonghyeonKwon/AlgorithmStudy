#include <bits/stdc++.h>
using namespace std;

int w, h, n, dd, dp;
vector<pair<int, int>> vp;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> w >> h;
    cin >> n;
    for(int i = 0; i < n; i++){
        int a, b;
        cin >> a >> b;
        vp.push_back({a, b});
    }
    cin >> dd >> dp;

    int d, p, sum = 0;
    for(int i = 0; i < vp.size(); i++){
        tie(d, p) = vp[i];
        if(d == dd) {
            sum += abs(p - dp);
            // cout << sum << '\n';
            continue;
        }
        if(dd == 1){
            if(d == 2) sum += min(dp + h + p, w + w + h - p - dp);
            else if(d == 3) sum += (p + dp);
            else if(d == 4) sum += (w - dp + p);
        }
        else if(dd == 2){
            if(d == 1) sum += min(dp + h + p, w + w + h - p - dp);
            else if(d == 3) sum += (h - p + dp);
            else if(d == 4) sum += (h - p + w - dp);
        }
        else if(dd == 3){
            if(d == 1) sum += (p + dp);
            else if(d == 2) sum += (h - dp + p);
            else if(d == 4) sum += min(dp + w + p, h + h + w - dp - p);
        }
        else if(dd == 4){
            if(d == 1) sum += (dp + w - p);
            else if(d == 2) sum += (h - dp + w - p);
            else if(d == 3) sum += min(dp + w + p, h + h + w - dp - p);
        }
        // cout << sum << '\n';
    }
    cout << sum << '\n';

    return 0;
}