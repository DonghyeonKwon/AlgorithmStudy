#include <cstdio>
using namespace std;

int arr[50][50], r1, c1, r2, c2, s = 0, m = 0;

int main(){
    scanf("%d %d %d %d", &r1, &c1, &r2, &c2);
    for(int i = r1; i <= r2; i++){
        for(int j = c1; j <= c2; j++){
            int y = i - r1, x = j - c1;
            if(i < j){
                if(i + j < 0) arr[y][x] = 4*i*i + i + 1 - j;
                else arr[y][x] = 4*j*j - 3*j + 1 - i;
            }
            else{
                if(i + j < 0) arr[y][x] = 4*j*j - j + 1 + i;
                else arr[y][x] = 4*i*i + 3 * i + j + 1;
            }
            if(m < arr[y][x]) m = arr[y][x];
        }
    }

    while(m != 0){
        s++;
        m /= 10;
    }
    for(int i = 0; i <= r2 - r1; i++){
        for(int j = 0; j <= c2 - c1; j++){
            printf("%*d ", s, arr[i][j]);
        }
        printf("\n");
    }

    return 0;
}