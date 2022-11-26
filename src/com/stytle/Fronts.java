package
        com.
                stytle;
import
        java.
                awt.
        *;
public class
Fronts
{
    public static
    Font
            title;
    public static
    Font
            account;
    public static
    Font
            accounttext;
    public static
    Font
            ok;
    public static
    Font

            register;
    public
    Fronts()
    {
        title
                =new Font
                ("黑体" +
                        ""
                        ,Font.BOLD,
                        28);

        //标题
        account
                =new Font
                (
                        "黑体"
                        ,Font.
                        BOLD,
                        18);
        //标签
        accounttext
                =new Font
                ("黑体",
                        Font.
                                PLAIN,
                        18);
        //账号框
        ok
                =new Font
                ("黑体",
                        Font.BOLD,
                        18);
        //登录
        register
                =new Font
                (
                        "黑体",
                        Font.BOLD,
                        11);
        //注册
    }
}
