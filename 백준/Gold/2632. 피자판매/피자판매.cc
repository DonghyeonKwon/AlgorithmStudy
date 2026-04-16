#include <bits/stdc++.h>
using namespace std;

int n, a, b, cnt = 0;
int A[1001] = {0,}, B[1001] = {0, };
int psumA[2001] = {0, }, psumB[2001] = {0, };
map<int,int> mp1, mp2;
void make(int t, int psum[], map<int,int> &mp){
    for(int interval = 1; interval <= t; interval++){
        for(int start = interval; start <= t + interval - 1; start++){
            int sum = psum[start] - psum[start - interval];
            mp[sum]++;
            if(interval == t) break;
        }
    }
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    cin >> a >> b;

    for(int i = 1; i <= a; i++){
        cin >> A[i];
        psumA[i] = psumA[i-1] + A[i];
    }
    for(int i = a + 1; i <= 2*a; i++) psumA[i] = psumA[i-1] + A[i-a]; 

    for(int i = 1; i <= b; i++){
        cin >> B[i];
        psumB[i] = psumB[i-1] + B[i];
    }
    for(int i = b + 1; i <= 2*b; i++) psumB[i] = psumB[i-1] + B[i-b];

    make(a, psumA, mp1);
    make(b, psumB, mp2);
    cnt = (mp1[n] + mp2[n]);
    
    for(int i = 1; i < n; i++){     
        cnt += (mp1[i] * mp2[n-i]);
    }
    cout << cnt << '\n';

    return 0;
}