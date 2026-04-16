#include <bits/stdc++.h>
using namespace std;

int main(int argc, char** argv){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, k;
    string input, ret = "";
    //입력
    cin >> n >> k;
    cin >> input;
    //input[0 ~ n-1] 까지 반복
    for(int i = 0; i < n; i++){
        if(ret.empty()) ret.push_back(input[i]); //ret이 비었으면 input[i] push;
        else{//ret.size() > 0이면
            //ret이 빈 것이 아니고 input[i] > ret.back() 이고 k가 양수면 반복
            while(!ret.empty() && input[i] > ret.back() && k){
                k--;
                ret.pop_back();
            }
            //반복이 끝나면 ret.back()는 없거나 input[i] 값보다 크거나 작은 경우이다.
            ret.push_back (input[i]);
        }
    }
    //k 가 양수이면 0이 될 때까지 pop
    while(k--) ret.pop_back();
    cout << ret << '\n';

    return 0;
}