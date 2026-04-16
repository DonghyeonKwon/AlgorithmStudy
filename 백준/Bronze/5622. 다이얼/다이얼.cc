#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string s;
    cin >> s;
    int sum = 0;
    for(int i = 0; i < s.length(); i++){
        int a = s[i] - 'A';
        switch(a){
            case 0: case 1: case 2: sum += 3; break;
            case 3: case 4: case 5: sum += 4; break;
            case 6: case 7: case 8: sum += 5; break;
            case 9: case 10: case 11: sum += 6; break;
            case 12: case 13: case 14: sum += 7; break;
            case 15: case 16: case 17: case 18: sum += 8; break;
            case 19: case 20: case 21: sum += 9; break;
            case 22: case 23: case 24: case 25: sum += 10; break;
        }
    }

    cout << sum << '\n';

    return 0;
}