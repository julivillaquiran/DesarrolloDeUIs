package gameCase;

import country.Country;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.uqbar.commons.utils.Observable;
import villain.Villain;

@Observable
@SuppressWarnings("all")
public class Case {
  private List<Country> _escapeRoute;
  
  public List<Country> getEscapeRoute() {
    return this._escapeRoute;
  }
  
  public void setEscapeRoute(final List<Country> escapeRoute) {
    this._escapeRoute = escapeRoute;
  }
  
  private Villain _responsable;
  
  public Villain getResponsable() {
    return this._responsable;
  }
  
  public void setResponsable(final Villain responsable) {
    this._responsable = responsable;
  }
  
  private String _caseName;
  
  public String getCaseName() {
    return this._caseName;
  }
  
  public void setCaseName(final String caseName) {
    this._caseName = caseName;
  }
  
  private String _description;
  
  public String getDescription() {
    return this._description;
  }
  
  public void setDescription(final String description) {
    this._description = description;
  }
  
  private Country _currentCountry;
  
  public Country getCurrentCountry() {
    return this._currentCountry;
  }
  
  public void setCurrentCountry(final Country currentCountry) {
    this._currentCountry = currentCountry;
  }
  
  public Case(final Villain robber) {
    this.setResponsable(robber);
    ArrayList<Country> _newArrayList = CollectionLiterals.<Country>newArrayList();
    this.setEscapeRoute(_newArrayList);
  }
}
