package string_aufgaben;

import org.junit.Test;

public class StringAufgabenDrei {
    @Test
    public void test1() {
        String str1 = "halloworld halloworld";
        //1) String replace(char oldChar, char newChar) 把当前字符串中所有的oldChar都换成newChar并返回新的字符串
        System.out.println(str1.replace('a', 'e'));
        System.out.println(str1);

        //2) String replace(CharSequence target, CharSequence replacement)
        // 用指定字面值replacement替换当前字符串中所有匹配字面值目标序列的子字符串
        System.out.println(str1.replace("lo", "ol"));

        //3) String replaceAll(String regex, String replacement) regex 是正则表达式
        // 用指定字面值replacement替换当前字符串中所有匹配给定的正则表达式的子字符串


        //4) String replaceFirst(String regex, String replacement)
        // 用指定字面值replacement替换当前字符串中匹配给定的正则表达式的第一个子字符串

        //4) boolean matches(String regex) 判断当前字符串是否匹配给定的正则表达式

        //5) String[] split(String regex) 根据给定正则表达式的匹配拆分当前字符串

        //6) String[] split(String regex，int limit)
        // 根据给定正则表达式的匹配拆分当前字符串，最多不超过limit个，若超过，剩下的全部放入最后一个元素里
    }

    @Test
    public void test2() {
        char[] a = {'b', 'o', 'y'};
        char a1[] = {'b', 'i', 'g'};
        char[] a2 = new char[2];
        a2[0] = 'a';
        a2[1] = 'b';
        String s = new String(a2);
        System.out.println(s);
    }

    @Test
    public void test3() {
        String s = "ads112";
        char[] array = s.toCharArray();
        System.out.println(array.length);

    }
}
