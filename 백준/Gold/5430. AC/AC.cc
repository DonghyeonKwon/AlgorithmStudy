#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t;
    cin >> t;
    for(int i = 0; i < t; i++){
        string s, arr;
        bool flag = false, rev = false;
        int n;
        cin >> s;
        cin >> n;
        cin >> arr;
        deque<int> v;

        int a = 0;
        for(char c : arr){
            if(c == '[' || c == ']') continue;
            if(c >= '0' && c <= '9') a = a * 10 + c - '0';
            else{
                if(a > 0) v.push_back(a);
                a = 0;
            }
        }
        if(a > 0) v.push_back(a);

        for(int j = 0; j < s.size(); j++){
            if(s[j] == 'D'){
                if(v.empty()){
                    flag = true;
                    break;
                }
                if(rev) v.pop_back();
                else v.pop_front();
            }
            else{
                if(rev) rev = false;
                else rev = true;
            }
        }
        if(flag){
            cout << "error\n";
            continue;
        }
        
        if(rev) reverse(v.begin(), v.end());
        cout << "[";
        for(int i = 0 ; i < v.size(); i++){
            cout << v[i];
            if(i < v.size() - 1) cout << ",";
        }
        cout << "]\n";
    }

    return 0;
}