package appmodel;

import model.GameSystem;
import org.uqbar.commons.utils.Observable;
import villain.Hobbie;
import villain.Villain;

@Observable
@SuppressWarnings("all")
public class FilesWindowAppModel {
  private GameSystem _gameSystem;
  
  public GameSystem getGameSystem() {
    return this._gameSystem;
  }
  
  public void setGameSystem(final GameSystem gameSystem) {
    this._gameSystem = gameSystem;
  }
  
  private Villain _selectedVillain;
  
  public Villain getSelectedVillain() {
    return this._selectedVillain;
  }
  
  public void setSelectedVillain(final Villain selectedVillain) {
    this._selectedVillain = selectedVillain;
  }
  
  private Hobbie _selectedHobbie;
  
  public Hobbie getSelectedHobbie() {
    return this._selectedHobbie;
  }
  
  public void setSelectedHobbie(final Hobbie selectedHobbie) {
    this._selectedHobbie = selectedHobbie;
  }
  
  private String _selectedSign;
  
  public String getSelectedSign() {
    return this._selectedSign;
  }
  
  public void setSelectedSign(final String selectedSign) {
    this._selectedSign = selectedSign;
  }
  
  public FilesWindowAppModel(final GameSystem gameSystem) {
    this.setGameSystem(gameSystem);
  }
}
