package resources;

import jakarta.jws.WebService;

@WebService(endpointInterface = "resources.ICalculadora")
public class Calculadora implements ICalculadora{

    @Override
    public double somar(double x, double y) {
        double s = x + y;
        return s;
    }

    @Override
    public double raiz(double x) {
        double r = Math.sqrt(x);
        return r;
    }
}
