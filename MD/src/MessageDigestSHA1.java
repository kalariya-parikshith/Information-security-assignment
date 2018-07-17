
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;



public class MessageDigestSHA1{
    public static void main(String[] args)
    {

        File file = new File("src/hello.txt");
        byte buffer[] = new byte[(int)file.length()];
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            fis.read(buffer);
            fis.close();
        }catch (Exception e){System.out.println(e);}

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(buffer);

            byte[] digest = md.digest();
            StringBuffer hd = new StringBuffer();

            for (byte aDigest : digest)
                hd.append(Integer.toString(aDigest + 0x100, 16).substring(1));

            System.out.println(hd);
        }
        catch (Exception e){System.out.println(e);}

    }
}