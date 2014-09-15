package countryView

import appmodel.CreateCountryAppModel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.List
import org.uqbar.arena.bindings.PropertyAdapter
import country.Country
import country.InterestPlace

class CreateCountryWindow extends SimpleWindow<CreateCountryAppModel>{
		
	new(WindowOwner parent, CreateCountryAppModel model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		//no queremos usar este template default
	}
	
	override protected createFormPanel(Panel mainPanel) {
		if(modelObject.edit)
			title = "Editar Pais"
		else
			title = "Crear Nuevo Pais"
		mainPanel.layout = new VerticalLayout 
		
		new Label(mainPanel).text="Nombre:"
		new TextBox(mainPanel)=>[
			bindValueToProperty("country.name")
			width=200
		]
		
		new Label(mainPanel).text="Conexiones:"
		new List(mainPanel) => [
			bindItemsToProperty("country.connections").adapter = new PropertyAdapter(Country, "name")
			bindValueToProperty("takenConnection")
		]
		new Selector(mainPanel) => [
			bindItemsToProperty("gameSystem.worldMap").adapter = new PropertyAdapter(Country, "name")
			bindValueToProperty("newConnection")
		]
		new Button(mainPanel)=>[
			caption = "Agregar Conexión"
			onClick = [| modelObject.addConnection ]
//			onClick = [ | new NewHobbieWindow(this, this.modelObject.villainAppModel).open ]
		]
		new Button(mainPanel)=>[
			caption = "Quitar Conexión"
			onClick = [| modelObject.takeConnection ]
		]
		
		
		
		new Label(mainPanel).text="Caracteristicas:"
		new List(mainPanel) => [
			bindItemsToProperty("country.characteristics")
			bindValueToProperty("takenCharacteristic")
		]
		new Label(mainPanel).text="Escriba una nueva caracteristica:"
		new TextBox(mainPanel) => [
			bindValueToProperty("newCharacteristic")
		]
		new Button(mainPanel)=>[
			caption = "Agregar Caracteristica"
			onClick = [| modelObject.addCharacteristic ]
//			onClick = [ | new NewHobbieWindow(this, this.modelObject.villainAppModel).open ]
		]
		new Button(mainPanel)=>[
			caption = "Quitar Caracteristica"
			onClick = [| modelObject.takeCharacteristic ]
		]
		
		
		
		new Label(mainPanel).text="Lugares de interes:"
		new List(mainPanel) => [
			bindItemsToProperty("country.places").adapter = new PropertyAdapter(InterestPlace, "name")
			bindValueToProperty("takenPlace")
		]
		new Label(mainPanel).text="Escoja un nuevo lugar:"
		new Selector(mainPanel)=>[
				bindItemsToProperty("gameSystem.interestPlaces").adapter = new PropertyAdapter(InterestPlace, "name")
				bindValueToProperty("newPlace")
		]
		new Button(mainPanel)=>[
			caption = "Agregar Lugar de Interes:"
			onClick = [| modelObject.addPlace ]
//			onClick = [ | new NewSignWindow(this, this.modelObject.villainAppModel).open ]
		]
		new Button(mainPanel)=>[
			caption = "Quitar Lugar de Interes"
			onClick = [| modelObject.takePlace ]
		]
		
		
		new Button(mainPanel)=>[
			if(modelObject.edit)
				caption = "Terminar Edicion"
			else
				caption = "Crear Pais"
			onClick = [ |
				this.modelObject.addCountry
				this.close
			]
		]
	}
}