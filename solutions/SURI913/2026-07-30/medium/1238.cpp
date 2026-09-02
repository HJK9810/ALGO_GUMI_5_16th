#include<iostream>
#include<vector>
#include<queue>
#define MAX 101
using namespace std;

vector<int> grahp[MAX];
int resultLevel, resultNode;
int N;

vector<int> BFS(int start) {
	queue<int> q;
	bool visited[MAX] = { false, };
	vector<int> dist;
	dist.assign(MAX, 0);

	q.push(start);
	visited[start] = true;
	
	while (!q.empty()) {
		int current = q.front();
		q.pop();
		
		//레벨이 깊을때 + 전체 탐색이 끝났을 때?

		for (auto& next : grahp[current]) {
			if (visited[next]) continue;
			visited[next] = true;
			q.push(next);
			dist[next] = dist[current] + 1;
		}
	}

	return dist;
}


int main() {
	int T=10;

	for (int test_case = 1; test_case <= T; test_case++) {
		int S; //데이터 길이, 시작점
		cin >> N >> S;

		for (int i = 0; i < MAX; i++) {
			grahp[i].clear();
		}
		
		for (int i = 0; i < N/2; i++) {
			int a, b;
			cin >> a >> b;
			grahp[a].push_back(b);
		}


		vector<int> dist = BFS(S);
		int result = 0;
		int maxDist=0;

		for (int i = MAX-1; i >=0; i--) {
			if (maxDist < dist[i]) {
				maxDist = dist[i];
				result = i;
			}
		}
		cout << "#" << test_case << " " << result << "\n";
	}

	return 0;
}