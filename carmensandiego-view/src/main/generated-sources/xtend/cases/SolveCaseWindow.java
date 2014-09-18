package cases;

import appmodel.ArrestWarrentDialogAppModel;
import appmodel.FilesWindowAppModel;
import appmodel.SolveCaseWindowAppModel;
import appmodel.TravelWindowAppModel;
import cases.ArrestWarrentDialog;
import cases.MessageDialog;
import cases.TravelWindow;
import country.Country;
import country.InterestPlace;
import gameCase.Case;
import model.GameSystem;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import view.FilesWindow;
import villain.Villain;

@SuppressWarnings("all")
public class SolveCaseWindow extends SimpleWindow<SolveCaseWindowAppModel> {
  public SolveCaseWindow(final WindowOwner parent, final SolveCaseWindowAppModel model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
  }
  
  protected void createMainTemplate(final Panel mainPanel) {
    SolveCaseWindowAppModel _modelObject = this.getModelObject();
    Case _thisCase = _modelObject.getThisCase();
    String _caseName = _thisCase.getCaseName();
    String _plus = ("Resolviendo " + _caseName);
    String title = new String(_plus);
    this.setTitle(title);
    Label _label = new Label(mainPanel);
    _label.setText("Ruta de escape:");
    Label _label_1 = new Label(mainPanel);
    _label_1.<Object, ControlBuilder>bindValueToProperty("thisCase.escapeRoute.size");
    List<Object> _list = new List<Object>(mainPanel);
    final Procedure1<List<Object>> _function = new Procedure1<List<Object>>() {
      public void apply(final List<Object> it) {
        Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty("thisCase.escapeRoute");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Country.class, "name");
        _bindItemsToProperty.setAdapter(_propertyAdapter);
        it.setHeight(50);
      }
    };
    ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function);
    SolveCaseWindowAppModel _modelObject_1 = this.getModelObject();
    Case _thisCase_1 = _modelObject_1.getThisCase();
    Villain _responsable = _thisCase_1.getResponsable();
    String _name = _responsable.getName();
    String temp2 = new String(_name);
    Label _label_2 = new Label(mainPanel);
    _label_2.setText(temp2);
    SolveCaseWindowAppModel _modelObject_2 = this.getModelObject();
    Case _thisCase_2 = _modelObject_2.getThisCase();
    java.util.List<Country> _escapeRoute = _thisCase_2.getEscapeRoute();
    Country _get = _escapeRoute.get(2);
    String _name_1 = _get.getName();
    String temp = new String(_name_1);
    Label _label_3 = new Label(mainPanel);
    _label_3.setText(temp);
    String temp1 = new String();
    SolveCaseWindowAppModel _modelObject_3 = this.getModelObject();
    Case _thisCase_3 = _modelObject_3.getThisCase();
    java.util.List<Country> _escapeRoute_1 = _thisCase_3.getEscapeRoute();
    Country _get_1 = _escapeRoute_1.get(2);
    java.util.List<InterestPlace> _places = _get_1.getPlaces();
    InterestPlace _get_2 = _places.get(0);
    boolean _isIsHere = _get_2.isIsHere();
    if (_isIsHere) {
      temp1 = "En la Biblioteca";
    } else {
      SolveCaseWindowAppModel _modelObject_4 = this.getModelObject();
      Case _thisCase_4 = _modelObject_4.getThisCase();
      java.util.List<Country> _escapeRoute_2 = _thisCase_4.getEscapeRoute();
      Country _get_3 = _escapeRoute_2.get(2);
      java.util.List<InterestPlace> _places_1 = _get_3.getPlaces();
      InterestPlace _get_4 = _places_1.get(1);
      boolean _isIsHere_1 = _get_4.isIsHere();
      if (_isIsHere_1) {
        temp1 = "En la Embajada";
      } else {
        SolveCaseWindowAppModel _modelObject_5 = this.getModelObject();
        Case _thisCase_5 = _modelObject_5.getThisCase();
        java.util.List<Country> _escapeRoute_3 = _thisCase_5.getEscapeRoute();
        Country _get_5 = _escapeRoute_3.get(2);
        java.util.List<InterestPlace> _places_2 = _get_5.getPlaces();
        InterestPlace _get_6 = _places_2.get(2);
        boolean _isIsHere_2 = _get_6.isIsHere();
        if (_isIsHere_2) {
          temp1 = "En el Club";
        }
      }
    }
    Label _label_4 = new Label(mainPanel);
    _label_4.setText(temp1);
    Panel contentPanel = new Panel(mainPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    contentPanel.setLayout(_verticalLayout);
    this.caseControl(contentPanel);
    this.travelingDataInformation(contentPanel);
  }
  
  public Button caseControl(final Panel owner) {
    Button _xblockexpression = null;
    {
      Panel contentPanel = new Panel(owner);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      contentPanel.setLayout(_columnLayout);
      this.controlButtons(contentPanel);
      _xblockexpression = this.placesButtons(contentPanel);
    }
    return _xblockexpression;
  }
  
  public List<Object> travelingDataInformation(final Panel owner) {
    List<Object> _xblockexpression = null;
    {
      Panel caseControlPanel = new Panel(owner);
      VerticalLayout _verticalLayout = new VerticalLayout();
      caseControlPanel.setLayout(_verticalLayout);
      Label _label = new Label(caseControlPanel);
      _label.setText("Recorrido Criminal:");
      List<Object> _list = new List<Object>(caseControlPanel);
      final Procedure1<List<Object>> _function = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty("currentCorrectPath");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Country.class, "name");
          _bindItemsToProperty.setAdapter(_propertyAdapter);
          it.setHeight(50);
        }
      };
      ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function);
      Label _label_1 = new Label(caseControlPanel);
      _label_1.setText("Destinos Fallidos:");
      List<Object> _list_1 = new List<Object>(caseControlPanel);
      final Procedure1<List<Object>> _function_1 = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty("currentPathErrors");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Country.class, "name");
          _bindItemsToProperty.setAdapter(_propertyAdapter);
          it.setHeight(50);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Object>>operator_doubleArrow(_list_1, _function_1);
    }
    return _xblockexpression;
  }
  
  public Button controlButtons(final Panel panel) {
    Button _xblockexpression = null;
    {
      Panel controlButtonsPanel = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      controlButtonsPanel.setLayout(_verticalLayout);
      Label _label = new Label(controlButtonsPanel);
      _label.setText("Estas en:");
      Label _label_1 = new Label(controlButtonsPanel);
      _label_1.<Object, ControlBuilder>bindValueToProperty("currentCountry.name");
      Button _button = new Button(controlButtonsPanel);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Orden de Arrestro");
          final Action _function = new Action() {
            public void execute() {
              SolveCaseWindowAppModel _modelObject = SolveCaseWindow.this.getModelObject();
              ArrestWarrentDialogAppModel _arrestWarrentDialogAppModel = new ArrestWarrentDialogAppModel(_modelObject);
              ArrestWarrentDialog _arrestWarrentDialog = new ArrestWarrentDialog(SolveCaseWindow.this, _arrestWarrentDialogAppModel);
              _arrestWarrentDialog.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Label _label_2 = new Label(controlButtonsPanel);
      _label_2.setText("Orden ya emitida:");
      Label _label_3 = new Label(controlButtonsPanel);
      _label_3.<Object, ControlBuilder>bindValueToProperty("captureOrder.name");
      Button _button_1 = new Button(controlButtonsPanel);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Viajar");
          final Action _function = new Action() {
            public void execute() {
              SolveCaseWindowAppModel _modelObject = SolveCaseWindow.this.getModelObject();
              TravelWindowAppModel _travelWindowAppModel = new TravelWindowAppModel(_modelObject);
              TravelWindow _travelWindow = new TravelWindow(SolveCaseWindow.this, _travelWindowAppModel);
              _travelWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
      Button _button_2 = new Button(controlButtonsPanel);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Expedientes");
          final Action _function = new Action() {
            public void execute() {
              SolveCaseWindowAppModel _modelObject = SolveCaseWindow.this.getModelObject();
              GameSystem _gameSystem = _modelObject.getGameSystem();
              FilesWindowAppModel _filesWindowAppModel = new FilesWindowAppModel(_gameSystem, false);
              FilesWindow _filesWindow = new FilesWindow(SolveCaseWindow.this, _filesWindowAppModel);
              _filesWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
    }
    return _xblockexpression;
  }
  
  public Button placesButtons(final Panel panel) {
    Button _xblockexpression = null;
    {
      Panel placesButtonsPanel = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      placesButtonsPanel.setLayout(_verticalLayout);
      Label _label = new Label(placesButtonsPanel);
      _label.setText("Lugares:");
      Button _button = new Button(placesButtonsPanel);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.bindCaptionToProperty("thosePlaces0.name");
          final Action _function = new Action() {
            public void execute() {
              SolveCaseWindowAppModel _modelObject = SolveCaseWindow.this.getModelObject();
              _modelObject.throwMessageThosePlaces0();
              SolveCaseWindowAppModel _modelObject_1 = SolveCaseWindow.this.getModelObject();
              MessageDialog _messageDialog = new MessageDialog(SolveCaseWindow.this, _modelObject_1);
              _messageDialog.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Button _button_1 = new Button(placesButtonsPanel);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Lugar 2");
          final Action _function = new Action() {
            public void execute() {
              SolveCaseWindowAppModel _modelObject = SolveCaseWindow.this.getModelObject();
              _modelObject.throwMessageThosePlaces1();
              SolveCaseWindowAppModel _modelObject_1 = SolveCaseWindow.this.getModelObject();
              MessageDialog _messageDialog = new MessageDialog(SolveCaseWindow.this, _modelObject_1);
              _messageDialog.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
      Button _button_2 = new Button(placesButtonsPanel);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Lugar 3");
          final Action _function = new Action() {
            public void execute() {
              SolveCaseWindowAppModel _modelObject = SolveCaseWindow.this.getModelObject();
              _modelObject.throwMessageThosePlaces2();
              SolveCaseWindowAppModel _modelObject_1 = SolveCaseWindow.this.getModelObject();
              MessageDialog _messageDialog = new MessageDialog(SolveCaseWindow.this, _modelObject_1);
              _messageDialog.open();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
    }
    return _xblockexpression;
  }
}
