package appmodel;

import appmodel.SolveCaseWindowAppModel;
import country.Country;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class TravelDialogAppModel {
  private SolveCaseWindowAppModel _solveCaseWindowAppModel;
  
  public SolveCaseWindowAppModel getSolveCaseWindowAppModel() {
    return this._solveCaseWindowAppModel;
  }
  
  public void setSolveCaseWindowAppModel(final SolveCaseWindowAppModel solveCaseWindowAppModel) {
    this._solveCaseWindowAppModel = solveCaseWindowAppModel;
  }
  
  private Country _countryToTravel;
  
  public Country getCountryToTravel() {
    return this._countryToTravel;
  }
  
  public void setCountryToTravel(final Country countryToTravel) {
    this._countryToTravel = countryToTravel;
  }
  
  public TravelDialogAppModel(final SolveCaseWindowAppModel solveCaseWindowAppModel) {
    this.setSolveCaseWindowAppModel(solveCaseWindowAppModel);
  }
}
