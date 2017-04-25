package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
//		Comparator<String> comparador = new ComparadorDeStringPorTamanho();
//		palavras.sort(comparador);
		
		palavras.sort((s1, s2) -> s1.length() - s2.length());
		
		palavras.forEach(s -> System.out.println(s));
		
		Function<String, String> funcao = s -> s;
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);
		palavras.forEach(System.out::println);
		
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		palavras.forEach(System.out::println);
		
		//Method reference
		palavras.sort(Comparator.comparing(String::length));
		palavras.forEach(System.out::println);
		
		
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}
	
}

class ComparadorDeStringPorTamanho implements Comparator<String> {
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length()) 
            return -1;
        if(s1.length() > s2.length()) 
            return 1;
        return 0;
    }
}
