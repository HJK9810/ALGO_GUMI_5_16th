#include<iostream>

using namespace std;
#define MAX 10
int arr[MAX][MAX];
int dc[] = {0,1,0,-1};
int dr[] = {1,0,-1,0};

void ClearArray(int size){
	for(int c = 0; c<size;c++){
    	for(int r = 0; r <size;r++){
        	arr[c][r] = 0;
        }
    }
}
void PrintArray(int size, int test_case){
    cout << '#'<<test_case<<'\n';
    for(int c = 0; c<size;c++){
    	for(int r = 0; r <size;r++){
        	cout << arr[c][r]<<' ';
        }
        cout << '\n';
    }
}
//BFS
int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
  int N;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        cin >> N;
        int nc, nr;
        int col=0, row=0, dir =0,count = 0;
        int check = N*N;
        ClearArray(N);
        while(check--){
            arr[col][row] = ++count;
            
            //다음방향
            nc = col + dc[dir];
            nr = row + dr[dir];
            //값 초기화O, 범위에서 벗어나면 방향변경
            if(arr[nc][nr] != 0 || nc>=N || nr >=N || nc<0 || nr<0){
            	dir = (dir+1)%4;
              nc = col + dc[dir];
            	nr = row + dr[dir];
            }
            col = nc;
            row = nr;
        }
        //출력
        PrintArray(N,test_case);
	}
	return 0;
}