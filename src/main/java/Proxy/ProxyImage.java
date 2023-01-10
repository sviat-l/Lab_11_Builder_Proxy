package Proxy;

public class ProxyImage implements MyImage{
    private final String fileName;
    private RealImage realImage;

    public ProxyImage(String filename){
        this.fileName = filename;
    }

    @Override
    public void display(){
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
