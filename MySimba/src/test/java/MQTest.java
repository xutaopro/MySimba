import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ActiveMq.MQReceiver;
import com.ActiveMq.MessageSend;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext.xml"})
public class MQTest {

	@Test
	public void test(){
		MessageSend send = new MessageSend();
		MQReceiver receiver = new MQReceiver();
		final String key = "MyMessage";
		send.send("MyMessage", "tangtang i love your");
		receiver.receiver(key);
	}
}
