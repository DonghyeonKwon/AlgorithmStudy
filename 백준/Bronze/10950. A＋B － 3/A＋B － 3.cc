#include <iostream>

using namespace std;

int main(int argc, char* argv[]){
  int i, T, A, B;

  cin >> T;
  for(i = 0; i < T; i++){
    cin >> A >> B;
    cout << A+B << endl;
  }

  return 0;
}