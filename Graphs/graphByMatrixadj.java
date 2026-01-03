package DSA.Graphs;

public class graphByMatrixadj {
    public static void main(String[] args) {
        int n = 3;
        int m =3;
        int adj[][] = new int[n+1][n+1];
        adj[1][2]=1;
        adj[2][1]=1;

        adj[2][3]=1;
        adj[3][2]=1;

        for(int i=1;i<=n;i++){
            for(int j =1;j<=n;j++){
                System.out.println(adj[i][j]+"");
            }
            System.out.println();
        }
    }
}
