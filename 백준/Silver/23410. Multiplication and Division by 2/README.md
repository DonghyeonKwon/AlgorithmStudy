# [Silver I] Multiplication and Division by 2 - 23410 

[문제 링크](https://www.acmicpc.net/problem/23410) 

### 성능 요약

메모리: 303576 KB, 시간: 1484 ms

### 분류

수학, 그래프 이론, 자료 구조, 그래프 탐색, 너비 우선 탐색, 비트마스킹, 해시를 사용한 집합과 맵

### 제출 일자

2026년 04월 16일 22:10:22

### 문제 설명

<p>Consider the number $x$ stored in <code>uint32</code> data type. We can multiply or divide it by $2$ any number of times in any order. Can we obtain the number $y$ after some sequence of operations?</p>

<p>When $a$ is stored in an <code>uint32</code>, and we multiply it by $2$, it transforms into $(a \cdot 2) \bmod 2^{32}$. For example, $(3 \cdot 2) \bmod 2^{32} = 6$, and $(2\,147\,483\,649 \cdot 2) \bmod 2^{32} = 2$.</p>

<p>When $a$ is stored in an <code>uint32</code>, and we divide it by $2$, it transforms into $\left\lfloor\frac{a}{2}\right\rfloor$. For example, $\left\lfloor\frac{6}{2}\right\rfloor = 3$, and $\left\lfloor\frac{3}{2}\right\rfloor = 1$.</p>

### 입력 

 <p>The first line contains an integer $t$, the number of test cases ($1 \le t \le 1000$). The next $t$ lines describe test cases, one per line. Each test case is given by two integers $x$ and $y$ ($0 \le x, y < 2^{32}$).</p>

### 출력 

 <p>For each test case, print a single word on a separate line: "<code>Yes</code>" if we can turn $x$ into $y$ using the allowed operations, or "<code>No</code>" otherwise.</p>

