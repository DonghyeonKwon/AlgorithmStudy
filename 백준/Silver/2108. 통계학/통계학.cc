#include <bits/stdc++.h>

using namespace std;

int n, _min = 4001, _max = -4001;
double sum = 0.0;
vector<int> v;
int arr[8001];
map<int, int> mp;

bool comp(pair<int, int> &a, pair<int, int> &b){
    return (a.first < b.first || a.second > b.second);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        v.push_back(a);
        sum += (double)a;
        _min = min(_min, a);
        _max = max(_max, a);
        arr[a+4000]++;
    }
    sort(v.begin(), v.end());
    double mean = round(sum / (double)n);
    int mid = v[(n-1)/2];
    int qnum, cnt_max = 0;
    bool first_num = false;
    for(int i = 0; i < 8001; i++){
        if(arr[i] == 0) continue;
        if(cnt_max < arr[i]){
            cnt_max = arr[i];
            first_num = true;
            qnum = i - 4000;
        }
        else if(cnt_max == arr[i]){
            if(first_num){
                qnum = i - 4000;
                first_num = false;
            }
        }
    }

    int range = _max - _min;
    cout << (mean == -0 ? 0 : mean) << '\n';
    cout << mid << '\n';
    cout << qnum << '\n';
    cout << range << '\n';
    return 0;
}