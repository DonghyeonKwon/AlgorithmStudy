#include <stdio.h>
  #include <stdlib.h>
  #include <string.h>
 
  void init_stack(int *n){
    *n = -1;
  }
 
  void push(int *n, char c[], char s){
    if(*n == 50){
      fprintf(stderr,"스택 포화 에러\n");
      exit(1);
    }
    else  c[++(*n)]= s;
  }
  char pop(int *n, char c[]){
    if(*n == -1){
      fprintf(stderr, "스택 공백 에러\n");
      exit(1);
    }
    return c[(*n)--];
  }
 
  int verify_vps(char s[]){
    int top;
    char data[51];
    char ch, open_ch;
    init_stack(&top);
    int n = strlen(s);
 
    for(int i=0;i<n;i++){
      ch = s[i];
      switch(ch){
      case'(':
        push(&top,data,ch);
        break;
      case')':
        if(top == -1) return 0;
        else{
          open_ch = pop(&top, data);
          if(open_ch == '(' && ch != ')')
            return 0;
        }
        break;
      }
    }
    if(top != -1) return 0;
    return 1;
  }
 
 
  int main(int argc, char* argv[]){
    int T;
 
    scanf("%d",&T);
 
    int a[T];
    char r[51];

    for(int i = 0; i<T; i++){
      scanf("%s", r);
      a[i] = verify_vps(r);
    }
 
    for(int i = 0; i<T; i++){
      if(a[i] == 1)
        printf("YES\n");
      else
        printf("NO\n");
    }
    return 0;
  }
