package view

import org.uqbar.arena.windows.SimpleWindow
import appmodel.WorldMapAppModel
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.ColumnLayout
import villain.Hobbie
import org.uqbar.arena.bindings.PropertyAdapter
import country.Country
import countryView.CreateCountryWindow
import appmodel.CreateCountryAppModel

class WorldMapWindow extends SimpleWindow<WorldMapAppModel> {
	
	new(WindowOwner parent, WorldMapAppModel model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		//This template is not gonna be used)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		//This template is not gonna be used
	}
	
	override protected createMainTemplate(Panel mainPanel) {
		this.title = "Mapamundi"
		
		var Panel contentPanel = new Panel(mainPanel)
		contentPanel.layout = new ColumnLayout(2)
		this.createCountryList(contentPanel)
		this.createSelectedCountryInformation(contentPanel)
		
	}
	
	
	def createCountryList(Panel owner) {
		var Panel worldMapPanel = new Panel(owner)
			worldMapPanel.layout = new VerticalLayout
		
		
		new Label(worldMapPanel).text = "Paises"
		new List<Country>(worldMapPanel)=>[
			bindValueToProperty("selectedCountry")
			bindItemsToProperty("gameSystem.worldMap").adapter = new PropertyAdapter(Country, "name")
			height = 175
			]
			
		new Button(worldMapPanel) =>[
			caption = "Nuevo Pais"
			onClick = [ | 
				new CreateCountryWindow(this, 
				new CreateCountryAppModel(modelObject.gameSystem, new Country()), "Crear Nuevo Pais", "Crear Pais").open
			]
		]
		
		new Button(worldMapPanel) =>[
			caption = "Editar Pais"
			onClick = [ | 
				if(modelObject.selectedCountry != null)
					new CreateCountryWindow(this, 
						new CreateCountryAppModel(modelObject.gameSystem, modelObject.selectedCountry), "Editar Pais", "Terminar Edicion").open
			]
		]
		
		new Button(worldMapPanel) =>[
			caption = "Eliminar Pais"
			onClick = [ | modelObject.removeCountry
			]
		] 
	}
	
	def createSelectedCountryInformation(Panel owner) {
		var Panel countryInfoPanel = new Panel(owner)
			countryInfoPanel.layout = new VerticalLayout
			
			
			
		new Label(countryInfoPanel).text = "Nombre:"
		new Label(countryInfoPanel).bindValueToProperty("selectedCountry.name")
		
		new Label(countryInfoPanel).text = "Caracteristicas:"
		new List<String>(countryInfoPanel)=>[
			bindItemsToProperty("selectedCountry.characteristics")
			height = 75
			]
		
		new Label(countryInfoPanel).text = "Conexiones:"
		new List<String>(countryInfoPanel)=>[
			bindItemsToProperty("selectedCountry.connections").adapter = new PropertyAdapter(Country, "name")
			height = 75
			]
		
		new Label(countryInfoPanel).text = "Lugares:"
		new List<Hobbie>(countryInfoPanel)=>[
			bindItemsToProperty("selectedCountry.places").adapter = new PropertyAdapter(Country, "name")
			height = 75
			]

	}
	
}