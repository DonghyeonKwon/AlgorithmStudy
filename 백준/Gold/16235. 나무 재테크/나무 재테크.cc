#include <bits/stdc++.h>
using namespace std;

int n, m, k, mp[11][11], A[11][11];
const int dy[] = {-1, -1, -1, 0, 0, 1, 1, 1};
const int dx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
vector<int> vt[10][10];
int dead[10][10], bunsik[10][10];

bool check(int y, int x){
    return (0 <= y && y < n && 0 <= x && x < n);
}

void spring(){
    vector<int> temp[10][10];
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(vt[i][j].size()){
                sort(vt[i][j].begin(), vt[i][j].end());
                for(int k = 0; k < vt[i][j].size(); k++){
                    if(vt[i][j][k] <= mp[i][j]){
                        mp[i][j] -= vt[i][j][k];
                        temp[i][j].push_back(vt[i][j][k] + 1);
                        if((vt[i][j][k] + 1) % 5 == 0) bunsik[i][j]++;
                    }
                    else{
                        dead[i][j] += vt[i][j][k]/2;
                        m--;
                    }
                }
            }
        }
    }
    swap(vt,temp);
}

void summer(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            mp[i][j] += dead[i][j];
        }
    }
}

void automn(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(bunsik[i][j] > 0){
                for(int d = 0; d < 8; d++){
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if(check(ny,nx)){
                        int a = bunsik[i][j];
                        while(a--) {
                            vt[ny][nx].push_back(1);
                            m++;
                        }
                    }
                }
            }
        }
    }
}

void winter(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            mp[i][j] += A[i][j];
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m >> k;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> A[i][j];
            mp[i][j] = 5;
        }
    }

    for(int i = 0; i < m; i++){
        int y, x, age;
        cin >> y >> x >> age;
        vt[y-1][x-1].push_back(age);
    }

    
    while(k--){
        //spring
        fill(&dead[0][0], &dead[0][0] + (10 * 10), 0);
        fill(&bunsik[0][0], &bunsik[0][0] + (10 * 10), 0);
        spring();
        
        //summer
        summer();
        
        //automn
        automn();

        //winter
        winter();
    }

    cout << m << '\n';

    return 0;
}