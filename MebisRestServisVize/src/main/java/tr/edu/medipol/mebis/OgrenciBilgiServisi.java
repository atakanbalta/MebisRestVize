package tr.edu.medipol.mebis;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/ogrenci")
public class OgrenciBilgiServisi {
	
	private static List<String> ogrenciler = new ArrayList<>();
	static {
		ogrenciler.add("Atakan");
		ogrenciler.add("Oguzhan");
		ogrenciler.add("Beyda");
		ogrenciler.add("Burak");
		
	}

	
	@GetMapping("/tumbilgiler")
	public  synchronized List<String> tumBilgiler(){
		return ogrenciler;
	}
	
	
	
	@GetMapping("/ogrenciEkle/{ogrenciAdi}")
	public synchronized List<String> ogrenciEkle(@PathVariable String ogrenciAdi) {
		ogrenciler.add(ogrenciAdi);		
		return ogrenciler;		
	}
	
	
	
	@GetMapping("/ogrenciSil/{ogrenciAdi}")
	public synchronized List<String> ogrenciSil(@PathVariable String ogrenciAdi) {
		ogrenciler.remove(ogrenciAdi);		
		return ogrenciler;		
	}
	
	@GetMapping("/ogrenciGuncelle")
	public synchronized List<String> ogrenciGuncelle(@RequestParam String eskiAd,@RequestParam String yeniAd) {
		
		ogrenciler.remove(eskiAd);
		ogrenciler.add(yeniAd);
		return ogrenciler;
		
		//-------------------NOT EKLEME GUNCELLEME------------------------------------------//
	}
	
	
	//TODO
	@GetMapping("/notEkle")
	public synchronized List<String> notEkle(@RequestParam String ogrenciAdi, @RequestParam String not,@RequestParam String guncelNot) {
		ogrenciler.remove(ogrenciAdi);
		
		ogrenciler.remove(ogrenciAdi+" "+not);
		ogrenciler.add(ogrenciAdi+" "+not.replace(not, guncelNot));
		ogrenciler.remove(ogrenciAdi+" "+not);	
		return ogrenciler;
		
}
	
	
	
	
	
	
	
	
	

}
