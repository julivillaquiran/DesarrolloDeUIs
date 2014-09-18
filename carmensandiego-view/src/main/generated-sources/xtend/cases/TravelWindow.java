package cases;

import appmodel.SolveCaseWindowAppModel;
import appmodel.TravelWindowAppModel;
import country.Country;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.PropertyAdapter;
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

@SuppressWarnings("all")
public class TravelWindow extends SimpleWindow<TravelWindowAppModel> {
  public TravelWindow(final WindowOwner parent, final TravelWindowAppModel model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Viajar");
    TravelWindowAppModel _modelObject = this.getModelObject();
    SolveCaseWindowAppModel _solveCaseWindowAppModel = _modelObject.getSolveCaseWindowAppModel();
    Country _currentCountry = _solveCaseWindowAppModel.getCurrentCountry();
    String _name = _currentCountry.getName();
    String _plus = ("Estas en: " + _name);
    String thisCountry = new String(_plus);
    Label _label = new Label(mainPanel);
    _label.setText(thisCountry);
    List<Object> _list = new List<Object>(mainPanel);
    final Procedure1<List<Object>> _function = new Procedure1<List<Object>>() {
      public void apply(final List<Object> it) {
        it.<Object, ControlBuilder>bindValueToProperty("countryToTravel");
        Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty("solveCaseWindowAppModel.currentCountry.connections");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Country.class, "name");
        _bindItemsToProperty.setAdapter(_propertyAdapter);
        it.setHeight(75);
      }
    };
    ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function);
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Volver al Pais anterior");
        it.<ControlBuilder>bindEnabledToProperty("notFirstCountry");
        final Action _function = new Action() {
          public void execute() {
            TravelWindowAppModel _modelObject = TravelWindow.this.getModelObject();
            _modelObject.travelBack();
            TravelWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
    Button _button_1 = new Button(mainPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Viajar");
        final Action _function = new Action() {
          public void execute() {
            TravelWindowAppModel _modelObject = TravelWindow.this.getModelObject();
            _modelObject.travel();
            TravelWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_2);
  }
}
