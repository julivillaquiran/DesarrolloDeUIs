package appmodel;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import model.GameSystem;
import org.uqbar.commons.utils.Observable;
import villain.Gender;
import villain.Hobbie;
import villain.Villain;

@Observable
@SuppressWarnings("all")
public class CreateVillainAppModel {
  private Villain _villain;
  
  public Villain getVillain() {
    return this._villain;
  }
  
  public void setVillain(final Villain villain) {
    this._villain = villain;
  }
  
  private Villain _selectedVillain;
  
  public Villain getSelectedVillain() {
    return this._selectedVillain;
  }
  
  public void setSelectedVillain(final Villain selectedVillain) {
    this._selectedVillain = selectedVillain;
  }
  
  private Hobbie _newHobbie;
  
  public Hobbie getNewHobbie() {
    return this._newHobbie;
  }
  
  public void setNewHobbie(final Hobbie newHobbie) {
    this._newHobbie = newHobbie;
  }
  
  private Hobbie _takenHobbie;
  
  public Hobbie getTakenHobbie() {
    return this._takenHobbie;
  }
  
  public void setTakenHobbie(final Hobbie takenHobbie) {
    this._takenHobbie = takenHobbie;
  }
  
  private String _newSign;
  
  public String getNewSign() {
    return this._newSign;
  }
  
  public void setNewSign(final String newSign) {
    this._newSign = newSign;
  }
  
  private String _takenSign;
  
  public String getTakenSign() {
    return this._takenSign;
  }
  
  public void setTakenSign(final String takenSign) {
    this._takenSign = takenSign;
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
  
  public CreateVillainAppModel(final GameSystem gameSystem, final Villain selectedVillain, final boolean edit) {
    this.setGameSystem(gameSystem);
    this.setEdit(edit);
    if (edit) {
      this.setVillain(selectedVillain);
    } else {
      Villain _villain = new Villain();
      this.setVillain(_villain);
    }
  }
  
  public void addVillain() {
    boolean _and = false;
    GameSystem _gameSystem = this.getGameSystem();
    List<Villain> _villains = _gameSystem.getVillains();
    Villain _villain = this.getVillain();
    boolean _contains = _villains.contains(_villain);
    boolean _not = (!_contains);
    if (!_not) {
      _and = false;
    } else {
      Villain _villain_1 = this.getVillain();
      boolean _notEquals = (!Objects.equal(_villain_1, null));
      _and = _notEquals;
    }
    if (_and) {
      GameSystem _gameSystem_1 = this.getGameSystem();
      Villain _villain_2 = this.getVillain();
      _gameSystem_1.addVillains(_villain_2);
    }
  }
  
  public void addHobbie() {
    Villain _villain = this.getVillain();
    Hobbie _newHobbie = this.getNewHobbie();
    _villain.addHobbies(_newHobbie);
  }
  
  public void takeHobbie() {
    Villain _villain = this.getVillain();
    Hobbie _takenHobbie = this.getTakenHobbie();
    _villain.takeHobbies(_takenHobbie);
  }
  
  public void addSign() {
    boolean _and = false;
    Villain _villain = this.getVillain();
    List<String> _signs = _villain.getSigns();
    String _newSign = this.getNewSign();
    boolean _contains = _signs.contains(_newSign);
    boolean _not = (!_contains);
    if (!_not) {
      _and = false;
    } else {
      String _newSign_1 = this.getNewSign();
      boolean _notEquals = (!Objects.equal(_newSign_1, null));
      _and = _notEquals;
    }
    if (_and) {
      Villain _villain_1 = this.getVillain();
      String _newSign_2 = this.getNewSign();
      _villain_1.addSigns(_newSign_2);
    }
  }
  
  public void takeSign() {
    Villain _villain = this.getVillain();
    String _takenSign = this.getTakenSign();
    _villain.takeSigns(_takenSign);
  }
  
  public List<Gender> getGender() {
    Gender[] _values = Gender.values();
    return Arrays.<Gender>asList(_values);
  }
  
  public List<Hobbie> getHobbies() {
    Hobbie[] _values = Hobbie.values();
    return Arrays.<Hobbie>asList(_values);
  }
  
  public List<String> getSigns() {
    Villain _villain = this.getVillain();
    return _villain.getSigns();
  }
  
  public List<Villain> getFiles() {
    GameSystem _gameSystem = this.getGameSystem();
    return _gameSystem.getFiles();
  }
}
