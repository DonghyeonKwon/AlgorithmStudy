#include <bits/stdc++.h>
using namespace std;
int n;
vector<string> v;
bool comp(string a, string b){
    // if(a == "0") return true;
    string at = a+b;
    string bt = b+a;
    return at > bt;
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    while(n--){
        string s;
        cin >> s;
        v.push_back(s);
    }

    sort(v.begin(), v.end(), comp);

    if(v[0] == "0"){
        cout << v[0] << '\n';
        return 0;
    }
    for(string s : v){
        cout << s;
    }cout << '\n';

    return 0;
}