#include <iostream>

using namespace std;

int main(int argc, char* argv[]){
  ios_base::sync_with_stdio(false); cin.tie(NULL);
  int i, N;

  cin >> N;
  for(i = N; i >= 1; i--)
    cout << i << '\n';

  return 0;
}