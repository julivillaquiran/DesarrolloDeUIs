package country

import org.uqbar.commons.model.ObservableUtils
import org.uqbar.commons.utils.Observable
import java.util.List
import model.GameSystem

@Observable
class Country {
	@Property 
	String name
	
	@Property 
	List<String> characteristics = newArrayList
	
	@Property 
	List<InterestPlace> places = newArrayList
	
	@Property 
	List<Country> connections = newArrayList
	
	def addCharacteristics(String newCharacteristic) {
		characteristics.add(newCharacteristic)
		ObservableUtils.firePropertyChanged(this,"characteristics", characteristics)
	}
	
	def takeCharacteristics(String characteristic) {
		characteristics.remove(characteristic)
		ObservableUtils.firePropertyChanged(this,"characteristics", characteristics)		
	}
	
	def addPlaces(InterestPlace place) {
		if(places.size <= 2)
			places.add(place)
		ObservableUtils.firePropertyChanged(this,"places", places)
	}
	
	def takePlaces(InterestPlace place) {
		places.remove(place)
		ObservableUtils.firePropertyChanged(this,"places", places)		
	}
	
	def addConnections(Country country) {
		connections.add(country)
		ObservableUtils.firePropertyChanged(this,"connections", connections)		
	}
	
	def takeConnections(Country country) {
		connections.remove(country)
		ObservableUtils.firePropertyChanged(this,"connections", connections)
	}
	
	def getPossibleConnections(GameSystem system) {
		system.worldMap.filter[c | !connections.contains(c)].toList
	}
	
}