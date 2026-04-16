#include <iostream>

using namespace std;

int main(int argc, char* argv[]){
  int i, N;

  cin >> N;

  for(i = 1; i <= 9; i++)
    cout << N <<" * "<< i <<" = "<< N*i << endl;

  return 0;
}