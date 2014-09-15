package model;

import country.Country;
import java.util.List;

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
