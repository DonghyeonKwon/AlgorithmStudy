#include <bits/stdc++.h>

using namespace std;

bool compare(const pair<int, int> &a, const pair<int, int> &b){
    return a.second > b.second;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string str;
    cin >> str;

    int count[27] = {0, };
    
    for(int i = 0; i < str.length(); i++){
        if(str[i] < 'a'){
            count[str[i] - 'A']++;
        }
        else{
            count[str[i] - 'a']++;
        }
    }

    int max = 0;
    char se = 0;
    int dis = 0;

    for(int i = 0; i <= 'Z' - 'A'; i++){
        if(max < count[i]){
            se = i;
            max = count[i];
        }
    }

    for(int i = 0; i <= 'Z' - 'A'; i++){
        if(max == count[i]) dis++;
    }

    if(dis > 1){
        cout << "?\n";
    }
    else{
        cout << (char)(se + 'A') << '\n';
    }

    return 0;
}