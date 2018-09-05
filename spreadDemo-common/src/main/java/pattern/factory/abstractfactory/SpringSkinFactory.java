package pattern.factory.abstractfactory;

import pattern.factory.abstractfactory.domain.Button;
import pattern.factory.abstractfactory.domain.SpringButton;
import pattern.factory.abstractfactory.domain.SpringText;
import pattern.factory.abstractfactory.domain.Text;

public class SpringSkinFactory implements SkinFactory{

    @Override
    public Button createButton(){

        return new SpringButton();
    }

    @Override
    public Text createText(){

        return new SpringText();
    }
}
