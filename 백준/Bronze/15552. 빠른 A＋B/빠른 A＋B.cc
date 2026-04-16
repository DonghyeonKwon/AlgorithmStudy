#include <iostream>

using namespace std;

int main(int argc, char* argv[]){
  int i, T, A, B;

  ios_base::sync_with_stdio(false); cin.tie(NULL);

  cin >> T;
  for(i = 0; i < T; i++){
    cin >> A >> B;
    cout << A+B << '\n';
  }

  return 0;
}