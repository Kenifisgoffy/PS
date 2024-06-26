import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int dx[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int ddy[] = { -1, 1, 0, 0 };
		int ddx[] = { 0, 0, 1, -1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[][][] data = new int[h][w][k + 1];
		
		int[][] map = new int[h][w];
		for (int y = 0; y < h; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < w; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				for(int i=0;i<=k;i++) data[y][x][i]=Integer.MAX_VALUE;
			}
		}
data[0][0][k]=0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0, k ,0});
		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int p[] = q.poll();
			int y = p[0];
			int x = p[1];
			int res = p[2];
			if(y==h-1&&x==w-1) {
				answer=p[3];
				break;
			}
			if (res > 0) { // 점프할 수가 있어?
				for (int i = 0; i < 8; i++) { // 말 점프
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= 0 && nx >= 0 && ny < h && nx < w && map[ny][nx] == 0 && data[ny][nx][res-1]==Integer.MAX_VALUE) {
						data[ny][nx][res - 1] = p[3]+1;
						q.add(new int[] { ny, nx, res - 1 ,p[3]+1}); //그 자리에서 점프~
					}
				}
			}
            for (int i = 0; i < 4; i++) { // 쪼쪼 점프
				int ny = y + ddy[i];
				int nx = x + ddx[i];
				if (ny >= 0 && nx >= 0 && ny < h && nx < w && map[ny][nx] == 0 && data[ny][nx][res]==Integer.MAX_VALUE) {//방문 안했으면
					data[ny][nx][res] = p[3]+1;
					q.add(new int[] { ny, nx, res ,p[3]+1});
				}
			}
		}
		if (answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
}