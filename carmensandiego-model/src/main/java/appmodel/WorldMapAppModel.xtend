package appmodel

import model.GameSystem
import country.Country
import org.uqbar.commons.utils.Observable

@Observable
class WorldMapAppModel {
	@Property
	GameSystem gameSystem
	
	@Property
	Country selectedCountry
	
	new(GameSystem gameSystem){
		this.gameSystem = gameSystem
	}
	
	def removeCountry(){
		gameSystem.removeCountries(selectedCountry)
	}
}