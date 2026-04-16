#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    vector<pair<int, int>> vp(n, {0,0});
    for(int i = 0; i < n; i++) cin >> vp[i].first >> vp[i].second;
    sort(vp.begin(), vp.end());

    vector<pair<int, int>> tmp;
    tmp.push_back(vp[0]);
    int s = vp[0].first, e = vp[0].second, ret = 0;
    for(int i = 1; i < n; i++){
        if(s <= vp[i].first && vp[i].first <= e + 1){
            bool flag = true;
            for(int j = 0; j < (int)tmp.size(); j++){
                if(tmp[j].second < vp[i].first){
                    flag = false;
                    tmp[j].second = vp[i].second;
                    break;
                }
            }
            if(flag){
                tmp.push_back(vp[i]);
            }
            if(e < vp[i].second) e = vp[i].second;
        }
        else{
            ret += ((e - s + 1) * (int)tmp.size());
            tmp.clear();
            tmp.push_back(vp[i]);
            s = vp[i].first;
            e = vp[i].second;
        }
    }
    ret += ((e - s + 1) * (int)tmp.size());

    cout << ret << '\n';

    return 0;
}