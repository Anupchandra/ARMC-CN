import java.util.Scanner;
 
public class BellmanFord
{
    private int d[];
    private int n;
    public static final int MAX_VALUE = 999;
 
    public BellmanFord(int n)
    {
        this.n = n;
        d = new int[n + 1];
    }
 
    public void BellmanFordEvaluation(int source, int a[][])
    {
        for (int node = 1; node <= n; node++)
        {
            d[node] = MAX_VALUE;
        }
 
        d[source] = 0;
        for (int node = 1; node <= n - 1; node++)
        {
            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    if (a[i][j] != MAX_VALUE)
                    {
                        if (d[j] > d[i] 
                                + a[i][j])
                            d[j] = d[i]
                                + a[i][j];
                    }
                }
            }
        }
 
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (a[i][j] != MAX_VALUE)
                {
                    if (d[j] > d[i]
                           + a[i][j])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }
 
        for (int vertex = 1; vertex <= n; vertex++)
        {
            System.out.println("distance of source  " + source + " to "
                      + vertex + " is " + d[vertex]);
        }
    }
 
    public static void main(String[] arg)
    {
        int n = 0;
        int source;
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Enter the number of vertices");
        n = scanner.nextInt();
 
        int a[][] = new int[n + 1][n + 1];
        System.out.println("Enter the adjacency matrix");
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                a[i][j] = scanner.nextInt();
 	        if (i == j)
                {
                    a[i][j] = 0;
                    continue;
                }
                if (a[i][j] == 0)
                {
                    a[i][j] = MAX_VALUE;
                }
            }
        }
 
        System.out.println("Enter the source vertex");
        source = scanner.nextInt();
 
        BellmanFord bellmanford = new BellmanFord(n);
        bellmanford.BellmanFordEvaluation(source, a);
        scanner.close();	
    }
}