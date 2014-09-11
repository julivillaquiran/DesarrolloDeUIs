package model

import java.util.List
import org.uqbar.commons.model.ObservableUtils
import org.uqbar.commons.utils.Observable

@Observable
class GameSystem {
	
	@Property
	List<Country> worldMap
	
	@Property
	List<Villain> files
	
	@Property
	List<Case> cases
	
		
	new(){ 
		files = newArrayList
		worldMap = newArrayList
		cases = newArrayList
		}
	
	def addVillains(Villain villain){
		this.files.add(villain)
		ObservableUtils.firePropertyChanged(this,"files", files)
		}
		
	def getVillains(){
		files
	}
	
}