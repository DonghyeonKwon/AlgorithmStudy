#include <bits/stdc++.h>
using namespace std;

int n, ret = 0;
bool visited[42] = {false, };

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    for(int i = 0; i < 10; i++){
        cin >> n;
        int a = n % 42;
        if(!visited[a]){
            ret++;
            visited[a] = true;
        }
    }

    cout << ret << '\n';
    
    return 0;
}