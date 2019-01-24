/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfranc.ilc;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author cp071232
 */
public class PaquisClementTest {
    
	String[] when2SimpleWords = new String[] {"parapluie", "parachute"};
	
	@Test
	public void getSimilarity_2SimpleWords_26() {
		
		MarkovWord m = new MarkovWord();
		double expected = 0.33;
		double actual = m.getSimilarity(when2SimpleWords[0],when2SimpleWords[1], 2);
		assertEquals(expected, actual,0.01);		
	}
        
        	@Test
	public void getSimilarity_SameWord_100() {
		
		MarkovWord m = new MarkovWord();
		double expected = 1.0;
		double actual = m.getSimilarity(when2SimpleWords[0],when2SimpleWords[0], 4);
		assertEquals(expected, actual,0.000000001);		
	}
        
         @Test
        public void common_SameWord_1(){
            
            //on remplit deux listes de mots avec 1 mot en commun
            MarkovWord m = new MarkovWord();
            
            //liste 1
            MarkovData m1 = new MarkovData("Ninja",5);
            MarkovData m2 = new MarkovData("Test",5);
            
            // liste 2
            MarkovData m3 = new MarkovData("Ninja",5);
            MarkovData m4 = new MarkovData("Tester",5);            
            
            //creation des listes et ajout des mots
            List<MarkovData> one = new ArrayList<MarkovData>();
            List<MarkovData> two = new ArrayList<MarkovData>();
            
            one.add(m1);
            one.add(m2);
            two.add(m3);
            two.add(m4);
             
            //on attend un mot en commun
            int expected = 1;
            int actual = m.common(one, two);
            assertEquals(expected, actual);            
        }

        
        @Test
        public void common_SameWordUpperCase_1(){
            
            //on remplit deux listes de mots avec 1 mot en commun : l'un en majuscule et l'autre non
            MarkovWord m = new MarkovWord();
            
            //liste 1 avec le mot en majuscule
            MarkovData m1 = new MarkovData("NINJA",5);
            MarkovData m2 = new MarkovData("Test",5);
            
            // liste 2 avec le mot en minuscule
            MarkovData m3 = new MarkovData("Ninja",5);
            MarkovData m4 = new MarkovData("Tester",5);            
            
            //création des listes et ajout des mots
            List<MarkovData> one = new ArrayList<MarkovData>();
            List<MarkovData> two = new ArrayList<MarkovData>();
            
            one.add(m1);
            one.add(m2);
            two.add(m3);
            two.add(m4);
             
            // on attend un mot en commun
            int expected = 1;
            int actual = m.common(one, two);
            assertEquals(expected, actual);            
        }
        
        @Test
        public void common_SameWordSpecial_2(){
            
            //on remplit deux listes de mots avec 1 mot en commun et un qui contient des caracteres spéciaux
            MarkovWord m = new MarkovWord();
            
            //liste 1
            MarkovData m1 = new MarkovData("Ninja",5);
            MarkovData m2 = new MarkovData("Teste",5);
            
            // liste 2
            MarkovData m3 = new MarkovData("Ninja",5);
            MarkovData m4 = new MarkovData("Testé",5);            
            
            //création des listes et ajout des mots
            List<MarkovData> one = new ArrayList<MarkovData>();
            List<MarkovData> two = new ArrayList<MarkovData>();
            
            one.add(m1);
            one.add(m2);
            two.add(m3);
            two.add(m4);
            
            //on attend 1 mot en commun
            int expected = 1;
            int actual = m.common(one, two);
            assertEquals(expected, actual);            
        }
        
        
        @Test
        public void common_SameWordSpace_2(){
            //on remplit deux listes de mots avec 1 mot en commun et un qui contient un espace
            MarkovWord m = new MarkovWord();
            
            //liste 1
            MarkovData m1 = new MarkovData("Ninja",5);
            MarkovData m2 = new MarkovData("Teste",5);
            
            // liste 2
            MarkovData m3 = new MarkovData("Ninja",5);
            MarkovData m4 = new MarkovData("Test e",5);            
            
            //creation des listes et ajout des mots
            List<MarkovData> one = new ArrayList<MarkovData>();
            List<MarkovData> two = new ArrayList<MarkovData>();
            
            one.add(m1);
            one.add(m2);
            two.add(m3);
            two.add(m4);
             
            //on attend un mot en commun
            int expected = 1;
            int actual = m.common(one, two);
            assertEquals(expected, actual);            
        }
        
