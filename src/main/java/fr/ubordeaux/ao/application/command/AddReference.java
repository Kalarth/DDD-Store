package fr.ubordeaux.ao.application.command;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;

public class addReference implements Command{
  private Reference ref;
  private Catalog catalog;

  public addReference(Reference ref, Catalog catalog){
    this.ref = ref;
    this.catalog=catalog;
  }

  public Execute(){
    catalog.addReference(ref);
  }
}
