package appmodel

import org.uqbar.commons.utils.Observable
import country.Country

@Observable
class TravelWindowAppModel {
	@Property
	SolveCaseWindowAppModel solveCaseWindowAppModel
	
	@Property
	Country	countryToTravel
	
	@Property
	boolean notFirstCountry
	
	
	new(SolveCaseWindowAppModel solveCaseWindowAppModel){
		this.solveCaseWindowAppModel = solveCaseWindowAppModel
		if(solveCaseWindowAppModel.currentPath.size == 1)
			notFirstCountry = false
		else
			notFirstCountry  = true
	}
	
	def travel(){
		if(countryToTravel!=null){
			solveCaseWindowAppModel.currentCountry = countryToTravel
			solveCaseWindowAppModel.addCountryToPath(solveCaseWindowAppModel.currentCountry)
			
			}
	}
	
	def travelBack(){
		if(notFirstCountry){
			solveCaseWindowAppModel.currentCountry = solveCaseWindowAppModel.currentPath.get(solveCaseWindowAppModel.currentPath.size-2)
			solveCaseWindowAppModel.addCountryToPath(solveCaseWindowAppModel.currentPath.get(solveCaseWindowAppModel.currentPath.size-2))
			}
	}
	
}