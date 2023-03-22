import jakarta.xml.ws.Endpoint;
import resources.Calculadora;

public class Application {
    public static void main(String[] args) {

        Endpoint.publish(
                "http://127.0.0.1:8080/calculadora-ws",
                 new Calculadora()
                );
    }
}
