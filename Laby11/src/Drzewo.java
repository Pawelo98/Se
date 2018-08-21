import java.util.*;

public class Drzewo{

    private HashMap<WezelHuffmana, String> codeMap;

    public Drzewo() {
        this.codeMap = new HashMap<>();
    }

    public void generate(WezelHuffmana root, String s) {

        if (root.getLeft() == null && root.getRight() == null) {

            this.codeMap.put(root, s);

            return;
        }

        generate(root.getLeft(), s + "0");
        generate(root.getRight(), s + "1");
    }

    public HashMap<WezelHuffmana, String> getCodeMap() {
        return this.codeMap;
    }
}