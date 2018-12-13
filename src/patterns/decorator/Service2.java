package patterns.decorator;

public class Service2 extends ServiceDecorator {

    public Service2(IService service) {
        super(service);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "service2 ";
    }
}
