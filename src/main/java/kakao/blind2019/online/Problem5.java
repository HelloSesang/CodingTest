package kakao.blind2019.online;

// n * n 정사각형 2차원 가상 벽면
// 기둥과 보를 이용해 구조물 설치
// 기둥과 보는 길이가 1인 선분으로 표현
// 기둥은 바닥 위, 보의 한쪽 끝 부분 위, 다른 기둥 위 중 하나인 경우에만 존재할 수 있다.
// 보는 한쪽 끝 부분이 기둥 위에 있거나, 양쪽 끝부분이 다른 보와 동시에 연결되어 있어야 한다.

public class Problem5 {

	public static void main(String[] args) {
		Problem5 problem5 = new Problem5();
		int[][] arr = {{1,0,0,1}, {1,1,1,1}, {2,1,0,1}, {2,2,1,1}, {5,0,0,1}, {5,1,0,1}, {4,2,1,1}, {3,2,1,1}};
		problem5.solution(5, arr);
	}

	private int[][] solution(int n, int[][] build_frame) {
		return build_frame;
	}

}
