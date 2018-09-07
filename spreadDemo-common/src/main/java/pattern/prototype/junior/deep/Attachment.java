package pattern.prototype.junior.deep;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Data
public class Attachment implements Serializable {

    private static final long serialVersionUID = 5860625805491656559L;

    private String name;

    public void download() {

    }
}
