package org.spianmo.algorithm.Graph;

/**
 * @ClassName MatGraphClass
 * @Description TODO
 * @Author Finger
 * @Date 11/17/2020
 **/
public class MatGraphClass {
    //表示最多顶点个数
    final int MAXV = 100;
    //表示∞
    final int INF = 0x3f3f3f3f;
    //邻接矩阵数组，元素为int类型
    int[][] edges;
    //顶点数，边数
    int n, e;
    //存放顶点信息
    String[] vexs;

    public MatGraphClass() {
        edges = new int[MAXV][MAXV];
        vexs = new String[MAXV];
    }

    public static void main(String[] args) {
        MatGraphClass matGraph = new MatGraphClass();
        matGraph.createMatGraph(new int[][]{{0, 1, 0, 1, 1}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 1, 0, 1}, {1, 0, 1, 1, 0}}, 5, 8);
        matGraph.dispMatGraph();
    }

    /**
     * 无向图邻接矩阵中求顶点v的度
     *
     * @param g
     * @param v
     * @return
     */
    public static int degree1(MatGraphClass g, int v) {
        int d = 0;
        //统计第v行的非0非∞元素个数
        for (int j = 0; j < g.n; j++) {
            if (g.edges[v][j] != 0 && g.edges[v][j] != g.INF) {
                d++;
            }
        }
        return d;
    }


    /**
     * 有向图邻接矩阵中求顶点v的出度和入度
     *
     * @param g
     * @param v
     * @return
     */
    public static int[] degree2(MatGraphClass g, int v) {
        int[] ans = new int[2];
        //累计出度
        ans[0] = 0;
        //统计第v行的非0非∞元素个数为出度
        for (int j = 0; j < g.n; j++){
            if (g.edges[v][j] != 0 && g.edges[v][j] != g.INF) {
                ans[0]++;
            }
        }
        //累计入度
        ans[1] = 0;
        //统计第v列的非0非∞元素个数为入度
        for (int i = 0; i < g.n; i++){
            if (g.edges[i][v] != 0 && g.edges[i][v] != g.INF) {
                ans[1]++;
            }
        }
        return ans;
    }


    public void createMatGraph(int[][] a, int n, int e) {
        //置顶点数和边数
        this.n = n;
        this.e = e;
        for (int i = 0; i < n; i++) {
            edges[i] = new int[n];
            System.arraycopy(a[i], 0, edges[i], 0, n);
        }
    }

    public void dispMatGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (edges[i][j] == INF) {
                    System.out.printf("%4s", "∞");
                } else {
                    System.out.printf("%5d", edges[i][j]);
                }
            }
            System.out.println();
        }
    }


}
