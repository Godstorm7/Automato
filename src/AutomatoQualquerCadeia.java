import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AutomatoQualquerCadeia {
    private Set<Estado> estados;
    private Set<Character> alfabeto;
    private Estado estadoInicial;
    private Set<Estado> estadosFinais;
    private Map<Estado, Map<Character, Estado>> funcaoDeTransicao;

    public AutomatoQualquerCadeia() {
        Estado q0 = new Estado("q0");

        estados = new HashSet<>();
        estados.add(q0);

        alfabeto = new HashSet<>();
        alfabeto.add('0');
        alfabeto.add('1');

        estadoInicial = q0;

        estadosFinais = new HashSet<>();
        estadosFinais.add(q0);

        funcaoDeTransicao = new HashMap<>();
        for (Estado estado : estados) {
            funcaoDeTransicao.put(estado, new HashMap<>());
        }

        funcaoDeTransicao.get(q0).put('0', q0);
        funcaoDeTransicao.get(q0).put('1', q0);
    }

    public boolean verificarCadeia(String cadeia) {
        Estado estadoAtual = estadoInicial;

        for (char simbolo : cadeia.toCharArray()) {
            if (!alfabeto.contains(simbolo)) {
                throw new RuntimeException("Símbolo Inválido");
            }
            estadoAtual = funcaoDeTransicao.get(estadoAtual).get(simbolo);
            if (estadoAtual == null) {
                return false;
            }
        }

        return estadosFinais.contains(estadoAtual);
    }

    public static void main(String[] args) {
        AutomatoQualquerCadeia afd = new AutomatoQualquerCadeia();
        String cadeia = "0101";
        if (afd.verificarCadeia(cadeia)) {
            System.out.println("A cadeia é aceita.");
        } else {
            System.out.println("A cadeia não é aceita.");
        }
    }
}