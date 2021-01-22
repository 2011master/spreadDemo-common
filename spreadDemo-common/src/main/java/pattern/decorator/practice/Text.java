package pattern.decorator.practice;

/**
* @desc   字符串类
* @author kanggw
* @datetime 2019-05-16,09:44
*/
public class Text implements Component {

    @Override
    public void output() {
        System.out.println("输出字符");
    }
}


