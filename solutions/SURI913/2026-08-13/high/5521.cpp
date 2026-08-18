#include <iostream>
#include <vector>
#include <unordered_set>
#define MAX 501
using namespace std;

//트리문제
int main()
{
	int T;
	cin >> T;
	for (int test_case = 1; test_case <= T; test_case++) {
		int N, M;
		cin >> N >> M;

		vector<int> graph[MAX];
		bool invited[MAX] = { false, }; //unordered_set으로 가능 압력값 클 때 유리

		for (int i = 0; i < M; i++) {
			int a, b;
			cin >> a >> b;

			graph[a].push_back(b);
			graph[b].push_back(a);
		}

		//1일때 초대
		for (int idx : graph[1]) {
			invited[idx] = true;
			//초대한 친구의 친구도 초대
			for (int pairIdx : graph[idx]) {
				if (pairIdx != 1)
					invited[pairIdx] = true;
			}
		}
		int answer = 0;
		for (int i = 2; i <= N; i++) {
			if (invited[i]) answer++;
		}
		

		cout << '#' << test_case << " " << answer << endl;


	}
}