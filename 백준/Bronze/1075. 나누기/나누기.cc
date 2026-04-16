#include <cstdio>

int main(int argc, char* argv[]){
    int n, f;
    scanf("%d %d", &n, &f);

    n = (n / 100) * 100;

    for(int i = 0; i < 100; i++){
        int t = n + i;
        if(t % f == 0){
            printf("%0*d\n", 2, (t % 100));
            break;
        }
    }
}