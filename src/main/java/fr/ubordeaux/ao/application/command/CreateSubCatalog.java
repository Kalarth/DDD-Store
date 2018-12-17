package fr.ubordeaux.ao.application.command;
import fr.ubordeaux.ao.domain.model.Catalog;

public class CreateSubCatalog implements Command{
  private Catalog catalog;
  private Catalog subcatalog;

  public CreateSubCatalog(Catalog catalog, Catalog subcatalog){
    this.catalog = catalog;
    this.subcatalog = subcatalog;
  }

  public Execute(){
    catalog.addSubCatalog(subcatalog);
  }
}
