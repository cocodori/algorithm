package boj


/**
 * N x N 크기 공간에 물고기 M 마리와 아기 상어 한 마리.
 * 공간은 1x1 크기의 정사각형 칸으로 나누어짐.
 * 아기 상어는 1초에 상하좌우 어디든 한 칸씩 이동한다.
 * 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸을 지날 수 없고, 나머지는 모두 지나갈 수 있음.
 * 자신과 같은 크기의 물고기는 먹지 못하고 지나갈 수만 있다.
 * 아기 상어가 어디로 이동할지 결정하는 방법은 이럼
 * - 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
 * - 먹을 수 있는 물고기가 한 마리라면 그 물고기를 먹으러 간다.
 * - 먹을 수 있는 물고기가 한 마리보다 많다면 거리가 가장 가까운 물고기를 먹으러 간다.
 *   - 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야 하는 칸의 갯수의 최솟값.
 *   - 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그런 물고기가 여러 마리라면, 가장 '왼쪽'에 있는 물고기를 먹음.
 *
 * 아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다. 즉, 아기 상어가 먹을 수 있는 물괵가 있는 칸으로 이동했다면,
 * 이동과 동시에 물고기를 먹어치우는 셈. 먹힌 칸은 빈 칸이 된다.
 * 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1 증가한다. 예를 들어 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.
 * 공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 짜야 한다.
 *
 * 첫 줄에는 공간의 크기 N
 * 둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져있고, 아래와 같은 의미.
 * - 0: 빈 칸
 * - 1, 2, 3, 4, 5, 6: 각 칸의 물고기 크기
 * - 9: 아기 상어 위치
 */
class Shark {

}