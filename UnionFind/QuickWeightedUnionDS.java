import javax.management.QueryExp;

public class QuickWeightedUnionDS{
    
    private int[] parent;

    public QuickWeightedUnionDS(int n){
        parent = new int[]{-4, 0, 1, -2, 0, 3, -1};
        // parent = new int[n];
        // for (int i = 0; i < parent.length; i++) {
        //     parent[i] = -1;
        // }
       System.out.println("Original");
        print();
    }

    private int[] find(int p){
        int val = p;
        while (parent[val] > -1){
            val = parent[val];
            System.out.println("Searching .. " +val);
        } 
        System.out.println("Found it! " +val);
        
        return new int[]{val, parent[val]};
    }


    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }       
     
    public void connect(int p, int q){
        int[] pid = find(p);
        int[] qid = find(q);
        int pindx = pid[0];
        int qindx = qid[0];


        if(pid[1]>=qid[1]){
        //Case p is the smallest tree
        parent[pindx] = qindx;
        parent[qindx] = parent[qindx] + pid[1];

        }else{
        //Case q is the smallest tree
        parent[qindx] = pindx;
        parent[pindx] = parent[qindx] + qid[1];
        }
        
    }

    public void print(){
        String ptr = "";
        for (int i = 0; i < parent.length; i++) {
            ptr += parent[i] + " ";
        }
        System.out.println(ptr);
    }


    
    public static void main(String[] args) {
        QuickWeightedUnionDS q = new QuickWeightedUnionDS(10);
        System.out.println("Program starting!");
        q.connect(5, 2);
        q.print();

    }
}