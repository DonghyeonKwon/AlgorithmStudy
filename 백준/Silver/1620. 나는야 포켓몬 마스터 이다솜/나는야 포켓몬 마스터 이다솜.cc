#include <bits/stdc++.h>

using namespace std;

map<int, string> mp1;
map<string, int> mp2;

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
    
    int n, m;

    cin >> n >> m;

    for(int i = 1; i <= n; i++){
        string s;
        cin >> s;

        mp1[i] = s;
        mp2[s] = i;
    }

    for(int i = 0; i < m; i++){
        string s;
        cin >> s;
        
        if(isalpha(s[0])){
            cout << mp2[s] << '\n';
        }
        else{
            int a = stoi(s);
            cout << mp1[a] << '\n';
        }
    }

    return 0;
}