package patterns.factory;

abstract class Handler{
    abstract void read();
    abstract void write();
        }

class TxtHandler extends Handler{
    @Override
    void read() {
        System.out.println("Read in Txt");
    }

    @Override
    void write() {
        System.out.println("Write in Txt");
    }
}
class XmlHandler extends Handler{
    @Override
    void read() {
        System.out.println("Read in Xml");
    }

    @Override
    void write() {
        System.out.println("Write in Xml");
    }
}

public class Factory {

    public Handler getHandler(String string){
        Handler handler = null;
        if (string.endsWith("txt")){   // возвращает расширение????
            handler = new TxtHandler();
        }else if(string.endsWith("xml")){
            handler = new XmlHandler();
        }
        return handler;

        // можно без else if
//        if(str.endsWith("txt")){
//            return new TxtHandler();
//        }
//        if (str.endsWith("xml")){
//            return new XmlHandler();
//        }
//        return null;
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        String file = "qwe.txt";
        Handler handler = factory.getHandler(file);
        handler.read();
        handler.write();
    }


}
