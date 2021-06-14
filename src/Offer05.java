/**
 * @author liujx
 */
public class Offer05 {
    public String replaceSpace(String s) {
        s=s.replaceAll(" ","%20");
        return s;
    }


    public String replaceSpace1(String s) {
        char[] chars=s.toCharArray();
        char[] chars1=new char[chars.length*3];
        int size=0;
        for(char c:chars){
            if(c==' '){
                chars1[size++]='%';
                chars1[size++]='2';
                chars1[size++]='0';
            } else {
                chars1[size++]=c;
            }
        }
        return new String(chars1,0,size);
    }
}
