#include <iostream>

using namespace std;

int main(int argc, char* argv[]){
  int T, A, B, i;

  cin >> T;
  for(i = 1; i <= T; i++){
    cin >> A >> B;
    cout << "Case #" << i << ": " << A+B<< '\n';
  }

  return 0;
}