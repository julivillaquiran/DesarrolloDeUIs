package appmodel;

import com.google.common.base.Objects;
import country.Country;
import country.InterestPlace;
import java.util.List;
import model.GameSystem;
import org.uqbar.commons.utils.Observable;
import villain.Villain;

@Observable
@SuppressWarnings("all")
public class CreateCountryAppModel {
  private Country _country;
  
  public Country getCountry() {
    return this._country;
  }
  
  public void setCountry(final Country country) {
    this._country = country;
  }
  
  private Country _selectedCountry;
  
  public Country getSelectedCountry() {
    return this._selectedCountry;
  }
  
  public void setSelectedCountry(final Country selectedCountry) {
    this._selectedCountry = selectedCountry;
  }
  
  private int indexOfCountry;
  
  private String _newCharacteristic;
  
  public String getNewCharacteristic() {
    return this._newCharacteristic;
  }
  
  public void setNewCharacteristic(final String newCharacteristic) {
    this._newCharacteristic = newCharacteristic;
  }
  
  private String _takenCharacteristic;
  
  public String getTakenCharacteristic() {
    return this._takenCharacteristic;
  }
  
  public void setTakenCharacteristic(final String takenCharacteristic) {
    this._takenCharacteristic = takenCharacteristic;
  }
  
  private InterestPlace _newPlace;
  
  public InterestPlace getNewPlace() {
    return this._newPlace;
  }
  
  public void setNewPlace(final InterestPlace newPlace) {
    this._newPlace = newPlace;
  }
  
  private InterestPlace _takenPlace;
  
  public InterestPlace getTakenPlace() {
    return this._takenPlace;
  }
  
  public void setTakenPlace(final InterestPlace takenPlace) {
    this._takenPlace = takenPlace;
  }
  
  private Country _newConnection;
  
  public Country getNewConnection() {
    return this._newConnection;
  }
  
  public void setNewConnection(final Country newConnection) {
    this._newConnection = newConnection;
  }
  
  private Country _takenConnection;
  
  public Country getTakenConnection() {
    return this._takenConnection;
  }
  
  public void setTakenConnection(final Country takenConnection) {
    this._takenConnection = takenConnection;
  }
  
  private List<Country> _possibleConnections;
  
  public List<Country> getPossibleConnections() {
    return this._possibleConnections;
  }
  
  public void setPossibleConnections(final List<Country> possibleConnections) {
    this._possibleConnections = possibleConnections;
  }
  
  private GameSystem _gameSystem;
  
  public GameSystem getGameSystem() {
    return this._gameSystem;
  }
  
  public void setGameSystem(final GameSystem gameSystem) {
    this._gameSystem = gameSystem;
  }
  
  private boolean _edit;
  
  public boolean isEdit() {
    return this._edit;
  }
  
  public void setEdit(final boolean edit) {
    this._edit = edit;
  }
  
  public CreateCountryAppModel(final GameSystem gameSystem, final Country selectedCountry, final boolean edit) {
    this.setGameSystem(gameSystem);
    this.setEdit(edit);
    if (edit) {
      this.setCountry(selectedCountry);
    } else {
      Country _country = new Country();
      this.setCountry(_country);
    }
    List<Villain> _villains = gameSystem.getVillains();
    int _indexOf = _villains.indexOf(selectedCountry);
    this.indexOfCountry = _indexOf;
  }
  
  public void addCountry() {
    GameSystem _gameSystem = this.getGameSystem();
    List<Country> _worldMap = _gameSystem.getWorldMap();
    Country _country = this.getCountry();
    boolean _contains = _worldMap.contains(_country);
    boolean _not = (!_contains);
    if (_not) {
      GameSystem _gameSystem_1 = this.getGameSystem();
      Country _country_1 = this.getCountry();
      _gameSystem_1.addCountries(_country_1);
    }
  }
  
  public void addCharacteristic() {
    boolean _and = false;
    Country _country = this.getCountry();
    List<String> _characteristics = _country.getCharacteristics();
    String _newCharacteristic = this.getNewCharacteristic();
    boolean _contains = _characteristics.contains(_newCharacteristic);
    boolean _not = (!_contains);
    if (!_not) {
      _and = false;
    } else {
      String _newCharacteristic_1 = this.getNewCharacteristic();
      boolean _notEquals = (!Objects.equal(_newCharacteristic_1, null));
      _and = _notEquals;
    }
    if (_and) {
      Country _country_1 = this.getCountry();
      String _newCharacteristic_2 = this.getNewCharacteristic();
      _country_1.addCharacteristics(_newCharacteristic_2);
    }
  }
  
  public void takeCharacteristic() {
    Country _country = this.getCountry();
    String _takenCharacteristic = this.getTakenCharacteristic();
    _country.takeCharacteristics(_takenCharacteristic);
  }
  
  public void addPlace() {
    boolean _and = false;
    Country _country = this.getCountry();
    List<InterestPlace> _places = _country.getPlaces();
    InterestPlace _newPlace = this.getNewPlace();
    boolean _contains = _places.contains(_newPlace);
    boolean _not = (!_contains);
    if (!_not) {
      _and = false;
    } else {
      InterestPlace _newPlace_1 = this.getNewPlace();
      boolean _notEquals = (!Objects.equal(_newPlace_1, null));
      _and = _notEquals;
    }
    if (_and) {
      Country _country_1 = this.getCountry();
      InterestPlace _newPlace_2 = this.getNewPlace();
      _country_1.addPlaces(_newPlace_2);
    }
  }
  
  public void takePlace() {
    Country _country = this.getCountry();
    InterestPlace _takenPlace = this.getTakenPlace();
    _country.takePlaces(_takenPlace);
  }
  
  public void addConnection() {
    boolean _and = false;
    boolean _and_1 = false;
    Country _country = this.getCountry();
    List<Country> _connections = _country.getConnections();
    Country _newConnection = this.getNewConnection();
    boolean _contains = _connections.contains(_newConnection);
    boolean _not = (!_contains);
    if (!_not) {
      _and_1 = false;
    } else {
      Country _newConnection_1 = this.getNewConnection();
      boolean _notEquals = (!Objects.equal(_newConnection_1, null));
      _and_1 = _notEquals;
    }
    if (!_and_1) {
      _and = false;
    } else {
      Country _newConnection_2 = this.getNewConnection();
      Country _country_1 = this.getCountry();
      boolean _notEquals_1 = (!Objects.equal(_newConnection_2, _country_1));
      _and = _notEquals_1;
    }
    if (_and) {
      Country _country_2 = this.getCountry();
      Country _newConnection_3 = this.getNewConnection();
      _country_2.addConnections(_newConnection_3);
    }
  }
  
  public void takeConnection() {
    Country _country = this.getCountry();
    Country _takenConnection = this.getTakenConnection();
    _country.takeConnections(_takenConnection);
  }
  
  public List<InterestPlace> getPlaces() {
    GameSystem _gameSystem = this.getGameSystem();
    return _gameSystem.getInterestPlaces();
  }
}
