#include <stdio.h>
#include <stdlib.h>

#define MAX 100000

int N;
int count = 0;
int sorted[MAX];
int tf[MAX];

void marge_sort(int list[], int left, int right);
void marge(int list[], int left, int mid, int right);
void searchList(int list[], int left, int right, int key);

int main(int argc, char* argv[]){
  int i, n, a;
  scanf("%d", &N);
  int list[N];
  for(i = 0; i < N; i++)
    scanf("%d", &list[i]);
  marge_sort(list, 0, N-1);
    
  scanf("%d", &n);
  for(i = 0; i < n; i++){
    scanf("%d", &a);
    searchList(list, 0, N-1, a);
  }
  for(i = 0; i <n; i++)
    printf("%d\n", tf[i]);

  return 0;
}

void marge(int list[], int left, int mid, int right){
  int i, j, k, l;
  i = left; j = mid+1; k = left;
  while(i<=mid && j <= right){
    if(list[i] <= list[j]) sorted[k++] = list[i++];
    else sorted[k++] = list[j++];
  }
  if(i > mid)
    for(l = j; l<=right; l++)
      sorted[k++] = list[l];
  else
    for(l = i; l <= mid; l++)
      sorted[k++] = list[l];
  for(l = left; l <= right; l++)
    list[l] = sorted[l];
}

void marge_sort(int list[], int left, int right){
  int mid;
  if(left < right){
    mid = (left+right)/2;
    marge_sort(list, left, mid);
    marge_sort(list, mid+1, right);
    marge(list, left, mid, right);
  }
}

void searchList(int list[], int low, int high, int key){
  int mid;
  while(low <= high){
    mid = (low + high) / 2;
    if(list[mid] == key){
      tf[count++] = 1;
      return;
    }
    else if(key > list[mid]) low = mid+1;
    else high = mid-1;
  }
  tf[count++] = 0;
}