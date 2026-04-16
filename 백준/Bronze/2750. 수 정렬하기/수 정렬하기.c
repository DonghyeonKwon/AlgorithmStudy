#include <stdio.h>

int main(int argc, char* argv[]){
  int ea, i, j, key;
  scanf("%d", &ea);

  int arr[ea];
  for(i = 0; i < ea; i++)
    scanf("%d", &arr[i]);

  for(i = 1; i < ea; i++){
    key = arr[i];
    for(j = i-1; j >= 0 && arr[j] > key; j--)
      arr[j+1] = arr[j];
    arr[j+1] = key;
  }

  for(i = 0; i < ea; i++)
    printf("%d\n", arr[i]);
  
  return 0;
}