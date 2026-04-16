#include <bits/stdc++.h>
using namespace std;

int t, a, b;
vector<int> k1, k2;

void init(){
    k1.push_back(0);
    k2.push_back(0);
    for(int i = 1; i <= 6; i++){
        for(int j = 0; j < i; j++){
            if(i == 1) k1.push_back(500);
            else if(i == 2) k1.push_back(300);
            else if(i == 3) k1.push_back(200);
            else if(i == 4) k1.push_back(50);
            else if(i == 5) k1.push_back(30);
            else if(i == 6) k1.push_back(10);
            // cout << "k1 " << temp-1 << ' ' << k1[temp-1] << '\n';
        }
    }
    int k = 512;
    for(int i = 0; i < 5; i++){
        for(int j = 0; j < (1 << i); j++){
            k2.push_back(k);
            // cout << "k2 " << temp -1 << ' ' << k2[temp -1] << '\n';
        }
        k = k >> 1;
    }
    
}

int main(int argc, char** argv){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    init();
    vector<int> v;
    cin >> t;
    while(t--){
        cin >> a >> b;
        int sum = 0;
        if(a <= 21) sum += k1[a];
        if(b <= 31) sum += k2[b];
        v.push_back(sum * 10000);
    }

    for(int i : v) cout << i << '\n';

    return 0;
}