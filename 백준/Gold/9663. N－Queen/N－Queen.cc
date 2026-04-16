#include <bits/stdc++.h>
using namespace std;

int n;
int visited[16];
int ret = 0;

bool queenCheck(int x){
    for(int i = 0; i < x; i++){
        if(visited[i] == visited[x] || abs(visited[x] - visited[i]) == x - i) 
            return false;
    }
    return true;
}

void go(int idx){
    if(idx == n){
        ret++;
        return;
    }

    for(int i = 0; i < n; i++){
        visited[idx] = i;
        if(queenCheck(idx)){
            go(idx + 1);
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;

    fill(visited, visited + 16, 0);

    if(n == 1){
        cout << 1 << '\n';
        return 0;
    }
    if(n == 2 || n == 3){
        cout << 0 << '\n';
        return 0;
    }
    
    go(0);

    cout << ret << '\n';


    return 0;
}