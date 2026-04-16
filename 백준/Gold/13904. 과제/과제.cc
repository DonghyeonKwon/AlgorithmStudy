#include <bits/stdc++.h>
using namespace std;

struct homework{
    int d, c;
};

bool cmp(homework a, homework b){
    return a.c > b.c;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> arr(1001, 0);
    vector<homework> v;

    for(int i = 0; i < n; i++){
        int d, cost;
        cin >> d >> cost;
        v.push_back({d, cost});
    }

    sort(v.begin(), v.end(), cmp);

    for(homework it : v){
        for(int j = it.d; j >= 1; j--){
            if(arr[j] == 0){
                arr[j] = it.c;
                break;
            }
        }
    }

    int ret = 0;
    for(int i = 1; i <= 1000; i++) ret += arr[i];
    cout << ret << '\n';

    return 0;
}