package model

import java.util.List
import org.uqbar.commons.model.ObservableUtils
import org.uqbar.commons.utils.Observable
import villain.Villain
import country.Country
import country.InterestPlace
import country.Places
import gameCase.Case

@Observable
class GameSystem {
	
	@Property
	List<Country> worldMap
	
	@Property
	List<Villain> files
	
	@Property
	List<Case> cases
	
	@Property
	List<InterestPlace> interestPlaces
	
	Case newCase
	
	
		
	new(){ 
		files = newArrayList
		worldMap = newArrayList
		cases = newArrayList
		fillInterestPlaces()
		}
	
	def fillInterestPlaces() {
		interestPlaces = newArrayList
		interestPlaces.add(new InterestPlace => [name = Places.Banco])
		interestPlaces.add(new InterestPlace => [name = Places.Club])
		interestPlaces.add(new InterestPlace => [name = Places.Biblioteca])
		interestPlaces.add(new InterestPlace => [name = Places.Embajada])
	}
	
	def addVillains(Villain villain){
		files.add(villain)
		ObservableUtils.firePropertyChanged(this,"files", files)
		}
		
	def getVillains(){
		files
	}
	
	def addCountries(Country country){
		worldMap.add(country)
		ObservableUtils.firePropertyChanged(this,"worldMap", worldMap)
	}
	
	def removeCountries(Country country){
		worldMap.remove(country)
		ObservableUtils.firePropertyChanged(this,"worldMap", worldMap)
	}
	
	def addInterestPlaces(InterestPlace place){
		interestPlaces.add(place)
		ObservableUtils.firePropertyChanged(this,"interestPlaces", interestPlaces)
	}
	
//	def generateCase(){
//		val index = 0 as int
//		index = files.size
//		newCase = new Case
//		newCase.caseVillain(files.r)
//	}
	
}