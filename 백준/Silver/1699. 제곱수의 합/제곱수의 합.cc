#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
int n;
int num[100001];

int go(int s, int idx){
   int _min = 987654321;
    //i 는 idx 부터 1 까지 반복
    //a 는 i의 제곱한 수
    //a 번째의 배열은 항상 1
    //위 1 과 배열 (s - a)번째 수의 합의 최소치를 계산 후 리턴
   for(int i = idx; i >= 1; i--){
        int a = pow(i, 2);
        _min = min(_min, num[a] + num[s - a]);
   }
   return _min;
}

void init(){
    num[0] = 1;
    //1부터 100000 까지 제곱수 계산
    for(int i = 1; i <= 100000; i++){
        int a = floor(sqrt(i)); // 해당 수의 제곱근 소수점 첫 번째자리에서 내림
        //num[i] 는 이전 수 + 1 와 go 함수와 비교
        num[i] = min(num[i-1] + 1, go(i,a));
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
 
    init(); // 초기화
    cin >> n;
    cout << num[n] << '\n';

    return 0;
}