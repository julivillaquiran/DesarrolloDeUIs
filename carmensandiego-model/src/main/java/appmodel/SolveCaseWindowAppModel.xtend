package appmodel

import model.GameSystem
import gameCase.Case
import org.uqbar.commons.utils.Observable
import country.Country
import country.InterestPlace
import org.uqbar.commons.model.ObservableUtils
import villain.Villain
import java.util.List

@Observable
class SolveCaseWindowAppModel {
	@Property
	GameSystem gameSystem

	@Property
	Case thisCase

	@Property
	Country currentCountry

	@Property
	InterestPlace thosePlaces0
	@Property
	InterestPlace thosePlaces1
	@Property
	InterestPlace thosePlaces2

	@Property
	String message
	@Property
	InterestPlace whichPlace

	@Property
	List<Country> currentPath = newArrayList
	@Property
	List<Country> currentPathErrors = newArrayList
	@Property
	List<Country> currentCorrectPath = newArrayList

	@Property
	Villain captureOrder = new Villain => [name = ""]

	new(GameSystem gameSys, Case t) {
		gameSystem = gameSys
		thisCase = t
		currentCountry = thisCase.escapeRoute.get(0)
		thosePlaces0 = currentCountry.places.get(0)
		thosePlaces1 = currentCountry.places.get(1)
		thosePlaces2 = currentCountry.places.get(2)
		currentPath.add(currentCountry)
		currentCorrectPath.add(currentCountry)
	}

	//	def setCurrentCountry(Country country){		
	//		
	//	}
	def addCountryToPath(Country country) {
		currentPath.add(country)
		ObservableUtils.firePropertyChanged(this, "currentPath", currentPath)
		if (thisCase.escapeRoute.contains(country)) {
			currentCorrectPath.add(country)
			ObservableUtils.firePropertyChanged(this, "currentCorrectPath", currentCorrectPath)
		} else
			addCountryToPathErrors(country)
	}

	def addCountryToPathErrors(Country country) {
		currentPathErrors.add(country)
		ObservableUtils.firePropertyChanged(this, "currentPathErrors", currentPathErrors)
	}

	def throwMessageThosePlaces0() {
		whichPlace = thosePlaces0
		if (!thisCase.escapeRoute.contains(currentCountry)) {
			message = thosePlaces0.messageWrong
			ObservableUtils.firePropertyChanged(this, "message", message)
		} else if ((currentCountry == thisCase.escapeRoute.get(thisCase.escapeRoute.size - 1)) &&
			(thisCase.escapeRoute.get(2).places.get(0).isHere)) {
			if(captureOrder != thisCase.responsable){
				message = thosePlaces0.messageIs
				ObservableUtils.firePropertyChanged(this, "message", message)
			}else{
				message = "TE HAN PILLADO POR LA ESPALDA SIN SABER QUIEN ERA EL LADRON"
				}
		} else if (currentCountry == thisCase.escapeRoute.get(thisCase.escapeRoute.size - 1) && (!thosePlaces0.isHere)) {
			message = thosePlaces0.messageFinal
			ObservableUtils.firePropertyChanged(this, "message", message)
		} else {
			message = thosePlaces0.messageFuge
			ObservableUtils.firePropertyChanged(this, "message", message)
		}
	}

	def throwMessageThosePlaces1() {
		whichPlace = thosePlaces1
		if (!thisCase.escapeRoute.contains(currentCountry)) {
			message = thosePlaces1.messageWrong
			ObservableUtils.firePropertyChanged(this, "message", message)
		} else if (currentCountry == thisCase.escapeRoute.get(thisCase.escapeRoute.size - 1) &&
			(thisCase.escapeRoute.get(2).places.get(1).isHere)) {
			if(captureOrder != thisCase.responsable){
				message = thosePlaces1.messageIs
				ObservableUtils.firePropertyChanged(this, "message", message)
			}else{
				message = "TE HAN PILLADO POR LA ESPALDA SIN SABER QUIEN ERA EL LADRON"
				}
		} else if (currentCountry == thisCase.escapeRoute.get(thisCase.escapeRoute.size - 1) && (!thosePlaces1.isHere)) {
			message = thosePlaces1.messageFinal
			ObservableUtils.firePropertyChanged(this, "message", message)
		} else {
			message = thosePlaces1.messageFuge
			ObservableUtils.firePropertyChanged(this, "message", message)
		}
	}

	def throwMessageThosePlaces2() {
		whichPlace = thosePlaces2
		if (!thisCase.escapeRoute.contains(currentCountry)) {
			message = thosePlaces2.messageWrong
			ObservableUtils.firePropertyChanged(this, "message", message)
		} else if (currentCountry == thisCase.escapeRoute.get(thisCase.escapeRoute.size - 1) &&
			(thisCase.escapeRoute.get(2).places.get(2).isHere)) {
			if(captureOrder != thisCase.responsable){
				message = thosePlaces2.messageIs
				ObservableUtils.firePropertyChanged(this, "message", message)
			}else{
				message = "TE HAN PILLADO POR LA ESPALDA SIN SABER QUIEN ERA EL LADRON"
				}
		} else if (currentCountry == thisCase.escapeRoute.get(thisCase.escapeRoute.size - 1) && (!thosePlaces2.isHere)) {
			message = thosePlaces2.messageFinal
			ObservableUtils.firePropertyChanged(this, "message", message)
		} else {
			message = thosePlaces2.messageFuge
			ObservableUtils.firePropertyChanged(this, "message", message)
		}
	}
}
