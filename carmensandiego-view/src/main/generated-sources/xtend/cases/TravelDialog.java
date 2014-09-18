package cases;

import appmodel.SolveCaseWindowAppModel;
import appmodel.TravelDialogAppModel;
import country.Country;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.ControlBuilder;

@Observable
@SuppressWarnings("all")
public class TravelDialog extends Dialog<TravelDialogAppModel> {
  public TravelDialog(final WindowOwner owner, final TravelDialogAppModel model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Viajar");
    TravelDialogAppModel _modelObject = this.getModelObject();
    SolveCaseWindowAppModel _solveCaseWindowAppModel = _modelObject.getSolveCaseWindowAppModel();
    Country _currentCountry = _solveCaseWindowAppModel.getCurrentCountry();
    String _name = _currentCountry.getName();
    String _plus = ("Estas en: " + _name);
    String thisCountry = new String(_plus);
    Label _label = new Label(mainPanel);
    _label.setText(thisCountry);
    List<Country> _list = new List<Country>(mainPanel);
    final Procedure1<List<Country>> _function = new Procedure1<List<Country>>() {
      public void apply(final List<Country> it) {
        it.<Object, ControlBuilder>bindValueToProperty("countryToTravel");
        it.bindItemsToProperty("solveCaseWindowAppModel.currentCountry.connections");
        it.setHeight(175);
      }
    };
    ObjectExtensions.<List<Country>>operator_doubleArrow(_list, _function);
  }
}
