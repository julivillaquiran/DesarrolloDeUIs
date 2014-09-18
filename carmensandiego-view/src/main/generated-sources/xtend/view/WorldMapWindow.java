package view;

import appmodel.CreateCountryAppModel;
import appmodel.WorldMapAppModel;
import com.google.common.base.Objects;
import country.Country;
import countryView.CreateCountryWindow;
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
import villain.Hobbie;

@SuppressWarnings("all")
public class WorldMapWindow extends SimpleWindow<WorldMapAppModel> {
  public WorldMapWindow(final WindowOwner parent, final WorldMapAppModel model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
  }
  
  protected void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Mapamundi");
    Panel contentPanel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    contentPanel.setLayout(_columnLayout);
    this.createCountryList(contentPanel);
    this.createSelectedCountryInformation(contentPanel);
  }
  
  public Button createCountryList(final Panel owner) {
    Button _xblockexpression = null;
    {
      Panel worldMapPanel = new Panel(owner);
      VerticalLayout _verticalLayout = new VerticalLayout();
      worldMapPanel.setLayout(_verticalLayout);
      Label _label = new Label(worldMapPanel);
      _label.setText("Paises");
      List<Country> _list = new List<Country>(worldMapPanel);
      final Procedure1<List<Country>> _function = new Procedure1<List<Country>>() {
        public void apply(final List<Country> it) {
          it.<Object, ControlBuilder>bindValueToProperty("selectedCountry");
          Binding<?, Selector<Country>, ListBuilder<Country>> _bindItemsToProperty = it.bindItemsToProperty("gameSystem.worldMap");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Country.class, "name");
          _bindItemsToProperty.setAdapter(_propertyAdapter);
          it.setHeight(175);
        }
      };
      ObjectExtensions.<List<Country>>operator_doubleArrow(_list, _function);
      Button _button = new Button(worldMapPanel);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Nuevo Pais");
          final Action _function = new Action() {
            public void execute() {
              WorldMapAppModel _modelObject = WorldMapWindow.this.getModelObject();
              GameSystem _gameSystem = _modelObject.getGameSystem();
              Country _country = new Country();
              CreateCountryAppModel _createCountryAppModel = new CreateCountryAppModel(_gameSystem, _country);
              CreateCountryWindow _createCountryWindow = new CreateCountryWindow(WorldMapWindow.this, _createCountryAppModel, "Crear Nuevo Pais", "Crear Pais");
              _createCountryWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
      Button _button_1 = new Button(worldMapPanel);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Editar Pais");
          final Action _function = new Action() {
            public void execute() {
              WorldMapAppModel _modelObject = WorldMapWindow.this.getModelObject();
              Country _selectedCountry = _modelObject.getSelectedCountry();
              boolean _notEquals = (!Objects.equal(_selectedCountry, null));
              if (_notEquals) {
                WorldMapAppModel _modelObject_1 = WorldMapWindow.this.getModelObject();
                GameSystem _gameSystem = _modelObject_1.getGameSystem();
                WorldMapAppModel _modelObject_2 = WorldMapWindow.this.getModelObject();
                Country _selectedCountry_1 = _modelObject_2.getSelectedCountry();
                CreateCountryAppModel _createCountryAppModel = new CreateCountryAppModel(_gameSystem, _selectedCountry_1);
                CreateCountryWindow _createCountryWindow = new CreateCountryWindow(WorldMapWindow.this, _createCountryAppModel, "Editar Pais", "Terminar Edicion");
                _createCountryWindow.open();
              }
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_2);
      Button _button_2 = new Button(worldMapPanel);
      final Procedure1<Button> _function_3 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Eliminar Pais");
          final Action _function = new Action() {
            public void execute() {
              WorldMapAppModel _modelObject = WorldMapWindow.this.getModelObject();
              _modelObject.removeCountry();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_3);
    }
    return _xblockexpression;
  }
  
  public List<Hobbie> createSelectedCountryInformation(final Panel owner) {
    List<Hobbie> _xblockexpression = null;
    {
      Panel countryInfoPanel = new Panel(owner);
      VerticalLayout _verticalLayout = new VerticalLayout();
      countryInfoPanel.setLayout(_verticalLayout);
      Label _label = new Label(countryInfoPanel);
      _label.setText("Nombre:");
      Label _label_1 = new Label(countryInfoPanel);
      _label_1.<Object, ControlBuilder>bindValueToProperty("selectedCountry.name");
      Label _label_2 = new Label(countryInfoPanel);
      _label_2.setText("Caracteristicas:");
      List<String> _list = new List<String>(countryInfoPanel);
      final Procedure1<List<String>> _function = new Procedure1<List<String>>() {
        public void apply(final List<String> it) {
          it.bindItemsToProperty("selectedCountry.characteristics");
          it.setHeight(75);
        }
      };
      ObjectExtensions.<List<String>>operator_doubleArrow(_list, _function);
      Label _label_3 = new Label(countryInfoPanel);
      _label_3.setText("Conexiones:");
      List<String> _list_1 = new List<String>(countryInfoPanel);
      final Procedure1<List<String>> _function_1 = new Procedure1<List<String>>() {
        public void apply(final List<String> it) {
          Binding<?, Selector<String>, ListBuilder<String>> _bindItemsToProperty = it.bindItemsToProperty("selectedCountry.connections");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Country.class, "name");
          _bindItemsToProperty.setAdapter(_propertyAdapter);
          it.setHeight(75);
        }
      };
      ObjectExtensions.<List<String>>operator_doubleArrow(_list_1, _function_1);
      Label _label_4 = new Label(countryInfoPanel);
      _label_4.setText("Lugares:");
      List<Hobbie> _list_2 = new List<Hobbie>(countryInfoPanel);
      final Procedure1<List<Hobbie>> _function_2 = new Procedure1<List<Hobbie>>() {
        public void apply(final List<Hobbie> it) {
          Binding<?, Selector<Hobbie>, ListBuilder<Hobbie>> _bindItemsToProperty = it.bindItemsToProperty("selectedCountry.places");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Country.class, "name");
          _bindItemsToProperty.setAdapter(_propertyAdapter);
          it.setHeight(75);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Hobbie>>operator_doubleArrow(_list_2, _function_2);
    }
    return _xblockexpression;
  }
}
