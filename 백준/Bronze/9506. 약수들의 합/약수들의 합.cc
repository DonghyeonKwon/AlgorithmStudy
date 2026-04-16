#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    while(1){
        int a, ret = 0;
        vector<int> v;
        cin >> a;
        if(a == -1) break;
        for(int i = 1; i < a; i++){
            if(a%i == 0){
                ret += i;
                v.push_back(i);
            }
        }
        if(a == ret){
            cout << a << " = ";
            int i;
            for(i = 0; i < v.size()-1; i++)
                cout << v[i] << " + ";
            cout << v[i] << '\n';
        }
        else{
            cout << a << " is NOT perfect.\n";
        }
    }
    return 0;
}