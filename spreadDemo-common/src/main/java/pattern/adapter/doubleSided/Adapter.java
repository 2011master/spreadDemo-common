package pattern.adapter.doubleSided;

/**
* @desc   适配器类:双向适配器
* @author kanggw
* @datetime 2019/10/12,1:08 下午
*/
public class Adapter implements Target,Adapte {

    private Target target;

    private Adapte adapte;

    public Adapter(Target target) {
        this.target = target;
    }

    public Adapter(Adapte adapte) {
        this.adapte = adapte;
    }

    public Adapter(Target target, Adapte adapte) {
        this.target = target;
        this.adapte = adapte;
    }

    @Override
    public void specificRequest() {
        adapte.specificRequest();
    }

    @Override
    public void request() {
        target.request();
    }
}
