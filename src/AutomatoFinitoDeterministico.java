import java.util.*;

public class AutomatoFinitoDeterministico {

    private Set<Estado> estados;
    private Set<Character> alfabeto;
    private Estado estadoInicial;
    private Set<Estado> estadosFinais;
    private Map<Estado, Map<Character, Estado>> funcaoDeTransicao;

    public AutomatoFinitoDeterministico(Set<Estado> estados, Set<Character> alfabeto, Estado estadoInicial, Set<Estado> estadosFinais) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
        this.funcaoDeTransicao = new HashMap<>();

        for (Estado estado : this.estados) {
            this.funcaoDeTransicao.put(estado, new HashMap<>());
        }
    }

    public void definirTransicoes(Estado estadoOrigem, Character simbolo, Estado estadoDestino) {
        this.funcaoDeTransicao.get(estadoOrigem).put(simbolo, estadoDestino);
    }

    public void verificarCadeia(String cadeia) {
        Estado estadoAtual = estadoInicial;

        for (char simbolo : cadeia.toCharArray()) {
            if (!this.alfabeto.contains(simbolo)) {
                throw new RuntimeException("Simbolo Inválido");
            }

            estadoAtual = funcaoDeTransicao.get(estadoAtual).get(simbolo);
        }

        if (this.estadosFinais.contains(estadoAtual)) {
            System.out.println("Cadeia Aceita");
        } else {
            System.out.println("Cadeia Rejeitada");
        }
    }
    public void verificarCadeiaQ9(String cadeia) {
        Estado estadoAtual = estadoInicial;
        int numero0 = 0;
        int numero1 = 0;
        for (char simbolo : cadeia.toCharArray()) {
            if (!this.alfabeto.contains(simbolo)) {
                throw new RuntimeException("Simbolo Inválido");
            }
            if (simbolo == 0) {
                numero0++;
            } else {
                numero1++;
            }
            estadoAtual = funcaoDeTransicao.get(estadoAtual).get(simbolo);
        }
        if (numero0 > numero1) {
            System.out.println("Cadeia Aceita");
        } else {
            System.out.println("Cadeia Rejeitada");
        }
    }
}