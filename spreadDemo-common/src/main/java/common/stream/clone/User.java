package common.stream.clone;


public class User extends SerialCloneable<User>{

    private static final long serialVersionUID = -6032511875994478300L;

    private Long id;
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
    }
}
