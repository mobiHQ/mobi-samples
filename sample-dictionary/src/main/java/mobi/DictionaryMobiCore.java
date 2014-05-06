package mobi;
/*
 * Dependencies:
 * 		mobi-core.jar
 */

import mobi.core.Mobi;
import mobi.core.common.Relation;
import mobi.core.concept.Class;
import mobi.core.concept.Instance;

public class DictionaryMobiCore {
	
	
	// Main Method
	public static void main(final String[] args){
		
		Mobi mobi = loadDomain();
	}
	
	
	
	public static Mobi loadDomain(){
		
		Mobi mobi = new Mobi("Dictionary");
		try {
		
		//Instances
		Instance iDictionary = new Instance("dictionary");
		Instance iMaravilhoso = new Instance("maravilhoso");
		Instance iGrande = new Instance("grande");
		Instance iWonderful = new Instance("wonderful");
		Instance iMarvelous = new Instance("marvelous");
		Instance iAmazing = new Instance("amazing");
		Instance iBig = new Instance("big");
		Instance iLarge = new Instance("large");
		
		mobi.addConcept(iDictionary);
		mobi.addConcept(iMaravilhoso);
		mobi.addConcept(iGrande);
		mobi.addConcept(iWonderful);
		mobi.addConcept(iMarvelous);
		mobi.addConcept(iAmazing);
		mobi.addConcept(iBig);
		mobi.addConcept(iLarge);
		
		
		//Class
		Class cDictionary = new Class("Dictionary");
		Class cWord = new Class("Word");
		Class cTranslatedWord = new Class("TranslatedWord");
		
		mobi.addConcept(cWord);
		mobi.addConcept(cTranslatedWord);
		
		
		// Class x Instances
		mobi.isOneOf(iDictionary, cDictionary);
		mobi.isOneOf(iMaravilhoso, cWord);
		mobi.isOneOf("grande", "Word"); //other way
		mobi.isOneOf(iLarge, cTranslatedWord);
		mobi.isOneOf(iBig, cTranslatedWord);
		mobi.isOneOf("wonderful", "TranslatedWord");
		mobi.isOneOf(iAmazing, cTranslatedWord);
		mobi.isOneOf(iMarvelous, cTranslatedWord);
		
		
		//Attributes
		
		
		//Relations
		
		// Dictionary has words
		Relation rDictionaryHasWords = mobi.createUnidirecionalCompositionRelationship("has-words");
		rDictionaryHasWords.setClassA(cDictionary);
		rDictionaryHasWords.setClassB(cWord);
		
		rDictionaryHasWords.addInstanceRelation(iDictionary, iMaravilhoso);
		rDictionaryHasWords.addInstanceRelation(iDictionary, iGrande);
		rDictionaryHasWords.processCardinality();
		mobi.addConcept(rDictionaryHasWords);
		
		// Word has several translations
		Relation rWordHasTranslations = mobi.createUnidirecionalCompositionRelationship("has-translation");
		rWordHasTranslations.setClassA(cWord);
		rWordHasTranslations.setClassB(cTranslatedWord);
		
		rWordHasTranslations.addInstanceRelation(iMaravilhoso, iAmazing);
		rWordHasTranslations.addInstanceRelation(iMaravilhoso, iMarvelous);
		rWordHasTranslations.addInstanceRelation(iMaravilhoso, iWonderful);
		rWordHasTranslations.addInstanceRelation(iGrande, iBig);
		rWordHasTranslations.addInstanceRelation(iGrande, iLarge);
		rWordHasTranslations.processCardinality();
		mobi.addConcept(rWordHasTranslations);
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mobi;
	}

}
