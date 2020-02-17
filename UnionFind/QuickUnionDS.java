import javax.management.QueryExp;

public class QuickUnionDS{
    
    private int[] parent;

    public QuickUnionDS(int n){
        // parent = new int[]{-1, 0, 1, -1, 0, 3, -1};
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
        System.out.println("Program starting: "); 
        print();
    }

    private int find(int p){
        int val = p;
        while (parent[val] > -1){
            val = parent[val];
            System.out.println("Searching .. " +val);
        } 
        System.out.println("Found it! " +val);
        return val;
    }


    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }       
     
    public void connect(int p, int q){
        int i = find(p);
        int j = find(q);
        System.out.println("p to connect: " + i + "q to connect: " + j);
        parent[i] = j;
    }

    public void print(){
        String ptr = "";
        for (int i = 0; i < parent.length; i++) {
            ptr += parent[i] + " ";
        }
        System.out.println(ptr);
    }


    
    public static void main(String[] args) {
        QuickUnionDS q = new QuickUnionDS(10);
        System.out.println("STARTING");
        
        int x = q.find(5);
        int y = q.find(2);
        int gg = 2;

    }
}