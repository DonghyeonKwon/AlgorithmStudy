#include <stdio.h>
#include <stdlib.h>

#define MAX 100
#define TRUE 1
#define FALSE 0

int visited[MAX];

typedef struct GraphNode{
  int vertex;
  struct GraphNode *link;
}GraphNode;

typedef struct GraphType{
  int n;
  GraphNode* list[MAX];
}GraphType;

void init(GraphType* g, int ea){
  if(ea > MAX)
    return;
  g->n = ea;
  for(int i = 0; i < MAX; i++)
    g->list[i] = NULL;
}

void insert_edge(GraphType* g, int x, int y){
  if(x > g->n || y > g->n)
     return;
  GraphNode *node = (GraphNode*)malloc(sizeof(GraphNode));
  node->vertex = x;
  node->link = g->list[y];
  g->list[y] = node;
}

void dfs(GraphType* g, int i){
  GraphNode *w;
  visited[i] = TRUE;
  for(w = g->list[i]; w; w = w->link){
    if(!visited[w->vertex])
      dfs(g, w->vertex);
  }
}

void compare(int n){
  int count = 0;
  for(int i = 1; i < n; i++){
    if(visited[i])
      count++;
  }
  printf("%d\n", count);
}

void reset(){
  for(int i = 0 ; i <MAX; i++)
    visited[i] = FALSE;
}

int main(){
  GraphType* g = (GraphType*)malloc(sizeof(GraphType));
  int ea, edge, x, y;

  scanf("%d", &ea);
  init(g, ea);
  reset();

  scanf("%d", &edge);
  for(int i = 0; i < edge; i++){
    scanf("%d %d", &x, &y);
    insert_edge(g, x-1, y-1);
    insert_edge(g, y-1, x-1);
  }
  dfs(g, 0);

  compare(ea);
  free(g);
  return 0;
}