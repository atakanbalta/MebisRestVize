package tr.edu.medipol.mebis;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
public class OgrenciBilgiServisiTest {

// Öğrenci Kontrol------------------------------------------
		@Test 
		public void testSonucuBul() {
			//Given  - Koşullar - Ön Şartlar
		List<String> ogrenciler = new ArrayList<>();
			 {
				 String std1 ="Atakan";
				 String std2 ="Ömer";
				 String std3 ="Taylan";
				 
		   //When 	
			
			ogrenciler.add(std1);
			ogrenciler.add(std2);
			ogrenciler.add(std3);
				
		  //Then - Kontrol	
				assertEquals("Atakan",std1);
				assertEquals("Ömer",std2);
				assertEquals("Taylan",std3);
				
			}

		}
// Öğrenci Kontrol/>------------------------------------------		
		
	@GetMapping("/ogrenciEkle/{ogrenciAdi}")
	@Test
	//OgrenciEkleTesti
	//Given
	public void   OgrenciEkle() {
		List<String> ogrenciler = new ArrayList<>();
		 {
			 String std1 ="Oğuz";
		 }
		 //When
		 String newstd="Eren";
		 ogrenciler.add(newstd);
		 //Then
		 assertEquals(newstd,"Eren");
	   
	}
//OgrenciSil------------------------------------------------------------
	@GetMapping("/ogrenciSil/{ogrenciAdi}")
	@Test	
	public void OgrenciSil() {
	
		//Given
			List<String> ogrenciler = new ArrayList<>();
			 {
				 
				 String std3 ="Ali";
				 
			//When	 
				 
				 ogrenciler.remove(std3);
		    
			//Then	 
				 assertEquals(std3,"Ali");
			 }
	}
//OgrenciSil------------------------------------------------------------		
		

	
//OgrenciGuncellemeTesti---------------------------------------------------------------
	@GetMapping("/ogrenciGuncelle")
	@Test
	public void OgrenciGuncelle() {
		
		
		//Given
		List<String> ogrenciler = new ArrayList<>();
		 {
			 String std1 ="Kayra";
			 
		//When	 
			std1 = "Kayra";
			 ogrenciler.remove(std1);
				ogrenciler.add(std1);
		//Then		
				assertEquals(std1,"Kayra");
				
		 }
		 
	}
//OgrenciNotEkle------------------------------------------------------------------------
	@GetMapping("/ogrenciNotEkle")
	@Test
	public void ogrenciNotEkle() {
		
		List<String> ogrenciler = new ArrayList<>();
		 {
			 String std1 ="Dilara";
			 
			 
			 String not="100";
			 String guncelNot ="2";		
			 ogrenciler.remove(std1+" "+not);
				ogrenciler.add(std1+" "+not.replace(not, guncelNot));
				ogrenciler.remove(std1+" "+not);
			 
				assertEquals(std1,"Dilara");
				assertEquals(not,"100");
				assertEquals(guncelNot,"2");
				
		 }
		
	}
	
}
