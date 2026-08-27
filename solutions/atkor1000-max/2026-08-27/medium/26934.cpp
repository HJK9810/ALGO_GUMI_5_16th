#include<iostream>
#include<vector>
#include<utility>
#include<queue>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
		int drum_size;
        int buckets;
        cin >> drum_size >> buckets;
        queue<pair<int, int>> drum;

        vector<int> water_contents;
        for (int i = 0; i < buckets; i++) {
        	int water;
            cin >> water;
            water_contents.push_back(water);
        }
        for (int b = 0; b < drum_size; b++) {
        	pair<int, int> bucket = {b, water_contents[b]};
            drum.push(bucket);
        }
        
        int next_drum = drum_size;
        while(next_drum < buckets || drum.size() > 1) {
        	pair<int, int> bucket_out = drum.front();
            drum.pop();
            int new_water = bucket_out.second / 2;
            if (new_water == 0) {
                if (next_drum < buckets) {
                   pair<int, int> bucket_in = {next_drum, water_contents[next_drum]};
                   drum.push(bucket_in);
                   next_drum++;
                }
                else continue;
            }
            else {
            	pair<int, int> bucket_in = {bucket_out.first, new_water};
                drum.push(bucket_in);
            }
        }
             
        int last_bucket = drum.front().first + 1;
        cout << "#" << test_case << " " << last_bucket << endl;

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}