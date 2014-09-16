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
  
  private Villain _caseVillain;
  
  public Villain getCaseVillain() {
    return this._caseVillain;
  }
  
  public void setCaseVillain(final Villain caseVillain) {
    this._caseVillain = caseVillain;
  }
  
  public Case() {
    ArrayList<Country> _newArrayList = CollectionLiterals.<Country>newArrayList();
    this.setEscapeRoute(_newArrayList);
    this.generateEscapeRoute();
  }
  
  public Object generateEscapeRoute() {
    return null;
  }
  
  public String description() {
    return "Esta es la descripcion del caso";
  }
}
