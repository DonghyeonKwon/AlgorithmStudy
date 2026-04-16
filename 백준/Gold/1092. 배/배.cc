#include <bits/stdc++.h>
using namespace std;

int n, m, cnt = 0;
vector<int> crane, box;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        crane.push_back(a);
    }
    cin >> m;
    for(int i = 0; i < m; i++){
        int a;
        cin >> a;
        box.push_back(a);
    }
    sort(crane.begin(), crane.end());
    sort(box.begin(), box.end());
    if(crane.back() < box.back()){
        cout << -1 << '\n';
        return 0;
    }
    while(box.size()){
        cnt++;
        for(int i = n-1; i >= 0; i--){
            for(int j = box.size() - 1; j >= 0; j--){
                if(crane[i] >= box[j]){
                    box.erase(box.begin() + j);
                    break;
                }
            }
        }
    }
    cout << cnt << '\n';

    return 0;
}