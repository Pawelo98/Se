import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        ArrayList<WezelHuffmana> listaWezlow = new ArrayList<>();
        Kolejka kolejka = new Kolejka();
        Drzewo drzewo = new Drzewo();

        String text = "";
        File file = new File("tekst.txt");
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String temp = scanner.nextLine();
                text+=temp;
            }
        }catch(Exception e){ e.printStackTrace(); }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            WezelHuffmana node = find(listaWezlow, c);
            if (node == null) {
                listaWezlow.add(new WezelHuffmana(c, 1));
            } else {
                node.setData(node.getData() + 1);
            }
        }

        for (WezelHuffmana node : listaWezlow) {
            kolejka.enqueue(node);
        }

        WezelHuffmana root = null;

        while (kolejka.size() > 1) {
            WezelHuffmana left = kolejka.dequeue();
            WezelHuffmana right = kolejka.dequeue();

            WezelHuffmana node = new WezelHuffmana();
            node.setData(left.getData() + right.getData());
            node.setC('+');
            node.setLeft(left);
            node.setRight(right);

            root = node;
            kolejka.enqueue(node);
        }

        Drzewo huffman = new Drzewo();
        huffman.generate(root, "");
        printHashMap(huffman.getCodeMap());
        String changed = "";
        System.out.println("Zakodowany tekst: ");
        try {
            changed = change(huffman.getCodeMap(), text, changed);
        }catch(FileNotFoundException e) { e.printStackTrace(); }

        Kolejka kolejka2 = new Kolejka();
        unchange(changed, listaWezlow, kolejka2);
        unchanged(huffman.getCodeMap(), changed, text);
    }

    public static WezelHuffmana find(ArrayList<WezelHuffmana> list, char c) {
        for (WezelHuffmana node : list) {
            if (node.getC() == c) {
                return node;
            }
        }

        return null;
    }

    public static void printHashMap(HashMap hashMap) {
        ArrayList<WezelHuffmana> keys = new ArrayList<>(hashMap.keySet());
        for (WezelHuffmana key : keys) {
            System.out.println(key + "\t" + hashMap.get(key));
        }
    }

    public static void unchanged(HashMap hashMap, String changed, String text) {
        ArrayList<WezelHuffmana> keys = new ArrayList<>(hashMap.keySet());
        char temp;
        String tymcz = "";
        for(int i=0; i<changed.length(); i++) {
            temp = changed.charAt(i);
            tymcz+=temp;
            for (WezelHuffmana key : keys) {
                if(tymcz==hashMap.get(key)) {
                    text += key.getC();
                    tymcz="";
                }
            }
        }
        System.out.println(text);
    }

    public static String change(HashMap hashMap, String text, String changed) throws FileNotFoundException {
        ArrayList<WezelHuffmana> keys = new ArrayList<>(hashMap.keySet());
        char temp;
        for(int i=0; i<text.length(); i++) {
            temp = text.charAt(i);
            for (WezelHuffmana key : keys) {
                if(key.getC()==temp) {
                    changed += hashMap.get(key);
                }
            }
        }
        System.out.println(changed);
        PrintWriter zapis = new PrintWriter("zapisKodu.txt");
        zapis.println(changed);
        zapis.close();
        return changed;
    }

    public static void unchange(String changed, ArrayList<WezelHuffmana> listaWezlow, Kolejka kolejka){
        char temp;
        String text = "";
        WezelHuffmana root = null;

        for (WezelHuffmana node : listaWezlow) {
            kolejka.enqueue(node);
        }
        while (kolejka.size() > 1) {
            WezelHuffmana left = kolejka.dequeue();
            WezelHuffmana right = kolejka.dequeue();

            WezelHuffmana node = new WezelHuffmana();
            node.setData(left.getData() + right.getData());
            node.setC('-');
            node.setLeft(left);
            node.setRight(right);

            root = node;
            kolejka.enqueue(node);
        }
        WezelHuffmana current = root;

        for(int i=0; i<changed.length(); i++) {
                temp = changed.charAt(i);
                if (temp == '0') {
                    if(current.getLeft()!=null) {
                        current = current.getLeft();
                    }
                    else{
                        temp = current.getC();
                        text+=temp;
                        current = root;
                    }
                }
                else if(temp=='1'){
                    if(current.getRight()!=null){
                        current = current.getRight();
                    }
                    else{
                        temp = current.getC();
                        text+=temp;
                        current = root;
                    }
            }
        }
        System.out.println();
        System.out.println("Odkodowany tekst: ");
    }
}
