#include <bits/stdc++.h>
using namespace std;

int mp[34], score[34], turn[34] = {0, };
int price[4] = {0, 0, 0, 0}, dice[10], _max = -1;
bool check[34] = { false, };

void dfs(int cnt, int sum){
    if(cnt == 10) {
        _max = max(_max, sum);
        // cout << _max << '\n';
        return;
    }

    for(int i = 0; i < 4; i++){
        int prev = price[i];
        int cur = prev;
        int move = dice[cnt];

        if(turn[cur] > 0){
            cur = turn[cur];
            move--;
        }

        while(move--) cur = mp[cur];

        if(cur != 21 && check[cur]) continue;

        check[prev] = false;
        check[cur] = true;
        price[i] = cur;

        dfs(cnt+1, sum+score[cur]);

        price[i] = prev;
        check[prev] = true;
        check[cur] = false;     
    }
}

void init(){
    for(int i = 0; i < 21; i++) mp[i] = i+1;
    mp[21] = 21;
    for(int i = 22; i < 32; i++) mp[i] = i+1;
    mp[27] = 20; mp[30] = 25; mp[32] = 25; 

    turn[5] = 22; turn[10] = 31; turn[15] = 28;

    for(int i = 0; i <= 20; i++) score[i] = i*2;
    score[21] = 0; score[22] = 13; score[23] = 16;
    score[25] = 25; score[26] = 30; score[27] = 35;
    score[28] = 28; score[29] = 27; score[30] = 26;
    score[31] = 22; score[32] = 24; score[24] = 19;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    init();

    for(int i = 0; i < 10; i++) cin >> dice[i];
    dfs(0, 0);

    cout << _max << '\n';

    return 0;
}