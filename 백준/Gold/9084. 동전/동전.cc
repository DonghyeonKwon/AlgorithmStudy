#include <iostream>
#include <vector>
using namespace std;
int t, n;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> t;
    while(t--){
        cin >> n;
        vector<int> coin;
        for(int i = 0; i < n; i++){
            int a;
            cin >> a;
            coin.push_back(a);
        }

        int s;
        cin >> s;
        vector<vector<int>> ret(n+1, vector<int>(s+1, 0));

        for(int i = 1; i <= n; i++){
            ret[i][0] = 1;
            for(int j = 1; j <= s; j++){
                if(j - coin[i-1] < 0) {
                    ret[i][j] = ret[i-1][j];
                    continue;
                }
                ret[i][j] = ret[i-1][j] + ret[i][j - coin[i-1]];
            }
        }

        cout << ret[n][s] << '\n';
    }

    return 0;
}