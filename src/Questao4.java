import java.util.*;

public class Questao4 {
    public static void main(String[] args) {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");

        Set<Estado> estados = new HashSet<>();
        estados.addAll(Arrays.asList(q0, q1));

        Set<Estado> estadosFinais = new HashSet<>();
        estadosFinais.add(q0);

        Estado estadoInicial = q0;

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.addAll(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, estadoInicial, estadosFinais);

        //questão 4
        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', q1);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q1);


        afd.verificarCadeia("0");
    }
}