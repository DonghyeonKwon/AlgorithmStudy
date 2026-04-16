#include <bits/stdc++.h>

using namespace std;

int n, k;
int visited[100001];
int pren[100001];
vector<int> a;

void go(int here){
    queue<int> q;
    q.push(here);
    visited[here] = 1;
    while(!q.empty()){
        int now = q.front();
        q.pop();
        if(now == k)break;
        for(int next : {now + 1, now - 1, now * 2}){
            if(0 > next || next >= 100001 || visited[next])continue;
            q.push(next);
            visited[next] = visited[now] + 1;
            pren[next] = now;
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> k;

    go(n);

    for(int i = k; i != n; i = pren[i]){
        a.push_back(i);
    }
    a.push_back(n);

    reverse(a.begin(), a.end());

    cout << visited[k] - 1 << '\n';
    for(int i : a){
        cout << i << ' ';
    }cout << '\n';

    return 0;
}