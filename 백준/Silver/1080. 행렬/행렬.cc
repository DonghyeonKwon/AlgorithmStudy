#include <bits/stdc++.h>
using namespace std;

int n, m, cnt = 0, a[51][51], b[51][51];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    scanf("%d %d", &n, &m);
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            scanf("%1d", &a[i][j]);
        }
    }
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            scanf("%1d", &b[i][j]);
        }
    }
    // if(n < 3 || m < 3){
    //     printf("-1\n");
    //     return 0;
    // }

    for(int i = 1; i <= n-2; i++){
        for(int j = 1; j <= m-2; j++){
            if(a[i][j] != b[i][j]){
                for(int x = i; x < i+3; x++){
                    for(int y = j; y < j+3; y++){
                        if(a[x][y] == 1) a[x][y] = 0;
                        else a[x][y] = 1;
                    }
                }
                cnt++;
            }
        }
        // if(a[i][m-1] != b[i][m-1] || a[i][m] != b[i][m]){
        //     printf("-1\n");
        //     return 0;
        // }
    }
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            if(a[i][j] != b[i][j]){
                printf("-1\n");
                return 0;
            }
        }
    }

    printf("%d\n", cnt);

    return 0;
}