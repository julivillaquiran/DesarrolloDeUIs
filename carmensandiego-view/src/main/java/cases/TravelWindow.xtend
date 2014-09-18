package cases

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import appmodel.TravelWindowAppModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import country.Country
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.Button

class TravelWindow extends SimpleWindow<TravelWindowAppModel>{
	
	new(WindowOwner parent, TravelWindowAppModel model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		//throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Viajar"
		
		var thisCountry = new String("Estas en: " + modelObject.solveCaseWindowAppModel.currentCountry.name)
		new Label(mainPanel).text = thisCountry
		
		new List(mainPanel)=>[
			bindValueToProperty("countryToTravel")
			bindItemsToProperty("solveCaseWindowAppModel.currentCountry.connections")
				.adapter = new PropertyAdapter(Country, "name")
				height = 75
			]
			
		new Button(mainPanel)=>[
			caption = "Volver al Pais anterior"
			bindEnabledToProperty("notFirstCountry")
			onClick = [ |
				modelObject.travelBack
				this.close				
			]
		]
		
		new Button(mainPanel)=>[
			caption = "Viajar"
			onClick = [ |
				modelObject.travel
				this.close
				
			]
		]
	}
	
}