#include <stdio.h>
#include <stdlib.h>

#define M 1234567891

int len = 0;

int main(int argc, char* argv[]){
  scanf("%d", &len);

  char word[len];
  scanf("%s", word);

  long long sum = 0;
  long long r = 1;

  for(int i = 0; i < len; i++){
    sum = (sum + (word[i] - 96)*r) % M;
    r = (r*31)%M;
  }

  printf("%lld\n", sum);

  return 0;
}