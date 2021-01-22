package pattern.factory.abstractfactory;

import pattern.factory.abstractfactory.domain.*;

public class SummerSkinFactory implements SkinFactory{

    @Override
    public Button createButton(){

        return new SummerButton();
    }

    @Override
    public Text createText(){

        return new SummerText();
    }
}
