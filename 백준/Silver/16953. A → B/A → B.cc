#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int ans = -1;

void bfs(int a, int b){
    queue<pair<ll, ll>> q;
    q.push(make_pair(a, 1));
    while(!q.empty()){
        ll c = q.front().first;
        ll prec = q.front().second;
        q.pop();
        if(c == b) {
            ans = prec;
            break;
        }
        if(2*c <= b)
            q.push(make_pair(2*c, prec+1));
        if(10*c + 1 <= b)
            q.push(make_pair(10*c + 1, prec+1));
    }
}

int main(int argc, char* argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a, b;

    cin >> a >> b;

    bfs(a,b);

    cout << ans << '\n';

    return 0;
}