#include <stdio.h>
 #include <stdlib.h>
 #include <string.h>

 #define MAX 2000001

 typedef int element;

 typedef struct{
   int front;
   int rear;
   element data[MAX];
 }QueueType;

 int is_full(QueueType *q){
   if(q->rear == MAX -1)
     return 1;
   else
     return 0;
 }

 int is_empty(QueueType *q){
   if(q->rear == q->front)
     return 1;
   else
     return 0;
 }

 void  enqueue(QueueType *q, int a){
   if(is_full(q))
     return;
   q->data[++(q->rear)] = a;
 }

 int unqueue(QueueType *q){
   if(is_empty(q))
     return -1;
   else
     return q->data[++(q->front)];
 }

 int front_peek(QueueType *q){
   if(is_empty(q))
    return -1;
   else
     return q->data[(q->front)+1];
 }

 int rear_peek(QueueType *q){
   if(is_empty(q))
     return -1;
   else
     return q->data[q->rear];
 }

 void init_queue(QueueType *q){
   q->front = -1;
   q->rear = -1;
 }

 int main(){
   int N = 0, input_n = 0;
   char input[10];
   QueueType q;

   init_queue(&q);
   scanf("%d", &N);

   for(int i=0; i< N; i++){
     scanf("%s", input);

     if(strcmp("push", input) == 0){
       scanf("%d", &input_n);
       enqueue(&q, input_n);
     }
     else if(strcmp("pop", input) == 0){
       printf("%d\n", unqueue(&q));
     }
     else if(strcmp("size", input) == 0){
       printf("%d\n", q.rear - q.front);
     }
     else if(strcmp("front", input) == 0){
       printf("%d\n", front_peek(&q));
     }
     else if(strcmp("back", input) == 0){
       printf("%d\n", rear_peek(&q));
     }
     else if(strcmp("empty", input) == 0){
       printf("%d\n", is_empty(&q));
     }
   }

   return 0;
 }