        @Test
        public void union_SameWords_4(){
            //on remplit deux listes avec 2 mots en commun
            MarkovWord m = new MarkovWord();
            
            //liste 1
            MarkovData m1 = new MarkovData("A",1);
            MarkovData m2 = new MarkovData("B",1);
            MarkovData m3 = new MarkovData("C",1);
            
            // liste 2
            MarkovData m4 = new MarkovData("A",1);
            MarkovData m5 = new MarkovData("B",1); 
            MarkovData m6 = new MarkovData("D",1);
            
            //creation des listes et ajout des mots
            List<MarkovData> one = new ArrayList<MarkovData>();
            List<MarkovData> two = new ArrayList<MarkovData>();
            
            one.add(m1);
            one.add(m2);
            one.add(m3);
            two.add(m4);
            two.add(m5);
            two.add(m6);
             
            //on attend 4 car m1 = m4 et m2 = m5
            int expected = 4;
            int actual = m.union(one, two);
            assertEquals(expected, actual);  
        }
        
        @Test
        public void union_SameWordsUpperCase_4(){
            //on remplit deux listes avec 2 mots en commun dont un en majuscule
            MarkovWord m = new MarkovWord();
            
            //liste 1
            MarkovData m1 = new MarkovData("A",1);
            MarkovData m2 = new MarkovData("B",1);
            MarkovData m3 = new MarkovData("C",1);
            
            // liste 2
            MarkovData m4 = new MarkovData("a",1);
            MarkovData m5 = new MarkovData("b",1); 
            MarkovData m6 = new MarkovData("D",1);
            
            //creation des listes et ajout des mots
            List<MarkovData> one = new ArrayList<MarkovData>();
            List<MarkovData> two = new ArrayList<MarkovData>();
            
            one.add(m1);
            one.add(m2);
            one.add(m3);
            two.add(m4);
            two.add(m5);
            two.add(m6);
             
            //on attend 4 car m1 = m4 et m2 = m5
            int expected = 4;
            int actual = m.union(one, two);
            assertEquals(expected, actual);  
        }
    
        @Test
        public void union_SameWords_6(){
            //on remplit deux listes avec 2 mots en commun
            MarkovWord m = new MarkovWord();
            
            //liste 1
            MarkovData m1 = new MarkovData("A",1);
            MarkovData m2 = new MarkovData("B",1);
            MarkovData m3 = new MarkovData("C",1);
            
            // liste 2
            MarkovData m4 = new MarkovData("D",1);
            MarkovData m5 = new MarkovData("E",1); 
            MarkovData m6 = new MarkovData("F",1);
            
            //creation des listes et ajout des mots
            List<MarkovData> one = new ArrayList<MarkovData>();
            List<MarkovData> two = new ArrayList<MarkovData>();
            
            one.add(m1);
            one.add(m2);
            one.add(m3);
            two.add(m4);
            two.add(m5);
            two.add(m6);
             
            //on attend 6 car tous les mots sont différents
            int expected = 6;
            int actual = m.union(one, two);
            assertEquals(expected, actual);  
            
        }
        
        @Test
        public void contains_String_1(){
            //on crée un mot et on choisit 2 lettres par 2 lettres
            MarkovWord m = new MarkovWord("ninja",2);
            
            //on attend 1
            int expected = 1;
            int actual = m.contains("ni");
            assertEquals(expected,actual);
        }
        
        @Test
        public void contains_String_0(){
            //on crée un mot et on choisit 2 lettres par 2 lettres
            MarkovWord m = new MarkovWord("test",2);
            
            //on attend 0
            int expected = 0;
            int actual = m.contains("ni");
            assertEquals(expected,actual);
        }
        
        @Test
        public void processString_1(){
            MarkovWord m = new MarkovWord();
            List<MarkovData> expected = new ArrayList<MarkovData>();
            expected.add(new MarkovData("%a",1));
            expected.add(new MarkovData("av",1));
            expected.add(new MarkovData("v%",1));
            List<MarkovData> actual = m.processString("av", 2);
            assertEquals(expected, actual);
        }
}
