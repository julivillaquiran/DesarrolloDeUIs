package country;

import country.Places;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class InterestPlace {
  private Places _name;
  
  public Places getName() {
    return this._name;
  }
  
  public void setName(final Places name) {
    this._name = name;
  }
  
  public Object message() {
    return null;
  }
}
