#include <iostream>

using namespace std;

int main(int argc, char* argv[]){
  int h, m;

  cin >> h >> m;

  m -= 45;

  if(m >= 60){
    h++;
    m -= 60;
  }
  else if(m < 0){
    h--;
    m = 60 + m;
  }
  if(h >= 24)
    h -= 24;
  else if(h < 0)
    h = 24 + h;
  cout << h << ' ' <<  m <<endl;

  return 0;
}