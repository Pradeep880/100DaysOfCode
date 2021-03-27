import java.util.*;

class huff {
    int data;
    char c;
    huff left;
    huff right;

    huff(int d, char ch) {
        data = d;
        c = ch;
        left = null;
        right = null;
    }
}

// comparator class helps to compare the node
// on the basis of one of its attribute.
// Here we will be compared
// on the basis of data values of the nodes.
class MyComparator implements Comparator<huff> {
    public int compare(huff x, huff y) {

        if (x.data >= y.data)
            return 1;
        else
            return -1;
    }
}

class Huffman {
    huff root = null;
    ArrayList<String> array = new ArrayList<>();

    public void HuffmanTree(PriorityQueue<huff> p1) {

        while (p1.size() != 1) {
            huff a1 = p1.peek();
            p1.poll();
            huff a2 = p1.peek();
            p1.poll();
            int sum = a1.data + a2.data;
            huff temp = new huff(sum, '-');
            temp.left = a1;
            temp.right = a2;

            p1.add(temp);
        }
        root = p1.poll();
        // return root;
    }

    void PreOrder(huff root, String S) {
        if (root == null)
            return;
        if (root.c != '-') {
            array.add(S);
            System.out.println(root.c + ": " + S);
        }
        PreOrder(root.left, S + "0");
        PreOrder(root.right, S + "1");
    }

    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        // Code here
        root = null;
        PriorityQueue<huff> p1 = new PriorityQueue<huff>(N, new MyComparator());
        // huff h[]=new huff[N];
        for (int i = 0; i < N; i++) {
            huff h = new huff(f[i], S.charAt(i));
            p1.add(h);
        }

        // for(int i=0;i<N;i++){
        // p1.add(h[i]);
        // }
        HuffmanTree(p1);
        String Str = "";
        array = new ArrayList<String>();
        System.out.println("Preorder travesal after huffan encoding");
        PreOrder(root, Str);
        return array;
    }
}

/**
 * Huffman_Encoding
 */
public class Huffman_Encoding {
    public static void main(String[] args) {
        String S = "abcdef";
        int f[] = { 5, 9, 12, 13, 16, 45 };
        Huffman h1 = new Huffman();
        int n = S.length();
        ArrayList<String> a1 = h1.huffmanCodes(S, f, n);
        System.out.println("Data after performing huffman encoding(Preorder)");
        for (String str : a1) {
            System.out.print(str + "  ");
        }
    }
}