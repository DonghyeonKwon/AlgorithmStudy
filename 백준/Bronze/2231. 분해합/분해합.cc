#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string n;
    cin >> n;
    int num, diff;
    num = stoi(n);
    diff = n.length() * 9;

    for(int i = num - diff; i < num; i++){
        string s = to_string(i);
        int sum = i;
        for(int j = 0; j < s.length(); j++){
            sum += (s[j] - '0');
        }
        if(num == sum){
            cout << i << '\n';
            return 0;
        }
    }
    cout << 0 << '\n';

    return 0;
}