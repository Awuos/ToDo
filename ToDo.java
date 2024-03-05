import java.io.*;
import java.util.Scanner;

public class ToDo {
    public static void main(String[] args) {
        //操作選択
        System.out.println("操作を選択してください" + "\n" + "1:書き込み" + "\n" + "2:読み込み" + "\n" + "3:削除");
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int act = sc1.nextInt();

        //操作の判断
        if (act == 1){
            //書き込む内容
            System.out.println("書き込む内容を入力してください");
            String con = sc2.next();
            writing(con);
            sc1.close();
            sc2.close();
        } else if (act == 2){
            loading();
        } else if (act == 3){
            deleting();
        } else {
            System.out.println("正しい値を入力してください");
        }
    }

    //Writing
    public static void writing(String text){
        int count = 0;
        try{
            //ファイルの行数
            File file = new File("ToDo.txt");

            Scanner sc3 = new Scanner(file);

            while(sc3.hasNextLine()){
                sc3.nextLine();
                count += 1;
            }
            sc3.close();

            //FileWriterクラスのオブジェクトを生成する
            FileWriter fw = new FileWriter("ToDo.txt",true);

            //PrintWriterクラスのオブジェクトを生成する
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

            //ファイルに追記する
            pw.println(count+ ":" + text);

            //ファイルを閉じる
            pw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    //loading
    public static void loading(){
        // 書き込むファイルパスの例
String path = "ToDo.txt";

try(FileReader fr = new FileReader(path);
    BufferedReader br = new BufferedReader(fr)){

    String line;
    //ファイルの終わりまで読み込む
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }

}catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
    }

    //deleting
    public static void deleting(){

    }
}