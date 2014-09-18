package appmodel;

import model.GameSystem;
import org.uqbar.commons.utils.Observable;
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
  
  private boolean _toEdit;
  
  public boolean isToEdit() {
    return this._toEdit;
  }
  
  public void setToEdit(final boolean toEdit) {
    this._toEdit = toEdit;
  }
  
  public FilesWindowAppModel(final GameSystem gameSystem, final boolean toEdit) {
    this.setToEdit(toEdit);
    this.setGameSystem(gameSystem);
  }
}
