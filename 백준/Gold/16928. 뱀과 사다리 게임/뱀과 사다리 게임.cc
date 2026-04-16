#include <iostream>
#include <queue>
#include <tuple>
using namespace std;

int n, m, cnt = 987654321;
int a[101] = {0, };
bool visited[101] = {false, };

void go(int here, int c){
    queue<pair<int, int>> q;
    q.push({here, c});
    visited[here] = true;

    while(q.size()){
        tie(here, c) = q.front();
        q.pop();

        if(here == 100){
            cout << c << '\n';
            return;
        }

        for(int i = 6; i >= 1; i--){
            int nh = here + i;
            if(nh > 100) continue;
            if(a[nh] > 0){
                nh = a[nh];
            }
            if(!visited[nh]){
                q.push({nh, c + 1});
                visited[nh] = true;
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    while(n--){
        int i, j;
        cin >> i >> j;
        a[i] = j;
    }
    while(m--){
        int i, j;
        cin >> i >> j;
        a[i] = j;
    }

    go(1, 0);

    return 0;
}