#include <bits/stdc++.h>
using namespace std;

const int dx[] = {1, 0, -1, 0};
const int dy[] = {0, 1, 0, -1};

int n, k, l, d = 0, s = 1;
bool mp[101][101] { {false , }, };
int snake[101][101] = { {0, }, };
vector<pair<int, char>> vp;
pair<int, int> head, tail;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n;
    cin >> k;
    for(int i = 0; i < k; i++){
        int y, x;
        cin >> y >> x;
        mp[y][x] = true;
    }
    cin >> l;

    snake[1][1] = 1;
    head.first = 1;
    head.second = 1;
    tail.first = 1;
    tail.second = 1;
    int cnt = 0;

    for(int i = 0; i < l; i++){
        int t;
        char c;
        cin >> t;
        cin >> c;
        vp.push_back({t,c});
    }
    vp.push_back({10001,'L'});

    // bool wall_crash = false, body_crash = false;
    for(pair<int,char> it : vp){
        int t = it.first;
        char c = it.second;
        // cout << cnt << '\n';
        while(1){
            // cout << cnt << '\n';
            head.first += dy[d];
            head.second += dx[d];
            cnt++;
            if(snake[head.first][head.second] > 0 || head.first <= 0 || head.second <= 0 || head.first > n || head.second > n){
                cout << cnt << '\n';
                return 0;
            }
            if(!mp[head.first][head.second]){
                int td = snake[tail.first][tail.second] - 1;
                snake[tail.first][tail.second] = 0;
                tail.first += dy[td];
                tail.second += dx[td];
                snake[head.first][head.second] = d+1;
            }
            else{
                snake[head.first][head.second] = d+1;
                mp[head.first][head.second] = false;
            }
            if(cnt == t) break; 
        }
        // cout << cnt << '\n';

        if(c == 'L'){
            d -= 1;
            if(d < 0) d += 4;
            snake[head.first][head.second] = d+1;
        }
        else{
            d += 1;
            if(d >= 4) d %= 4;
            snake[head.first][head.second] = d+1;
        }
    }

    cout  << cnt << '\n';

    return 0;
}