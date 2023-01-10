import BuilderStrategy.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMail {
    private final Client client0 = new Client("Sviat", "sviatoslav.lushnei@ucu.edu.ua", 18, Gender.MALE);
    private final Client client1 = new Client("Random", "random.email@not.existed.domain", 123, Gender.FEMALE);

    private final MailCode mailCode = new MailCodeGift();
    @Test
    public void testClient(){
        Assertions.assertEquals(client0.getName(), "Sviat");
        Assertions.assertEquals(client1.getEmail(), "random.email@not.existed.domain");
        Assertions.assertNotEquals(client0.getSex(), client1.getSex());
        Assertions.assertEquals(client0.getId()+1, client1.getId());
    }

    @Test
    public void testMailInfo(){
        MailInfo mailInfo = new MailInfo(client0, mailCode);
        Assertions.assertEquals(mailInfo.getClient().getName(), client0.getName());
        Assertions.assertEquals(mailInfo.getClient().getEmail(), client0.getEmail());
        Assertions.assertTrue(mailInfo.getMailCode().generateText(client0).startsWith("Congratulations"));
    }
    @Test
    public void testBox() throws MailjetSocketTimeoutException, MailjetException {
        MailBox mailbox = new MailBox();
        MailInfo mailInfo = new MailInfo(client1, mailCode);

        mailbox.addMailInfo(mailInfo);

        Assertions.assertEquals(mailbox.getInfos().size(), 1);
        Assertions.assertEquals(mailbox.getInfos().get(0), mailInfo);

        boolean valid = false;
        try {
            mailbox.sendAll();
            valid = true;
        } catch (Exception ignored) {}
        Assertions.assertTrue(valid);
    }
}
