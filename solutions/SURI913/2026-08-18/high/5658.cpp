#include <iostream>
#include <string>
#include <set>

#define MAX 101
using namespace std;

int main()
{
	int T;
	cin >> T;
	for (int test_case = 1; test_case <= T; test_case++) {
		int N, K;
		string hexPassStr; //*** 덱 쓰는 것 보다 더 간단
		cin >> N >> K;
		cin >> hexPassStr;

		set<int, greater<int>> result;
		int len = N / 4;

		for (int i = 0; i < len; i++) {
			//네번 회전 회전할 때마다 10진수 변환,
			//변환 후에 마지막 수 앞으로 옮김
			for (int j = 0; j < N; j += len) {
				//네변 자르기 string으로 충분
				string str = hexPassStr.substr(j, len); //길이만큼 컷
					
				int num = stoi(str, nullptr, 16); //16진수 변환
				result.insert(num);
			}

			//회전
			char rotated = hexPassStr.back();
			hexPassStr.pop_back();

			hexPassStr = rotated + hexPassStr;
			
		}
		auto iter = result.begin();
		int count = K - 1;

		while (count--) {
			iter++;
		}
		
		


		cout << '#' << test_case << " " << *iter << endl;


	}
}