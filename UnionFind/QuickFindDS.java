public class QuickFindDS{
    
    private int[] id;

    public QuickFindDS(int n){
        id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        System.out.println("Program starting: "); 
        print();
    }

    
    public boolean isConnected(int p, int q){
        System.out.println("Checking if " + p + " + " + q + " Are connected");
        return id[p] == id[q];
    }       
     
    public void connect(int p, int q){
        int idp = id[p];
        System.out.println("ID for P: " + idp);
    
        int idq = id[q];
        System.out.println("ID for Q: " + idq);

        for (int i = 0; i < id.length; i++) {
            if(id[i] == idp){
                id[i] = idq;
            }
        }
    }

    public void print(){
        String ptr = "";
        for (int i = 0; i < id.length; i++) {
            ptr += id[i] + " ";
        }
        System.out.println(ptr);
    }


    
    public static void main(String[] args) {
        // QuickFindDS q = new QuickFindDS(10);
        // q.isConnected(0, 2);
        // q.print();
        // q.connect(0, 2);
        // q.isConnected(0, 2);
        // q.print();
        // q.connect(0, 2);
        System.out.println("lol");

    }
}