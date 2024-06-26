import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int h=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        char map[][]=new char[h][w];
        for(int y=0;y<h;y++){
            map[y]=br.readLine().toCharArray();
        }
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{0,0,0,1});
        boolean visit[][][]=new boolean[2][h][w];
        
        visit[0][0][0]=true;
        int answer=-1;
        int dy[]={-1,1,0,0};
        int dx[]={0,0,1,-1};
        while(!q.isEmpty()){
            int[] p=q.poll();
            int y=p[0];
            int x=p[1];
            int state=p[2];
            int move=p[3];
            if(y==h-1&&x==w-1){
                answer=p[3];
                break;
            }
            for(int i=0;i<4;i++){
                int ny=y+dy[i];
                int nx=x+dx[i];
                if(ny>=0&&nx>=0&&ny<h&&nx<w&&!visit[state][ny][nx]){
                    if(state==0){
                        if(map[ny][nx]=='1'){
                            visit[1][ny][nx]=true;
                            q.add(new int[]{ny,nx,1,move+1});
                        }else{
                            visit[state][ny][nx]=true;
                              q.add(new int[]{ny,nx,0,move+1});
                        }
                    }else{
                        if(map[ny][nx]=='0'){
                            visit[state][ny][nx]=true;
                            q.add(new int[]{ny,nx,state,move+1});
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
