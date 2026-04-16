#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// int main(){
//     ios_base::sync_with_stdio(false);
//     cin.tie(NULL);
//     cout.tie(NULL);

//     int n, k;
//     cin >> n >> k;
//     vector<int> up, down;
//     for(int i = 0; i < n /2; i++){
//         int a, b;
//         cin >> a >> b;
//         down.push_back(a);
//         up.push_back(b);
//     }

//     sort(down.begin(), down.end());
//     sort(up.begin(), up.end());

//     int _min = 500001, cnt = 0;
//     for(int i = 1; i <= k; i++){
//         int down_cnt = lower_bound(down.begin(), down.end(), i) - down.begin();
//         int up_cnt = lower_bound(up.begin(), up.end(), k - i + 1) - up.begin();
//         // cout << down_cnt << ' ' << up_cnt << '\n';
//         int cur = n - (down_cnt + up_cnt);

//         if(cur < _min){
//             _min = cur;
//             cnt = 1;
//         }
//         else if(cur == _min) cnt++;
//     }

//     cout << _min << ' ' << cnt << '\n';

//     return 0;
// }

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, h;
    cin >> n >> h;
    vector<int> down(h + 1, 0), up(h + 1, 0);
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        if(i % 2 == 0) down[a]++;
        else up[h - a + 1]++;
    }

    for(int i = 1; i <= h; i++){
        up[i] += up[i-1];
        down[h - i] += down[h - i + 1];
    }

    int ans = 987654321, cnt = 0;
    for(int i = 1; i <= h; i++){
        if(up[i] + down[i] < ans){
            ans = up[i] + down[i];
            cnt = 1;
        }
        else if(up[i] + down[i] == ans) cnt++;
    }
    cout << ans << ' ' << cnt << '\n';

    return 0;
}