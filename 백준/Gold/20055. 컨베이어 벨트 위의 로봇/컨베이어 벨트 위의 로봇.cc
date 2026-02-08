#include <iostream>
#include <vector>

using namespace std;

int n, k;



int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> k;
    vector<pair<int, bool>> v(2 * n + 1, {0, false});

    for(int i = 1; i <= 2 * n; i++)
        cin >> v[i].first;

    int cnt = 0;
    while(1){
        cnt++;
        pair<int, bool> tmp = v[1];
        for(int i = 2; i <= 2 * n; i++){
            swap(tmp, v[i]);
            if(i == n && v[i].second) v[i].second = false;
        }
        swap(tmp, v[1]);

        // cout << "컨베어밸트 이동\n";
        // for(int i = 1; i <= 2 * n; i++){
        //     cout << v[i].first << ' ';
        //     if(i == n) cout << '\n';
        // }
        // cout << '\n' << '\n';

        for(int i = n-1; i >= 1; i--){
            if(!v[i].second) continue;
            if(v[i+1].first >= 1 && !v[i+1].second){
                v[i+1].first--;
                v[i+1].second = true;
                v[i].second = false;
                if(i+1 == n) v[i+1].second = false;
            }
        }

        // cout << "로봇 이동\n";
        // for(int i = 1; i <= 2 * n; i++){
        //     cout << v[i].first << ' ';
        //     if(i == n) cout << '\n';
        // }
        // cout << '\n' << '\n';

        if(v[1].first >= 1){
            v[1].first--;
            v[1].second = true;
        }

        // cout << "로봇 올리기\n";
        // for(int i = 1; i <= 2 * n; i++){
        //     cout << v[i].first << ' ';
        //     if(i == n) cout << '\n';
        // }
        // cout << '\n' << '\n';

        int zero_cnt = 0;
        for(int i = 1; i <= 2 * n; i++){
            if(v[i].first == 0) zero_cnt++;
        }

        if(zero_cnt >= k) break;
    }

    cout << cnt << '\n';

    return 0;
}