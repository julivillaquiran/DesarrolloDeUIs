package villain;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;
import villain.Gender;
import villain.Hobbie;

@Observable
@SuppressWarnings("all")
public class Villain {
  private String _name;
  
  public String getName() {
    return this._name;
  }
  
  public void setName(final String name) {
    this._name = name;
  }
  
  private Gender _sex;
  
  public Gender getSex() {
    return this._sex;
  }
  
  public void setSex(final Gender sex) {
    this._sex = sex;
  }
  
  private List<String> _signs = CollectionLiterals.<String>newArrayList();
  
  public List<String> getSigns() {
    return this._signs;
  }
  
  public void setSigns(final List<String> signs) {
    this._signs = signs;
  }
  
  private List<Hobbie> _hobbies = CollectionLiterals.<Hobbie>newArrayList();
  
  public List<Hobbie> getHobbies() {
    return this._hobbies;
  }
  
  public void setHobbies(final List<Hobbie> hobbies) {
    this._hobbies = hobbies;
  }
  
  public void addHobbies(final Hobbie newHobbie) {
    boolean _and = false;
    List<Hobbie> _hobbies = this.getHobbies();
    boolean _contains = _hobbies.contains(newHobbie);
    if (!_contains) {
      _and = false;
    } else {
      boolean _notEquals = (!Objects.equal(newHobbie, null));
      _and = _notEquals;
    }
    if (_and) {
      return;
    }
    List<Hobbie> _hobbies_1 = this.getHobbies();
    _hobbies_1.add(newHobbie);
    List<Hobbie> _hobbies_2 = this.getHobbies();
    ObservableUtils.firePropertyChanged(this, "hobbies", _hobbies_2);
  }
  
  public void takeHobbies(final Hobbie takenHobbie) {
    List<Hobbie> _hobbies = this.getHobbies();
    _hobbies.remove(takenHobbie);
    List<Hobbie> _hobbies_1 = this.getHobbies();
    ObservableUtils.firePropertyChanged(this, "hobbies", _hobbies_1);
  }
  
  public void addSigns(final String newSign) {
    List<String> _signs = this.getSigns();
    _signs.add(newSign);
    List<String> _signs_1 = this.getSigns();
    ObservableUtils.firePropertyChanged(this, "signs", _signs_1);
  }
  
  public void takeSigns(final String takenSign) {
    List<String> _signs = this.getSigns();
    _signs.remove(takenSign);
    List<String> _signs_1 = this.getSigns();
    ObservableUtils.firePropertyChanged(this, "signs", _signs_1);
  }
}
