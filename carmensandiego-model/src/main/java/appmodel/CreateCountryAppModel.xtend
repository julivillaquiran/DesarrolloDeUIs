package appmodel

import country.Country
import country.InterestPlace
import model.GameSystem
import org.uqbar.commons.utils.Observable

@Observable
class CreateCountryAppModel {
	@Property
	Country country
	
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
	GameSystem gameSystem
	
	new(GameSystem gameSystem, Country selectedCountry){
		this.gameSystem = gameSystem
		country = selectedCountry
		getPossibleConnections
	}
	
	def getPossibleConnections(){
		country.getPossibleConnections(gameSystem)
	}
	
	def addCountry() {
		if((!gameSystem.worldMap.contains(country)) && (country.name!=null))
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