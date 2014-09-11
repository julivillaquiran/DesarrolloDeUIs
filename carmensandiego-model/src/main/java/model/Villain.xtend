package model

import org.uqbar.commons.utils.Observable
import java.util.List
import org.uqbar.commons.model.ObservableUtils

@Observable
@SuppressWarnings("all")
class Villain {
	@Property 
	String name
	
	@Property
	Gender sex
	
	@Property
	List<String> signs = newArrayList
	
	@Property
	String newSign
	
	@Property
	List<Hobbie> hobbies = newArrayList
	
	@Property
	Hobbie newHobbie
	
	
	def void addHobbie() {
		hobbies.add(newHobbie)
		ObservableUtils.firePropertyChanged(this,"hobbies", hobbies)
	}
	
	def void saddNewSign(){
		signs.add(newSign)
		ObservableUtils.firePropertyChanged(this,"signs", signs)
	}
	
	

	
}