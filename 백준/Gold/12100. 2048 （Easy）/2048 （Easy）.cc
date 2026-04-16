#include <bits/stdc++.h>
using namespace std;

int n, a[21][21], mxN = -1;

void swift(int i){
    queue<int> q;
    switch(i){
        //right
        case 0:
            for(int y = 0; y < n; y++){
                for(int x = n-1; x >= 0; x--){
                    if(a[y][x] != 0) {
                        q.push(a[y][x]);
                        a[y][x] = 0;
                    }
                }
                int x = n-1;
                while(q.size()){
                    int data = q.front();
                    q.pop();
                    if(a[y][x] == 0){
                        a[y][x] = data;
                    }
                    else if(a[y][x] == data){
                        a[y][x] *= 2;
                        x--;
                    }
                    else{
                        x--;
                        a[y][x] = data;
                    }
                }
            }
            break;
        //left
        case 1:
            for(int y = 0; y < n; y++){
                for(int x = 0; x < n; x++){
                    if(a[y][x] != 0) {
                        q.push(a[y][x]);
                        a[y][x] = 0;
                    }
                }
                int x = 0;
                while(q.size()){
                    int data = q.front();
                    q.pop();
                    if(a[y][x] == 0){
                        a[y][x] = data;
                    }
                    else if(a[y][x] == data){
                        a[y][x] *= 2;
                        x++;
                    }
                    else{
                        x++;
                        a[y][x] = data;
                    }
                }
            }
            break;

        //up
        case 2:
            for(int x = 0; x < n; x++){
                for(int y = 0; y < n; y++){
                    if(a[y][x] != 0) {
                        q.push(a[y][x]);
                        a[y][x] = 0;
                    }
                }
                int y = 0;
                while(q.size()){
                    int data = q.front();
                    q.pop();
                    if(a[y][x] == 0){
                        a[y][x] = data;
                    }
                    else if(a[y][x] == data){
                        a[y][x] *= 2;
                        y++;
                    }
                    else{
                        y++;
                        a[y][x] = data;
                    }
                }
            }
            break;

        //down
        case 3:
            for(int x = 0; x < n; x++){
                for(int y = n-1; y >= 0; y--){
                    if(a[y][x] != 0) {
                        q.push(a[y][x]);
                        a[y][x] = 0;
                    }
                }
                int y = n-1;
                while(q.size()){
                    int data = q.front();
                    q.pop();
                    if(a[y][x] == 0){
                        a[y][x] = data;
                    }
                    else if(a[y][x] == data){
                        a[y][x] *= 2;
                        y--;
                    }
                    else{
                        y--;
                        a[y][x] = data;
                    }
                }
            }

            break;
    }
}

void go(int cnt){
    if(cnt == 5) return;
    int new_a[21][21];

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            new_a[i][j] = a[i][j];
        }
    }

    for(int i = 0; i < 4; i++){
        swift(i);
        // for(int y = 0; y < n; y++){
        //     for(int x = 0; x < n; x++){
        //         cout << a[y][x] << ' ';
        //     }
        //     cout << '\n';
        // }
        // cout << '\n';

        for(int y = 0; y < n; y++){
            for(int x = 0; x < n; x++){
                if(a[y][x] > mxN) mxN = a[y][x];
            }
        }

        go(cnt+1);

        for(int y = 0; y < n; y++){
            for(int x = 0; x < n; x++){
                a[y][x] = new_a[y][x];
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    // cout << '\n';
    go(0);

    cout << mxN << '\n';

    return 0;
}