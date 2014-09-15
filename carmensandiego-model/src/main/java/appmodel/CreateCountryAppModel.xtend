package appmodel

import country.Country
import country.InterestPlace
import model.GameSystem
import org.uqbar.commons.utils.Observable
import java.util.List


@Observable
class CreateCountryAppModel {
	@Property
	Country country
	@Property
	Country selectedCountry
	int indexOfCountry
	
	@Property
	String newCharacteristic
	@Property
	String takenCharacteristic
	
	@Property
	InterestPlace newPlace
	@Property
	InterestPlace takenPlace
	
	@Property
	Country newConnection
	@Property
	Country takenConnection
	@Property
	List<Country> possibleConnections
	
	@Property
	GameSystem gameSystem
	
	@Property
	boolean edit
	
//	ListIterator<Country> iter1
//	ListIterator<Country> iter2

	
	new(GameSystem gameSystem, Country selectedCountry, boolean edit){
		this.gameSystem = gameSystem
		this.edit = edit
		if(edit)
			country = selectedCountry
		else
			country = new Country
		this.indexOfCountry = gameSystem.villains.indexOf(selectedCountry)
//		calculatePossibleConections()
	}
	
//	def calculatePossibleConections() {
//		iter1 = gameSystem.worldMap.listIterator
//				iter2 = country.connections.listIterator
//		while(iter.hasNext)
//			if(gameSystem.worldMap)
//		possibleConnections = gameSystem.worldMap.
//	}
	
	def addCountry(){
		if(!gameSystem.worldMap.contains(country))
			gameSystem.addCountries(country)
	}
	
	def addCharacteristic() {
		if(!country.characteristics.contains(newCharacteristic) && (newCharacteristic!=null))
			country.addCharacteristics(newCharacteristic)
	}
	
	def takeCharacteristic(){
		country.takeCharacteristics(takenCharacteristic)
	}	
	
	def addPlace(){
		if(!country.places.contains(newPlace) && (newPlace!=null))
			country.addPlaces(newPlace)
	}
	
	def takePlace(){
		country.takePlaces(takenPlace)
	}
	
	def addConnection(){
		if(!country.connections.contains(newConnection) && (newConnection!=null) && (newConnection != country))
			country.addConnections(newConnection)
	}
	
	def takeConnection(){
		country.takeConnections(takenConnection)
	}
	
	def getPlaces(){
		gameSystem.interestPlaces
	}	
}