package cases

import org.uqbar.arena.windows.SimpleWindow
import appmodel.SolveCaseWindowAppModel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import appmodel.FilesWindowAppModel
import view.FilesWindow
import appmodel.ArrestWarrentDialogAppModel
import appmodel.TravelWindowAppModel
import org.uqbar.arena.widgets.List
import org.uqbar.arena.bindings.PropertyAdapter
import country.Country
import org.uqbar.arena.layout.ColumnLayout

class SolveCaseWindow extends SimpleWindow<SolveCaseWindowAppModel>{
	
	new(WindowOwner parent, SolveCaseWindowAppModel model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		//Not to be used
	}
	
	override protected createFormPanel(Panel mainPanel) {
		//Not to be used
	}
	
	override protected createMainTemplate(Panel mainPanel) {
		var title = new String("Resolviendo " + modelObject.thisCase.caseName)
		this.title = title
		
		new Label(mainPanel).text = "Ruta de escape:"
		new Label(mainPanel).bindValueToProperty("thisCase.escapeRoute.size")
		new List(mainPanel)=>[
			bindItemsToProperty("thisCase.escapeRoute").adapter = new PropertyAdapter(Country, "name")
			height = 50
		]
		var temp2 = new String(modelObject.thisCase.responsable.name)
		new Label(mainPanel).text = temp2
		var temp = new String(modelObject.thisCase.escapeRoute.get(2).name)
		new Label(mainPanel).text = temp
		
		var temp1 = new String
		if(modelObject.thisCase.escapeRoute.get(2).places.get(0).isHere)
			temp1 ="En la Biblioteca"
		else if(modelObject.thisCase.escapeRoute.get(2).places.get(1).isHere)
			temp1 ="En la Embajada"
		else if(modelObject.thisCase.escapeRoute.get(2).places.get(2).isHere)
			temp1 ="En el Club"
		new Label(mainPanel).text = temp1
		
		
		
		var Panel contentPanel = new Panel(mainPanel)
		contentPanel.layout = new VerticalLayout
		this.caseControl(contentPanel)
		this.travelingDataInformation(contentPanel)
		
	}
	
	
	def caseControl(Panel owner) {
		
//		new Label(owner).text = "Recorrido:"
//		new Label(owner).bindValueToProperty("currentPath.size")
//		new List(owner)=>[
//			bindItemsToProperty("currentPath").adapter = new PropertyAdapter(Country, "name")
//			height = 50
//		]
		
		var Panel contentPanel = new Panel(owner)
		contentPanel.layout = new ColumnLayout(2)
		this.controlButtons(contentPanel)
		this.placesButtons(contentPanel)
	}
	
	
	
	def travelingDataInformation(Panel owner) {
		//Here goes all the info of the criminal Path and wrong journeys of the Detective
		var Panel caseControlPanel = new Panel(owner)
		caseControlPanel.layout = new VerticalLayout
		
		new Label(caseControlPanel).text = "Recorrido Criminal:"
		new List(caseControlPanel)=>[
			bindItemsToProperty("currentCorrectPath").adapter = new PropertyAdapter(Country, "name")
			height = 50
		]
		
		
		new Label(caseControlPanel).text = "Destinos Fallidos:"
		new List(caseControlPanel)=>[
			bindItemsToProperty("currentPathErrors").adapter = new PropertyAdapter(Country, "name")
			height = 50
		]
		
	}
	
	def controlButtons(Panel panel) {
		var Panel controlButtonsPanel = new Panel(panel)
		controlButtonsPanel.layout = new VerticalLayout
		
//		new Label(controlButtonsPanel).text = "Lista de Casos:"
//		new List<Case>(controlButtonsPanel)=>[
//			//bindValueToProperty("selectedVillain")
//			bindItemsToProperty("thisCase.escapeRoute").adapter = new PropertyAdapter(Country, "name")
//			height = 175
//			]
//
//		new Label(controlButtonsPanel).text = "Villano Responsable:"
//		new Label(controlButtonsPanel).bindValueToProperty("thisCase.responsable.name")
		
		
		new Label(controlButtonsPanel).text = "Estas en:"
		new Label(controlButtonsPanel).bindValueToProperty("currentCountry.name")

		
		new Button(controlButtonsPanel) =>[
			caption = "Orden de Arrestro"
			onClick = [ | 
				new ArrestWarrentDialog(this, new ArrestWarrentDialogAppModel(modelObject)).open
			]
		] 
		
		//var arrestWarrant = new String("Orden ya emitida: " + modelObject.captureOrder)
		new Label(controlButtonsPanel).text = "Orden ya emitida:"
		new Label(controlButtonsPanel).bindValueToProperty("captureOrder.name")
		
		new Button(controlButtonsPanel) =>[
			caption = "Viajar"
			onClick = [ | 
				new TravelWindow(this, new TravelWindowAppModel(modelObject)).open
			]
		] 
		
		new Button(controlButtonsPanel) =>[
			caption = "Expedientes"
			onClick = [ | 
				new FilesWindow(this, new FilesWindowAppModel(modelObject.gameSystem, false)).open
			]
		] 
		
	}
	
	
	def placesButtons(Panel panel) {
		var Panel placesButtonsPanel = new Panel(panel)
		placesButtonsPanel.layout = new VerticalLayout
		
		new Label(placesButtonsPanel).text = "Lugares:"
		
		new Button(placesButtonsPanel) =>[
			bindCaptionToProperty("thosePlaces0.name")
			onClick = [ | 
				modelObject.throwMessageThosePlaces0
				new MessageDialog(this, modelObject).open
			]
		] 
		
		new Button(placesButtonsPanel) =>[
			caption = "Lugar 2"
			onClick = [ | 
				modelObject.throwMessageThosePlaces1
				new MessageDialog(this, modelObject).open
				]
		] 
		
		new Button(placesButtonsPanel) =>[
			caption = "Lugar 3"
			onClick = [ | 
				modelObject.throwMessageThosePlaces2
				new MessageDialog(this, modelObject).open
			]
		] 
	}
	
}