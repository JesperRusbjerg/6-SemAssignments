import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hejsa manner");
        Random r = new Random();
        int[] nums = new int[100];
        for (int i = 0; i <15 ; i++) {
            nums[i] = r.nextInt(200) + 1;
        }


        AVLTree avltree = new AVLTree();

        for (int i = 0; i <nums.length ; i++) {
            avltree.root = avltree.insert(avltree.root, nums[i]);
        }

        avltree.preOrder(avltree.root);

    }

}
