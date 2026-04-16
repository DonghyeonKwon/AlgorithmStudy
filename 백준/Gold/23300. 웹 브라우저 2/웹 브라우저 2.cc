#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;

int n, q, x = -1;
char c;
deque<int> backD, frontD;

void compress(deque<int> &d){
    deque<int> temp;
    int t = -1;
    while(d.size()){
        if(t == -1){
            t = d.front();
            d.pop_front();
            continue;
        }
        if(t == d.front()) d.pop_front();
        else{
            temp.push_back(t);
            t = -1;
        }
    }
    temp.push_back(t);
    d = temp;
}

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    cin >> n >> q;
    while(q--){
        cin >> c;
        if(c == 'A'){
            if(x != -1) backD.push_back(x);
            if(!frontD.empty()) frontD.clear();
            cin >> x;
        }
        else if(c == 'B'){
            if(!backD.empty()){
                frontD.push_front(x);
                x = backD.back();
                backD.pop_back();
            }
        }
        else if(c == 'F'){
            if(!frontD.empty()){
                backD.push_back(x);
                x = frontD.front();
                frontD.pop_front();
            }
        }
        else if(c == 'C'){
            if(backD.empty()) continue; 
            deque<int> temp;
            int t = backD.front();
            backD.pop_front();
            while(backD.size()){
                if(t == backD.front()) backD.pop_front();
                else{
                    temp.push_back(t);
                    t = backD.front();
                    backD.pop_front();
                }
            }
            temp.push_back(t);
            backD = temp;
        }
    }

    cout << x << '\n';
    if(backD.empty()) cout << -1 << '\n';
    else{
        while(backD.size()){
            cout << backD.back() << ' ';
            backD.pop_back();
        }
        cout << '\n';
    }
    if(frontD.empty()) cout << -1 << '\n';
    else{
        while(frontD.size()){
            cout << frontD.front() << ' ';
            frontD.pop_front();
        }
        cout << '\n';
    }

    return 0;
}