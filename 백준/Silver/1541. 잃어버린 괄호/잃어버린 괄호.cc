#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    vector<int> num;
    vector<char> oper;
    string s;
    cin >> s;
    int sum = 0;
    for(char i : s){
        if(i >= '0' && i <= '9'){
            sum = sum * 10 + (i - '0');
        }
        else{
            num.push_back(sum);
            oper.push_back(i);
            sum = 0;
        }
    }
    num.push_back(sum);

    int i = 0;
    while(i != oper.size()){
        // cout << num[0] << '\n';
        if(oper[i] == '+'){
            num[i] += num[i+1];
            num.erase(num.begin() + i + 1);
            oper.erase(oper.begin() + i);
        }
        else i++;
    }

    // cout << oper.size() - i << '\n';
    sum = num[0];
    if(oper.size()){
        for(int i = 1; i < num.size(); i++){
            sum -= num[i];
        }
    }
    cout << sum << '\n';

    return 0;
}