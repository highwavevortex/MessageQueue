import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AuditTest {
    public static void main(String[] args) {
        try {
            // Create Connection
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection;
            connection = connectionFactory.createConnection();
            connection.start();

            // Create Session & Destination
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("audit");

            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // TODO Update this bit with producer.send to get stuff into chrome console

            String text = "Message Received";
            // TextMessage message = session.createTextMessage(text);

            System.out.println(text);

            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
