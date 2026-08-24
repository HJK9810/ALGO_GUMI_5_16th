#include <iostream>
#include <algorithm>
#include<vector>
#include<queue>
using namespace std;
#define MAX_W 12
#define MAX_H 15
int N, W, H;
int result;

int dr[4] = { -1, 1, 0, 0 };
int dc[4] = { 0, 0, -1, 1 };

struct Brick {
	int row;
	int col;
	int power;
};


int gravity(vector<vector<int>>& map) {
	//아래서 위로 [H~0][0~W]
	//올라가다 0만나면 다음에 오는 숫자들 다 한칸 씩 내리기
	//값 반영
	// 0말고 다른 값 찾으면 해당값부터 움직임
	for (int c = 0; c < W; c++) {
		// 벽돌이 들어갈 가장 아래 위치
		int write = H - 1;

		for (int r = H - 1; r >= 0; r--) {
			if (map[r][c] == 0) continue;
			else {
				int value = map[r][c];
				// 기존 위치 제거
				map[r][c] = 0;

				// 가장 아래부터 채움
				map[write][c] = value;
				write--;
			}
		}
	}
}

int bfs(vector<vector<int>>& map, int startR, int startC) {
	//연쇄 폭파
	queue<Brick> q;
	q.push({ startR, startC, map[startR][startC]});
	int destroyed = 1;

	while (!q.empty()) {
		//bfs알고리즘이 뭐였찌?
		map[startR][startC] = 0;
		Brick current = q.front();
		q.pop();
		int len = current.power;
		for (int dir = 0; dir < 4; dir++) {
			for (int dist = 1; dist < len; dist++) {
				//다음 방향 계산
				int nr = current.row + dr[dir] * dist;
				int nc = current.col + dc[dir] * dist;

				//범위 벗어남
				if (nr < 0 || nc < 0 || nr >= H || nc >= W) break;
				// 빈 공간
				if (map[nr][nc] == 0) continue;
				// 범위가 2 이상이라면
				// 이 벽돌도 연쇄 폭발을 일으킴
				int nextPower = map[nr][nc];
				// 제거
				map[nr][nc] = 0;
				destroyed++;
				//추가로 있으면 탐색 추가
				if (nextPower > 1) {
					q.push({ nr, nc, nextPower });
				}
				
			}
		}
	}
	return destroyed; //삭제한만큼 반환
}

void dfs(vector<vector<int>> map , int count, int remain) {

	if (remain == 0) {
		result = 0;
		return;
	}
	if (count == N) {
		//최소 탐색 끝
		result = min(result, remain);
		return;
	}
	// 모든 열에 구슬을 쏴본다.
	for (int c = 0; c < W; c++) {
		int startR = 0;

		// r 맨 꼭대기 찾기
		for (int r = 0; r < H; r++) {
			if (map[r][c] != 0) {
				startR = r;
				break;
			}
		}
		vector<vector<int>> tmp = map;
		int destroyed = bfs(tmp, startR, c); //연쇄 작용
		gravity(tmp);

		 // 다음 구슬
		dfs(tmp, count + 1, remain - destroyed);

		// 이미 최적값 0이면 더 탐색할 필요 없음
		if (result == 0) return;
	}
	
}

int main()
{
	int T;
	cin >> T;
	for (int test_case = 1; test_case <= T; test_case++) {
		cin >> N >> W >> H;
		result = 0;
		vector<vector<int>> map(H,vector<int>(W)); //초기화
		int remain = 0;


		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				cin >> map[r][c];
				if (map[r][c] != 0) remain++;
			}
		}
		result = remain;
		
		dfs(map, 0, remain);

		cout << '#'<< test_case << " "<< result << endl;
	}
	return 0;
}