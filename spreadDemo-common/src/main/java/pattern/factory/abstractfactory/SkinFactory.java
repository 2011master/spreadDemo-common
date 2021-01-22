package pattern.factory.abstractfactory;

import pattern.factory.abstractfactory.domain.Button;
import pattern.factory.abstractfactory.domain.Text;

public interface SkinFactory {

    Button createButton();

    Text createText();
}
