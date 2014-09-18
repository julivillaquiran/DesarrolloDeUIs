package cases

import org.uqbar.arena.windows.Dialog
import org.uqbar.commons.utils.Observable
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import appmodel.TravelDialogAppModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import country.Country


@Observable
class TravelDialog extends Dialog<TravelDialogAppModel> {
	
	new(WindowOwner owner, TravelDialogAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Viajar"
		
		var thisCountry = new String("Estas en: " + modelObject.solveCaseWindowAppModel.currentCountry.name)
		new Label(mainPanel).text = thisCountry
		
		new List<Country>(mainPanel)=>[
			bindValueToProperty("countryToTravel")
			bindItemsToProperty("solveCaseWindowAppModel.currentCountry.connections")
				height = 175
			]
	}
	
}