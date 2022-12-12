package string_aufgaben;

import org.junit.Test;

public class StringAufgabenEins {

    @Test
    public void test1() {
        String s1 = "helloWorld";
        String s2 = "";

        //1) int length() return value.length 返回底层char型数组的长度
        System.out.println(s1.length());

        //2) char charAt(int index) 返回指定位置上的char
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));
        //System.out.println(s1.charAt(10));StringIndexOutOfBoundsException

        //3) boolean isEmpty() 判断String是否为空字符串 length大于0就非空
        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());

        //4) String toLowerCase() 将String中所有字符改为小写并返回一个新的字符串，不修改原字符串，
        String s3 = s1.toLowerCase();
        System.out.println(s1 + "***" + s3);

        //5) String toUpperCase() 将String中所有字符改为大写
        System.out.println(s1.toUpperCase());


        //6) String trim() 返回字符串副本，忽略前，后的空白 中间的空格去不掉，在存总户名，密码时可防止因为空格造成的错误
        String s4 = "  he  llo  world  ";
        System.out.println("******" + s4.trim() + "************" + s4 + "*******");

    }

    @Test
    public void test2() {
        String str1 = "helloworld";
        //7) boolean equals(Object obj) 比较字符串内容是否相同，大小写，空格都要判断
        System.out.println(str1.equals("halloWelt"));
        System.out.println(str1.equals("hallo world"));

        //8) boolean equalsIgnoreCase(String anotherString) 比较字符串内容是否相同并忽略大小写,空格要判断
        System.out.println(str1.equalsIgnoreCase("helloWorld"));

        //9) String concat(String str) 将str加到当前字符串的末尾，等价与加号+
        String str2 = "byebye";
        System.out.println(str1.concat(str2));

        //10) int compareTo(String anotherString) 比较字符串大小
        String str3 = "abc";
        String str4 = new String("abea");
        System.out.println(str3.compareTo(str4));//-2

        //11) String substring(int beginIndex) 返回一个新字符串，是当前字符串的从beginIndex开始截取
        System.out.println(str1.substring(2) + "*********" + str1);

        //12) String substring(int beginIndex， int endIndex) 返回当前字符串的从beginIndex到endIndex之间的一个新字符串
        //注意是左闭右开的区间！！！！
        System.out.println(str1.substring(2, 5));


    }
}
