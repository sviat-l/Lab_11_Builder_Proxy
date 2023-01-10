package BuilderStrategy;

public class MailCodeGift implements MailCode {
    @Override
    public String generateText(Client client){
        return "Congratulations " + client.getName();
    }
}
