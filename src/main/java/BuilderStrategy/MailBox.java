package BuilderStrategy;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MailBox {
    private final List<MailInfo> infos = new ArrayList<>();

    public void addMailInfo(MailInfo info){
        infos.add(info);
    }
    public void sendAll() throws MailjetSocketTimeoutException, MailjetException {
        MailSender sender = new MailSender();

        for (MailInfo info:infos){
                try {
                    sender.sendMail(info);
                } catch (MailjetException|MailjetSocketTimeoutException exception){
                    System.out.println("Oops...");
                }
        }
    }
}
