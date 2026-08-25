#### 시간복잡도 `O(ElogE)`

> 
>    Checkpoint : Kruskal's algorithm -> Union-Find 알고리즘으로 스패닝체크<br>
>                 Prim's algorithm -> 자료구조 힙(heap)을 이용
>   
>   Kruskal's algorithm 채택
>   

크루스칼 알고리즘은 외워야함

수더코트로 표현하면
```
Kruskal(Graph){
	모든 간선을 가중치 기준으로 오름차순 정렬한다.
	모든 정점을 서로 다른 집합으로 초기화한다. (Make-Set)
	선택한 간선 개수 = 0
	MST 비용 = 0
	정렬된 간선을 하나씩 확인한다.
	for each edge (u, v, cost):
       if Find(u) != Find(v):
            Union(u, v)
            MST에 간선 추가
            MST 비용 += cost
            선택한 간선 개수 증가

5. 선택한 간선 개수가 N-1개가 되면 종료
6. MST 비용 반환
}
    
```

보통의 가중치 문제는 `vector<pair<int,int>>[V_MAX]`로 구현했다면<br>
이번에는 정렬을 위해서 `vector<tuple<int,int,int>>`로 차례대로 시작정점, 도착정점, 가중치를 저장해서 Compare 함수에 가중치 값을 보고 오름차순 할 수 있도록 했음
tuple의 접근방법은 `get<index값>(vector[i])`였음.

크루스칼 시간복잡도
= 간선 정렬 + Union-Find