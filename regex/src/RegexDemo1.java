public class RegexDemo1 {

    //使用正则来判断字符串首尾是否相同
    //捕获分组：以左括号为基准，最左边为第一组
    // 正则内部\\
    //正则外部使用$

    //非捕获分组：不占用组号，仅仅只是把数据括起来
    //(?:) (?=) (?!)都是非捕获分组
    public static void main(String[] args) {
        //判断首尾单个字符相同
        //a123a b321b 852358 #fsf# 8foidsfj
        String regex1 = "(.).+\\1";
        System.out.println("a123a".matches(regex1));
        System.out.println("b321b".matches(regex1));
        System.out.println("852358".matches(regex1));
        System.out.println("#fsf#".matches(regex1));
        System.out.println("8foidsfj".matches(regex1));
        System.out.println("--------------------------------");

        //判断首尾多个字符相同
        //123fjksjfk123 ffff23546dfsffff ilove54524ffilove sdfj435fifj
        String regex2 = "(.+).+\\1";
        System.out.println("123fjksjfk123".matches(regex2));
        System.out.println("ffff23546dfsffff".matches(regex2));
        System.out.println("ilove54524ffilove".matches(regex2));
        System.out.println("sdfj435fifj".matches(regex2));
        System.out.println("--------------------------------");

        //判断首尾多个字符相同，而且每个字符相同
        //aaa123aaa 666fig666 345fsd873 fsdafhks
        String regex3 = "((.)+).+\\1";
        System.out.println("aaa123aaa".matches(regex3));
        System.out.println("666fig666".matches(regex3));
        System.out.println("345fsd873".matches(regex3));
        System.out.println("fsdafhks".matches(regex3));
        System.out.println("--------------------------------");

        //替换
        //例：世世界界界界界界，你你你你好好好好好->世界，你好
        String str = "世世界界界界界界，你你你你好好好好好";
        String regex4 = "(.)\\1+";
        String regex5 = "$1";
        String str2 = str.replaceAll(regex4,regex5);
        System.out.println(str);

        System.out.println(str2);
    }
}
