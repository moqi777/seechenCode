import java.io.*;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/22 14:51
 **/
public class CreateTxt {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./create.txt")))){
            long sum = 0;
            while (true){
                char letter = (char) ((int) (Math.random() * 26) + 97);
                if(sum%5==0) bw.write("    ");
                if (sum%100==0) bw.write("\n");
                sum ++;
                bw.write(letter);
                System.out.println(letter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

