#include <bits/stdc++.h>
using namespace std;

vector<int> v, ret;

int searchV(int start, int end, int t){
    while(start <= end){
        int mid = (start + end) / 2;
        if(v[mid] > t){
            end = mid - 1;
        }
        else if(v[mid] == t){
            return 1;
        }
        else if(v[mid] < t){
            start = mid + 1;
        }
    }

    return 0;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m, a;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a;
        v.push_back(a);
    }
    sort(v.begin(), v.end());

    cin >> m;
    for(int i = 0; i < m; i++){
        cin >> a;
        ret.push_back(searchV(0, n-1, a));
    }
    for(int i : ret){
        cout << i << ' ';
    }
    cout << '\n';

    return 0;
}