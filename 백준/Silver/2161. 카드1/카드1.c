 #include <stdio.h>
 #include <stdlib.h>

 #define MAX 1001

 typedef int element;

 typedef struct{
   int front;
   int rear;
   element data[MAX];
 }Queue;

 void init_queue(Queue *q){
   q->front = -1;
   q->rear = -1;
 }

 int is_empty(Queue *q){
   if(q->front == q->rear)
     return 1;
   else
     return 0;
 }

 int is_full(Queue *q){
   if((q->rear + 1) % MAX == q->front)
     return 1;
   else
     return 0;
 }

 void enqueue(Queue *q, int a){
   if(is_full(q))
     return;
   else{
     q->rear = (q->rear + 1) % MAX;
     q->data[q->rear] = a;
   }
 }

 int dequeue(Queue *q){
   if(is_empty(q))
     return -1;
   else{
     q->front = (q->front+1) % MAX;
     return q->data[q->front];
   }
 }

 void start(Queue *q, int N){
   int i = 0;

   for(i = 1; i<=N; i++)
     enqueue(q, i);

   for(i = 0; i < N; i++){
     printf("%d ", dequeue(q));
     enqueue(q, dequeue(q));
   }
  printf("\n");
 }

 int main(){
   int N = 0;
   Queue q;

   scanf("%d", &N);
   init_queue(&q);

   start(&q, N);
 }