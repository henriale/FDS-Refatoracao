import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bar {
    private Map<String, Cliente> clientes;

    public Bar() {
        this.clientes = new HashMap<>(10);
    }

    public List<Cliente> consultaClientes(){
        return (List<Cliente>) clientes.values();
    }

    public Cliente consultaCliente(String cpf) {
        if (clientes.containsKey(cpf)){
            return clientes.get(cpf);
        }

        return null;
    }

    public int quantidadeClientes() {
        return clientes.size();
    }

    public double[] percentualGenero() {
        int m = 0;
        int f = 0;
        double[] retorno = new double[2];

        for (Map.Entry<String, Cliente> cliente : clientes.entrySet()) {
            if (cliente.getValue().getGenero() == 'M') {
                m++;
            } else {
                f++;
            }
        }

        retorno[0] = m/clientes.size();
        retorno[1] = f/clientes.size();

        return retorno;
    }

    public double[] percentualSocios() {
        int socio = 0;
        int naoSocio = 0;
        double[] retorno = new double[2];

        for (Map.Entry<String, Cliente> cliente : clientes.entrySet()) {
            if (cliente instanceof Socio) {
                socio++;
            } else {
                naoSocio++;
            }
        }

        retorno[0] = socio/clientes.size();
        retorno[1] = naoSocio/clientes.size();

        return retorno;
    }

    public void addCliente(Cliente cliente) {
        if (!clientes.containsKey(cliente.getCpf())) {
            clientes.put(cliente.getCpf(), cliente);
        }

    }

    public void removeCliente(String cpf){
        for (Map.Entry<String, Cliente> cliente : clientes.entrySet()){
            if (cliente.getValue().getCpf().equals(cpf)){
                clientes.remove(cpf);
            }
        }
    }

    public boolean contemCpf(String cpf) {
        return !clientes.containsKey(cpf);
    }
}
