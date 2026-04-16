#include <bits/stdc++.h>
using namespace std;
int n;
string v[20000];
bool comp(string a, string b){
    if(a.length() == b.length()){
        return(a < b);
    }
    return (a.length() < b.length()); 
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;

    for(int i = 0; i < n; i++){
        cin >> v[i];
    }
    
    sort(v, v + n, comp);

    cout << v[0] << '\n';
    for(int i = 1; i < n; i++){
        if(v[i-1] != v[i]){
            cout << v[i] << '\n';
        }
    }

    return 0;
}