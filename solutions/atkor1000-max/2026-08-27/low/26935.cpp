#include<iostream>
#include <vector>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int boards;
        int turns;
        cin >> boards >> turns;
		vector<int> v(boards);
        for (int i = 0; i < boards; i++) {
        	cin >> v[i];
        }
        cout << "#" << test_case << " " << v[turns % boards] << endl;
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}