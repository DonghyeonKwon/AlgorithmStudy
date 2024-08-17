#include <bits/stdc++.h>
using namespace std;

int n, alpha[26], num = 9, sum = 0;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    string s;
    
    for(int i = 0; i < n; i++){
        cin >> s;
        for(int j = s.length() - 1; j >= 0; j--){
            int a = s[j] - 'A';
            alpha[a] += pow(10, (s.length() - j - 1));
        }
    }
    
    sort(alpha, alpha + 26, greater<>());
    for(int i = 0; i < 26; i++){
        if(alpha[i] == 0 || num < 0) break;
        sum += alpha[i] * num;
        num--;
    }

    cout << sum << '\n';

    return 0;
}