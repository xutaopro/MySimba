package com.ActiveMq;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSend {

	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void send(final String name,final String mess){
		if(jmsTemplate==null){
			System.out.println(".......................null");
			ClassPathXmlApplicationContext app= new ClassPathXmlApplicationContext("classpath:springMQ.xml");
			jmsTemplate = (JmsTemplate) app.getBean("jmsTemplate");
		}
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				MapMessage message = session.createMapMessage();
				message.setString(name, mess);
				return message;
			}
		});
	}
}
