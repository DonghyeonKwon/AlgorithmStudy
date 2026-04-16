#include <iostream>

using namespace std;

int main(int argc, char* argv[]){
  int k, sum = 0, i = 1;

  cin >> k;
  for(i = 1; i <= k; i++)
    sum += i;

  cout << sum;

  return 0;
}