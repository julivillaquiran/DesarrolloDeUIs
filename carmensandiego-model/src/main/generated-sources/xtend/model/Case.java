package model;

import java.util.List;
import model.Country;

@SuppressWarnings("all")
public class Case {
  private List<Country> _countries;
  
  public List<Country> getCountries() {
    return this._countries;
  }
  
  public void setCountries(final List<Country> countries) {
    this._countries = countries;
  }
}
