import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
	public static void main(String[] args) throws InterruptedException {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Ahsen");
		names.add("Şevval");
		names.add("Asiye");
		names.add("Mesut");
		names.add("Bayram");
		names.add("Barış");

		List<String> names1 = Arrays.asList("Abdullah", "Onur", "Rukiye", "Nazlı", "Rabia", "Mert", "Hüseyin", "Ali",
				"Alş", "Alara");
		// iki listeyi birleştirdim concat() ile ve ekrana yazdırdım ALFABETİK SIRADA
		Stream<String> newNames = Stream.concat(names.stream(), names1.stream());
		newNames.sorted().forEach(s -> System.out.println(s));
		Thread.sleep(2000);
		System.out.println("--------------");
		// eğer birleştirdiğim listede Ayşe var mı diye bakmak istersem
		/*
		 * boolean dönecek --> newNames.anyMatch(s->s.equalsIgnoreCase("Ayşe")); o
		 * yüzden boolean değişen tanımlayacağım
		 */
//		boolean flag = newNames.anyMatch(h -> h.equalsIgnoreCase("Ayşe"));
//		System.out.println(flag);
//		Assert.assertTrue(flag); /* Ayşe listelerde olmadığından java hata verecektir */
    
		System.out.println("------------------");
		
		List<String> ls=Stream.of("Akın", "Onur", "Rukiye", "Nazlı", "Rabia", "Mert", "Hüseyin").filter(s->s.endsWith("n")).map(s->s.toUpperCase())
				.collect(Collectors.toList());//burada da filtrelediğim isimleri liste yaptım .collect(Collectors.toList()) ile
		ls.forEach(s->System.out.println(s)); // AKIN HÜSEYİN yazar konsolda
		System.out.println("------------------");
		System.out.println(ls.get(0)); // burada da filtrelediğim isimleri oluşturduğum ls listesinden birinci elamanı aldım
		
		System.out.println("------------------");
		//values listesini oluşturdum arrayden liste dönüşüm
		/* listedeki değerleri sadece bir defa kullanarak yazar mesele 1 den 4 tane varsa 1 tane yazar
		 * bunu distinc() ile sağlıyorum. çıktısı şu şekilde olur
		 * [1, 2, 28, 12, 3, 8, 4, 0, 9] 
		 * eğer sorted kullanırsam tahmşn edileceği gibi küçükten büyüğe doğru sıralar
		 * [0, 1, 2, 3, 4, 8, 9, 12, 28] */
		List<Integer> values= Arrays.asList(1,2,2,2,1,28,12,3,8,3,8,8,4,0,9,1,12,28,28,2,28);
		List<Integer> list1=values.stream().distinct().sorted().collect(Collectors.toList()); 
		System.out.println(list1);
		System.out.println("------------------");
		System.out.println(list1.get(5));/*sorted kullandığım için 5.index 8 olacaktır*/

	}
}
