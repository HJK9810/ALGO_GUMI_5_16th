#include <iostream>
using namespace std;
#define MAX 101

int parent[MAX];
int cnt;
//유니온 파인드
void SetParent(int n) {
	for (int i = 0; i <= n; i++) {
		parent[i] = i;
	}
}

int Find(int x) {
	if (parent[x] == x) return x;
	return parent[x] = Find(parent[x]);
}

void Union(int a, int b) {
	int rootA = Find(a);
	int rootB = Find(b);

	//이미 최상단 부모라
	if (rootA != rootB) {
		//A -B
		parent[rootB] = rootA; //parent[rootA]아님 rootA 들어가야지
		cnt--; //그룹 수 세기 위한 cnt 부모 정해질때마다 줄임
	}
}

int main() {
	int T;
	cin >> T;
	for (int test_case = 1; test_case <= T; test_case++) {
		int N, M;
		cin >> N >> M;
		SetParent(N);
		cnt = N;
		int a, b;
		for (int i = 0; i < M; i++) {
			cin >> a >> b;
			Union(a, b);
		}

		cout << '#' << test_case << ' ' << cnt << endl;
	}
}