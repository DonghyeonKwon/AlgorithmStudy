#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

string temp = "";

void go(string s, string r){
    if(s == r){
        cout << 1 << '\n';
        exit(0);
    }
    if(s.size() >= r.size()) return;
    if(r.back() == 'A'){
        temp = r;
        temp.pop_back();
        go(s, temp);
    }
    if(r.front() == 'B'){
        temp = r;
        reverse(temp.begin(), temp.end());
        temp.pop_back();
        go(s, temp);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string input, ret;
    cin >> input >> ret;
    go(input, ret);

    cout << 0 << '\n';

    return 0;
}