package stream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ExerciciosStreamApi {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
            System.out.println("Imprima todos os elementos dessa lista de String: ");
            numerosAleatorios.forEach(System.out::println);

        System.out.println("\nPegue os 5 primeiros números e coloque dentro de um Set:");
        numerosAleatorios.stream()
        .limit(5)
        .collect(Collectors.toSet())
        .forEach(System.out::println);

        System.out.println("\nTransforme esta lista de String em uma lista de números inteiros.");
        List<Integer> collectList = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
            collectList.forEach(System.out::println);
        
       System.out.println("\nPegue os números pares e maiores que 2 e coloque em uma lista:");
       List<Integer> listParesMaiorQue2 = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .filter(i -> (i % 2 == 0 && i > 2))
            .collect(Collectors.toList());
       System.out.println(listParesMaiorQue2);
       
       System.out.println("\nMostre a média dos números: ");
       numerosAleatorios.stream()
       .mapToInt(Integer::parseInt)
       .average()
       .ifPresent(System.out::println);

       System.out.println("\nRemova os valores impares:" );
       collectList.removeIf(i -> (i % 2 !=0));
       System.out.println(collectList);

       System.out.println("\nIgnore os 3 primeiros elementos da lista e imprima o restante: ");
       List<Integer> listaNumericos = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
       List<Integer> ignorandoTresPrimeiros = listaNumericos.subList(3, listaNumericos.size()); 
       System.out.println(ignorandoTresPrimeiros);

       System.out.println("\nRetirando os números repetidos da lista, quantos números fica? ");
       Set<Integer> retiradoNumerosRepetidios = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toSet());
            System.out.println("Ficam " + retiradoNumerosRepetidios.size() + " números. \n" + retiradoNumerosRepetidios);

       System.out.println("\nMostre o menor valor da lista: ");
       listaNumericos.stream()
       .min(Integer::compareTo)
       .ifPresent(System.out::println);

       System.out.println("\nMostre o maior valor da lista: ");
        listaNumericos.stream()
       .max(Integer::compareTo)
       .ifPresent(System.out::println);

       System.out.println("\nPegue apenas os números impares e some: ");
       List<Integer> listImparesSomado = listaNumericos.stream()
       .filter(i -> (i % 2 == 1))
       .collect(Collectors.toList());
       int soma = listImparesSomado.stream().mapToInt(Integer::intValue).sum();
       System.out.println("Lista: " + listImparesSomado + "\nSoma: " + soma);

       System.out.println("\nMostre a lista em ordem númerica: ");
       System.out.println(listaNumericos.stream().sorted().collect(Collectors.toList()));

       System.out.println("\nAgrupe os valores impares múltiplos de 3 e de 5: ");
       Map<String,List<Integer>> listaImparesAgrupada = listaNumericos.stream()
       .filter(i -> (i % 2 == 1))
       .collect(Collectors.groupingBy(i -> {
          if (i % 3 == 0 && i % 5 == 0) return "Multiplos de 3 e 5";
          else if (i % 3 == 0) return "Multiplos de 3";
          else if (i % 5 == 0) return "Multiplos de 5";
          else return "Outros ímpares";
       }));
       listaImparesAgrupada.forEach((categoria, numeros) ->  
          System.out.println(categoria + ": " + numeros));
    }
} 