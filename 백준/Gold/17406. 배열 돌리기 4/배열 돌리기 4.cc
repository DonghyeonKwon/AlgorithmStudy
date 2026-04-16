#include <bits/stdc++.h>
using namespace std;

int n, m, k, _min = 6001;
int a[101][101], temp[101][101];
pair<int, int> p[6];
vector<int> idx;
int cnt[6];

void count(int r, int c, int s){
    for(int t = s; t > 0; t--){
        int b = 0;
        int y = r-t;
        int x = c-t;
        for(; x <= c+t; x++) swap(b, a[y][x]);
        y++;
        x--;
        for(; y <= r+t; y++) swap(b, a[y][x]);
        x--;
        y--;
        for(; x >= c-t; x--) swap(b, a[y][x]);
        y--;
        x++;
        for(; y >= r-t; y--) swap(b, a[y][x]);


        // for(int i = 1; i <= n; i++){
        //     for(int j = 1; j <= m; j++){
        //         cout << a[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }
        // cout << '\n';
    }
}

void init(){
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            a[i][j] = temp[i][j];
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m >> k;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            cin >> a[i][j];
            temp[i][j] = a[i][j];
        }
    }
    for(int i = 0; i < k; i++){
        cin >> p[i].first >> p[i].second >> cnt[i];
        idx.push_back(i);
    }

    do{
        // for(int i : idx){
        //     cout << i << ' ';
        // }
        // cout << '\n';
        for(int i : idx){
            int r = p[i].first, c = p[i].second, s = cnt[i];
            count(r, c, s);
        }
        for(int y = 1; y <= n; y++) {
            int sum = 0;
            for(int x = 1; x <= m; x++){
                sum += a[y][x];
            }
            // cout << sum << '\n';
            _min = min(_min, sum);
        }
        init();
    }while(next_permutation(idx.begin(), idx.end()));

    cout << _min << '\n';

    return 0;
}