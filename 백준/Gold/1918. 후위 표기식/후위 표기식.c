#include <stdio.h>
  #include <stdlib.h>
  #include <string.h>
  #include <malloc.h>
 
  #define MAX 100
 
  typedef char element;
 
  typedef struct{
    element data[MAX];
    int top;
  }stack;
 
  void init_stack(stack *s){
    s->top = -1;
  }
 
  int is_empty(stack *s){
    return (s->top == -1);
  }
 
  int is_full(stack *s){
    return (s->top == MAX -1);
  }
 
  void push(stack *s, element a){
    if(is_full(s)){
      fprintf(stderr, "스택 포화 에러\n");
      return;
    }
    else s->data[++(s->top)] = a;
  }
 
  element pop(stack *s){
    if(is_empty(s)) {
      fprintf(stderr, "스택 공백 에러\n");
      exit(1);
    }
    else return s->data[(s->top)--];
  }
 
  element peek(stack *s){
    if(is_empty(s)){
      fprintf(stderr, "스택 공백 에러\n");
      exit(1);
    }
    else return s->data[s->top];
  }
 
  int prec(element ch){
    switch(ch){
      case '(': case ')': return 0;
      case '+': case '-': return 1;
      case '*': case '/': return 2;
    }
    return -1;
  }
 
  void postfix(char a[]){
 stack s;
    int n;
    n = strlen(a);
    char ch, top_op;
 
    init_stack(&s);
 
    for(int i =0; i<n; i++){
      ch = a[i];
      switch(ch){
        case '+': case '-': case '*': case '/':
          while(!is_empty(&s) &&(prec(ch) <= prec(peek(&s))))
            printf("%c", pop(&s));
          push(&s, ch);
          break;
        case '(':
          push(&s, ch);
          break;
        case ')':
          top_op = pop(&s);
          while(top_op != '('){
            printf("%c", top_op);
            top_op = pop(&s);
          }
          break;
        default:
          printf("%c", ch);
          break;
      }
    }
    while(!is_empty(&s))
      printf("%c", pop(&s));
  }
 
  int main(){
    char a[MAX];
 
    scanf("%s", a);
    postfix(a);
    printf("\n");

    return 0;
}