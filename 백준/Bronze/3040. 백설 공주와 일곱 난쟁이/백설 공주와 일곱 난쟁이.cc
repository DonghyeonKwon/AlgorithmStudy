#include <iostream>
#include <vector>
using namespace std;

int arr[9];
vector<int> ret;

void go(int idx, int sum, int cnt){
    if(cnt == 7){
        if(sum != 100) return;
        for(int i : ret) cout << i << '\n';
        exit(0);
    }

    for(int i = idx; i < 9; i++){
        ret.push_back(arr[i]);
        go(i + 1, sum + arr[i], cnt + 1);
        ret.pop_back();
    }
}


int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    for(int i = 0; i < 9; i++){
        cin >> arr[i];
    }

    go(0, 0, 0);

    return 0;
}