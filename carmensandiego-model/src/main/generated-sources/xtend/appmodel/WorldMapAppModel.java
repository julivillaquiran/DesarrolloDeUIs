package appmodel;

import country.Country;
import model.GameSystem;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class WorldMapAppModel {
  private GameSystem _gameSystem;
  
  public GameSystem getGameSystem() {
    return this._gameSystem;
  }
  
  public void setGameSystem(final GameSystem gameSystem) {
    this._gameSystem = gameSystem;
  }
  
  private Country _selectedCountry;
  
  public Country getSelectedCountry() {
    return this._selectedCountry;
  }
  
  public void setSelectedCountry(final Country selectedCountry) {
    this._selectedCountry = selectedCountry;
  }
  
  public WorldMapAppModel(final GameSystem gameSystem) {
    this.setGameSystem(gameSystem);
  }
  
  public void removeCountry() {
    GameSystem _gameSystem = this.getGameSystem();
    Country _selectedCountry = this.getSelectedCountry();
    _gameSystem.removeCountries(_selectedCountry);
  }
}
