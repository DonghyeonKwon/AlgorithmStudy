#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;

int n, m, cnt = 0;
deque<int> dq;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    for(int i = 1; i <= n; i++){
        dq.push_back(i);
    }

    while(m--){
        int a;
        cin >> a;
        
        // cout << cnt << '\n';

        int f_cnt = 0, b_cnt = 0;
        for(int i = 0; i < dq.size(); i++){
            if(dq[i] == a){
                f_cnt = i;
                b_cnt = dq.size() - i;
                break;
            }
        }

        if(f_cnt <= b_cnt){
            while(1){
                if(dq.front() == a){
                    dq.pop_front();
                    break;
                }

                dq.push_back(dq.front());
                dq.pop_front();
                cnt++;
            }
        }
        else{
            cnt++;
            while(1){
                if(dq.back() == a){
                    dq.pop_back();
                    break;
                }

                dq.push_front(dq.back());
                dq.pop_back();
                cnt++;
            }
        }
    }

    cout << cnt << '\n';

    return 0;
}