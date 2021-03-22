import java.io.IOException;

public class Test {

    public static void main(String[] args){
        int inChar;
        while (true){
            System.out.println("Enter a character:");
            try {
                //将从键盘缓冲区读入一个字节的数据，然而返回的16位的二进制数据，其低8位为键盘的ASCII码，高8位为0
                inChar = (char)System.in.read();
                System.out.println("you entered");
                System.out.println(inChar);
//                System.out.println("\t " + String.valueOf(inChar));
                System.in.skip(1);//跳过第n个字节
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
