package day6_Greedy_Divide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WirelessCharge {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int T, M, A;
	static String moveA, moveB;
	static BC[] bc;
	static User userA;
	static User userB;
	static PriorityQueue<BC> pqA = new PriorityQueue<>();
	static PriorityQueue<BC> pqB = new PriorityQueue<>();

	/*
	 * M: 총 이동 횟수
	 * A: BC 개수
	 * moveA,B: A,B의 이동 경로
	 * bc: BC들
	 */

	static class BC implements Comparable<BC> {
		int x;
		int y; // 좌표
		int c; // 충전 범위
		int p; // 충전량

		public BC(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

		@Override
		public int compareTo(BC o) {
			return o.p - this.p;
		}
	}

	static class User {
		int x;
		int y; // 좌표
		int sum; // 충전량

		public User(int x, int y) {
			this.x = x;
			this.y = y;
			this.sum = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			process();
			bw.write(String.format("#%d ", tc));
			bw.write(userA.sum + userB.sum + "\n");
		}
		bw.flush();
		bw.close();
	}

	public static void process() {
		for (int i = 0; i < M; i++) {
			charge(); // 충전하기
			move(i); // 이동하기
		}
		charge();
	}

	public static void charge() {
		/*
		 * BC의 범위(c) 안에 사용자가 있으면 BC.p만큼 충전
		 * 사용자가 2개 이상의 BC 범위 안에 있으면 가장 큰 것 충전
		 * 2명의 사용자가 같은 BC 범위 안에 있으면 절반만 충전 혹은 서로 다른 BC 충전
		 */
		for (int i = 0; i < A; i++) {
			if (bc[i].c >= getDistance(userA, bc[i])) {
				pqA.offer(bc[i]);
			}
			if (bc[i].c >= getDistance(userB, bc[i])) {
				pqB.offer(bc[i]);
			}
		}

		BC chargeA = pqA.poll();
		BC chargeB = pqB.poll();
		if (Objects.isNull(chargeA) && Objects.isNull(chargeB)) {
			// 둘 다 BC 포함 x
			return;
		} else if (Objects.isNull(chargeA) && !Objects.isNull(chargeB)) {
			userB.sum += chargeB.p;
		} else if (!Objects.isNull(chargeA) && Objects.isNull(chargeB)) {
			userA.sum += chargeA.p;
		} else {
			if (!chargeA.equals(chargeB)) {
				// 서로 다른 BC를 포함
				userA.sum += chargeA.p;
				userB.sum += chargeB.p;
			} else {
				// 같은 BC를 포함
				if (Objects.isNull(pqA.peek()) && Objects.isNull(pqB.peek())) {
					// 둘 다 다른 BC가 없음
					userA.sum += chargeA.p / 2;
					userB.sum += chargeB.p / 2;
				} else if (Objects.isNull(pqA.peek()) && !Objects.isNull(pqB.peek())) {
					// userB는 다른 BC에 포함
					userA.sum += chargeA.p;
					userB.sum += pqB.poll().p;
				} else if (!Objects.isNull(pqA.peek()) && Objects.isNull(pqB.peek())) {
					// userA는 다른 BC에 포함
					userA.sum += pqA.poll().p;
					userB.sum += chargeB.p;
				} else {
					// 둘 다 다른 BC를 포함함
					if (pqA.peek().p > pqB.peek().p) {
						userA.sum += pqA.poll().p;
						userB.sum += chargeB.p;
					} else if (pqA.peek().p <= pqB.peek().p) {
						userA.sum += chargeA.p;
						userB.sum += pqB.poll().p;
					}
				}
			}
		}

		pqA.clear();
		pqB.clear();
	}

	public static int getDistance(User user, BC bc) {
		return Math.abs(user.x - bc.x) + Math.abs(user.y - bc.y);
	}

	public static void move(int i) {
		int[][] deltas = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
		int a = (int) (moveA.charAt(i) - '0');
		int b = (int) (moveB.charAt(i) - '0');
		userA.x += deltas[a][0];
		userA.y += deltas[a][1];
		userB.x += deltas[b][0];
		userB.y += deltas[b][1];
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		moveA = br.readLine().replace(" ", "");
		moveB = br.readLine().replace(" ", "");
		bc = new BC[A];
		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			bc[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		userA = new User(1, 1);
		userB = new User(10, 10);
	}
}
