#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//두 포인터 + 라인스위핑 + 완탐 문제 같음.
//+ 비트마스킹
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    vector<int> v;
    
    //case 입력
    cin >> n;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        v.push_back(a);
    }

    //n이 2 이하면 n이 정답
    if(n <= 2){
        cout << n << '\n';
        return 0;
    }

    // 0 1 2 3 4 5
    // 1 1 2 2 2 5

    //두 포인터
    int left = 0;
    int right = 1;
    //kind <= 2를 유지하기 위해!! 필요함!
    int next_left = 0;
    // 두 종류의 과일이 있는지 확인하기 위한 배열
    int check = 0;
    int ret = 1; //ret : 초기는 최소의 값인 1로 시작
    int kind = 1; //과일 종류의 갯수
    
    //right 가 n과 같아질 때 까지 반복
    //left와 right 사이의 과일의 종류가 2개 이하면 right++
    //left와 right 사이의 과일의 종류가 2개 초과면 left++
    //while문 조건으로 right만 있는 이유는 left와 right의 차이가 1이면 무조건 2개 이하의 종류의 과일임.
    
    //check에 미리 초반 정보 넣기;
    check |= (1 << v[left]);

    //요 안에 로직이 조금 매우 많이 디스커스팅하면서 어렵다..
    while(right < n){
        //kind가 1이면
        if(kind == 1){
            //check 배열에 v[right] 과일이 0이면
            if(!(check & (1 << v[right]))){
                //check[v[right]] +1 + 과일의 종류 + 1
                check |= (1 << v[right]);
                kind++;
            }
            // 0이 아니면
        }
        //여긴 kind의 수가 2개 이상일 때부터 실행된다.
        //즉, check 배열의 v[right] 가 0이면 kind는 3종류가 된다.
        //next_left가 필요한 이유는 kind가 1로 만들어서 v[right]에 있는 과일을 넣어도 kind가 2종류로 만들기 위함이다.
        else{
            //check 배열에 v[right] 과일이 0이면
            if(!(check & (1 << v[right]))) {
                //정답 계산
                ret = max(ret, right - left);
                //9가지 종류의 과일들 중에 true 값이면서 i 가 next_left와 다른 것을 찾고
                //거기까지 제거
                check = 0;
                check |= (1 << v[next_left]);
                check |= (1 << v[right]);
                left = next_left;
            }
        }
        //두 자리의 과일이 다르면 어디까지 제거할지 결정!
        if(v[right - 1] != v[right]){
            next_left = right;
        }
        right++;
    }

    ret = max(ret, n - left);

    cout << ret << '\n';

    return 0;
}