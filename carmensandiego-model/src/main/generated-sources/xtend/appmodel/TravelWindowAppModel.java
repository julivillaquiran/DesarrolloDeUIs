package appmodel;

import appmodel.SolveCaseWindowAppModel;
import com.google.common.base.Objects;
import country.Country;
import java.util.List;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class TravelWindowAppModel {
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
  
  private boolean _notFirstCountry;
  
  public boolean isNotFirstCountry() {
    return this._notFirstCountry;
  }
  
  public void setNotFirstCountry(final boolean notFirstCountry) {
    this._notFirstCountry = notFirstCountry;
  }
  
  public TravelWindowAppModel(final SolveCaseWindowAppModel solveCaseWindowAppModel) {
    this.setSolveCaseWindowAppModel(solveCaseWindowAppModel);
    List<Country> _currentPath = solveCaseWindowAppModel.getCurrentPath();
    int _size = _currentPath.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      this.setNotFirstCountry(false);
    } else {
      this.setNotFirstCountry(true);
    }
  }
  
  public void travel() {
    Country _countryToTravel = this.getCountryToTravel();
    boolean _notEquals = (!Objects.equal(_countryToTravel, null));
    if (_notEquals) {
      SolveCaseWindowAppModel _solveCaseWindowAppModel = this.getSolveCaseWindowAppModel();
      Country _countryToTravel_1 = this.getCountryToTravel();
      _solveCaseWindowAppModel.setCurrentCountry(_countryToTravel_1);
      SolveCaseWindowAppModel _solveCaseWindowAppModel_1 = this.getSolveCaseWindowAppModel();
      SolveCaseWindowAppModel _solveCaseWindowAppModel_2 = this.getSolveCaseWindowAppModel();
      Country _currentCountry = _solveCaseWindowAppModel_2.getCurrentCountry();
      _solveCaseWindowAppModel_1.addCountryToPath(_currentCountry);
    }
  }
  
  public void travelBack() {
    boolean _isNotFirstCountry = this.isNotFirstCountry();
    if (_isNotFirstCountry) {
      SolveCaseWindowAppModel _solveCaseWindowAppModel = this.getSolveCaseWindowAppModel();
      SolveCaseWindowAppModel _solveCaseWindowAppModel_1 = this.getSolveCaseWindowAppModel();
      List<Country> _currentPath = _solveCaseWindowAppModel_1.getCurrentPath();
      SolveCaseWindowAppModel _solveCaseWindowAppModel_2 = this.getSolveCaseWindowAppModel();
      List<Country> _currentPath_1 = _solveCaseWindowAppModel_2.getCurrentPath();
      int _size = _currentPath_1.size();
      int _minus = (_size - 2);
      Country _get = _currentPath.get(_minus);
      _solveCaseWindowAppModel.setCurrentCountry(_get);
      SolveCaseWindowAppModel _solveCaseWindowAppModel_3 = this.getSolveCaseWindowAppModel();
      SolveCaseWindowAppModel _solveCaseWindowAppModel_4 = this.getSolveCaseWindowAppModel();
      List<Country> _currentPath_2 = _solveCaseWindowAppModel_4.getCurrentPath();
      SolveCaseWindowAppModel _solveCaseWindowAppModel_5 = this.getSolveCaseWindowAppModel();
      List<Country> _currentPath_3 = _solveCaseWindowAppModel_5.getCurrentPath();
      int _size_1 = _currentPath_3.size();
      int _minus_1 = (_size_1 - 2);
      Country _get_1 = _currentPath_2.get(_minus_1);
      _solveCaseWindowAppModel_3.addCountryToPath(_get_1);
    }
  }
}
