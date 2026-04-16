#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<string> v;
    for(int i = 0; i < n; i++){
        string str;
        cin >> str;
        v.push_back(str);
    }

    int count = n;
    for(string str : v){
        int a[26] = {0,};
        a[str[0] - 'a']++;
        char pre = str[0];
        for(int j = 1; j < str.length(); j++){
            if(pre == str[j]){
                a[str[j] - 'a']++;
            }
            else{
                if(a[str[j] - 'a'] > 0) {
                    count--;
                    break;
                }
                else{
                    pre = str[j];
                    a[str[j] - 'a']++;
                }
            }
        }
    }

    cout << count << '\n';

    return 0;
}