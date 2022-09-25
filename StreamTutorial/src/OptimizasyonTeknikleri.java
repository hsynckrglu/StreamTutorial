import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class OptimizasyonTeknikleri {

	// optimizasyon Teknikleri
	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Ahmet");
		names.add("Mehmet");
		names.add("Ali");
		names.add("Ayşe");
		names.add("Hüseyin");
		names.add("Cafer");
		names.add("Rukiye");
		names.add("Rabia");
		names.add("Onur");
		names.add("Mert");
		names.add("Can");
		names.add("Leyla");
		names.add("Asım");
		names.add("Aslı");
		names.add("abdullah");
		names.add("Fatma");
		names.add("Nazlı");
		names.add("Kürşad");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) { // büyük küçük harf duyarlılığı var!
				count++;
			}

		}

		System.out.println("A ile başlayanların sayısı: " + count); // ismi A ile başlayan isimlerin sayısı
		System.out.println("Dizi boyutu: " + names.size()); // names arrayin boyutu

		Long a = names.stream().filter(burayaİstediğiniTanımla -> burayaİstediğiniTanımla.startsWith("A")).count();
		/* A ile başlayanların sayısını veren kod */
		System.out.println("A ile başlayanların sayısı: " + a);
		/*
		 * int count = 0; for (int i = 0; i < names.size(); i++) { String actual =
		 * names.get(i); if (actual.startsWith("A")) { count++; } } bu kodla
		 * yazdıklarımı bununla da yazabiliyorum
		 * 
		 * Long a = names.stream().filter(s -> s.startsWith("A")).count();
		 * System.out.println("A ile başlayanların sayısı: " + a);
		 *
		 */
		System.out.println("---------------------");

		Long hc = Stream.of("Abdullah", "Onur", "Rukiye", "Nazlı", "Rabia", "Mert", "Hüseyin").filter(s -> {
			s.startsWith("R");
			return true;
		}).count();
		System.out.println("Stream.of ile eklenen verilerin sayısı=" + hc);

		System.out.println("---------------------");
		Long hc1 = Stream.of("Abdullah", "Onur", "Rukiye", "Nazlı", "Rabia", "Mert", "Hüseyin")
				.filter(s -> s.startsWith("H")).count();
		System.out.println(hc1);
		System.out.println("---------------------");

		// isminin uzunluğu 5 harfi geçenlerin filtrelenip ekrana yazıldığı
		names.stream().filter(q -> q.length() > 5).forEach(q -> System.out.println(q));

		System.out.println("---------------------");

		/*
		 * isminin uzunluğu 5ten büyük olanlar limit() ile sınırlanıyor. örneğin limitin
		 * içine 2 yazarsam listelenecek isimler 2 tane ve en bastan doğru sıralanıyor
		 * yani şu şekilde limit() olmasaydı ismi 5 harf fazlası olanalr şunlardı Mehmet
		 * Hüseyin Rukiye abdullah Kürşad. limit(1)--> sadece mehmet , limit(2)--> mehmet
		 * hüseyin bastan filtreliyor.
		 */
		names.stream().filter(q -> q.length() > 5).limit(3).forEach(q -> System.out.println(q));
		System.out.println("---------------------");

		// ismi a ile biten isimleri hepsini büyük harf yapıp ekrana yazdırdı. Rabia-->
		// RABİA gibi
		names.stream().filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println("---------------------");

		// Listedeki tüm isimleri büyü harfle yazar
		names.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println("---------------------");

		/*
		 * İsmi A ile başlayan isimleri alfabetik yazdırma sorted() metodu ile
		 * yapıyorum. sorted olmasaydı isimler; ABDULLAH ALİ ALŞ ALARA diye
		 * listelenecekti ama sorted kullanınca ABDULLAH ALARA ALİ ALŞ diye listelendi
		 */
		List<String> newName = Arrays.asList("Abdullah", "Onur", "Rukiye", "Nazlı", "Rabia", "Mert", "Hüseyin", "Ali",
				"Alş", "Alara");
		newName.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

	}
}
