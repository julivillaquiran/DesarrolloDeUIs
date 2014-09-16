package country

import org.uqbar.commons.utils.Observable

@Observable
class InterestPlace {
	
	@Property
	Places name	
	
	def messageIs(){
		switch name{
		
			case Banco: {
				 return ("Esta en el Banco")
				
			}
			case Biblioteca: {
				return ("Esta en la Biblioteca")
			}
			case Club: {
				return ("Este en el Club")
			}
			case Embajada: {
				return ("Esta en la Embajada")
			}
		}
	}
	
	def messageFinal(){
		switch name{
		
			case Banco: {
				 return ("En este Pais, pero no en el Banco")
				
			}
			case Biblioteca: {
				return ("En este Pais, pero no en la Biblioteca")
			}
			case Club: {
				return ("En este Pais, pero no en el Club")
			}
			case Embajada: {
				return ("En este Pais, pero no en la Embajada")
			}
		}
	}
	
	def messageFuge(){
		switch name{
		
			case Banco: {
				 return ("Paso por este Banco")
				
			}
			case Biblioteca: {
				return ("Paso por esta Biblioteca")
			}
			case Club: {
				return ("Paso por este Club")
			}
			case Embajada: {
				return ("Paso por esta Embajada")
			}
		}
	}
	
	def messageWrong(){
		switch name{
		
			case Banco: {
				 return ("Nunca le hemos visto en este Banco")
				
			}
			case Biblioteca: {
				return ("Nunca le hemos visto en esta Biblioteca")
			}
			case Club: {
				return ("Nunca le hemos visto en este Club")
			}
			case Embajada: {
				return ("Nunca le hemos visto en esta Embajada")
			}
		}
	}
	
}