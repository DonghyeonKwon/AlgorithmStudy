#include <bits/stdc++.h>
using namespace std;

bool visited[10001] = {true, };

void d(){
    for(int i = 1; i <= 10000; i++){
        string str = to_string(i);
        int sum = i;
        for(char c : str) sum += (c - '0');
        visited[sum] = false;
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    fill(visited, visited + 10001, true);
    d();
    for(int i = 1; i <= 10000; i++) {
        if(visited[i]) cout << i << '\n';
    }

    return 0;
}