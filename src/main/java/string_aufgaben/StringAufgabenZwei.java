package string_aufgaben;

import org.junit.Test;

public class StringAufgabenZwei {
    @Test
    public void test1() {
        String str1 = "helloworld";
        //1) boolean endsWith(String suffix) 判断此字符串是否以后缀suffix结束
        boolean b1 = str1.endsWith("ld");
        System.out.println(b1);

        //2) boolean startsWith(String prefix) 判断此字符串是否以前缀suffix开始
        System.out.println(str1.startsWith("Hell"));

        //3) boolean startsWith(String prefix，int toffset) 判断此字符串从指定索引处是否以前缀prefix开始
        boolean b2 = str1.startsWith("ll", 2);
        System.out.println(b2);

        //4) boolean contains(CharSequence s) 当此字符串包含指定的char型序列时，返回true
        System.out.println(str1.contains("owor"));

        //5) int indexOf(String str) 返回子字符串在当前字符串中第一次出现的索引，未找到返回-1
        System.out.println(str1.indexOf("lo"));

        //6) int indexOf(String str，int fromIndex) 返回子字符串在当前字符串中第一次出现的索引，从指定的索引开始,未找到返回-1
        System.out.println(str1.indexOf("lo", 4));

        //7) int lastIndexOf(String str) 返回子字符串在当前字符串中最后一次出现的索引,未找到返回-1
        String str2 = "hellorworld";
        System.out.println(str2.lastIndexOf("or"));

        //8) int lastIndexOf(String str，int fromIndex) 返回子字符串在当前字符串中最后出现的索引,从指定的索引反向搜索,未找到返回-1
        System.out.println(str2.lastIndexOf("or", 6));
    }
}
