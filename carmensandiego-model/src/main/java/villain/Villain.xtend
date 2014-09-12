package villain

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
	List<Hobbie> hobbies = newArrayList
	
	
	
	def void addHobbies(Hobbie newHobbie) {
		hobbies.add(newHobbie)
		ObservableUtils.firePropertyChanged(this,"hobbies", hobbies)
	}
	
	def void takeHobbies(Hobbie takenHobbie){
		hobbies.remove(takenHobbie)
		ObservableUtils.firePropertyChanged(this,"hobbies", hobbies)
	}
	
	
	def void addSigns(String newSign){
		signs.add(newSign)
		ObservableUtils.firePropertyChanged(this,"signs", signs)
	}
	
	def takeSigns(String takenSign){
		signs.remove(takenSign)
		ObservableUtils.firePropertyChanged(this,"signs", signs)
	}
	
}