package fr.ubordeaux.ao.infrastructure.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.model.Reference;

public class CatalogImpl implements Catalog {
    private CatalogName name;
    private Map<String, Catalog> subcatalogs;
    private Map<String, Reference> references;

    public CatalogImpl(CatalogName name){
      this.setName(name);
      //this.name = new CatalogName();
      this.references = new HashMap<String, Reference>();
      this.subcatalogs = new HashMap<String, Catalog>();
    }


    public int size() {
      int size = references.size();
      for (Catalog subcatalog : this.subcatalogs.values()){
        size = size + subcatalog.size();
      }
      return size;
    }

    public Set<Reference> getOwnReferences() {
        Set<Reference> result = new HashSet<Reference>();
        result.addAll(references.values());
        return result;
    }

    public Set<Reference> getAllReferences(){
      Set<Reference> result = new HashSet<Reference>();
      getAllReferences_recursive(result);
      return result;
    }

    public void getAllReferences_recursive(Set<Reference> result){
      result.addAll(this.references.values());
      for (Catalog sub : this.subcatalogs.values()){
        sub.getAllReferences_recursive(result);
      }
    }

    public Reference findReferenceById(String id) {
        if (!references.containsKey(id)) throw new ReferenceManagementException("cannot find Reference, id unknown !");
        return references.get(id);
    }

    public void createSubCatalog(){
      CatalogName name = new CatalogName();
      if (this.getName() == name.getStringName()){
        throw new ReferenceManagementException("Error : The subcatalog can't have the same name as the main catalog.");
      }
      for (Catalog sub : this.subcatalogs.values()){
        if (sub.getName() == name.getStringName()){
          throw new ReferenceManagementException("Error : A subcatalog already has the same name.");
        }
      }
      Catalog temp = new CatalogImpl(name);
      this.addSubCatalog(temp);
    }

    public void addSubCatalog(Catalog catalog){
      subcatalogs.put(catalog.getName(),catalog);
    }

    public void removeSubCatalog(Catalog catalog){
      subcatalogs.remove(catalog.getName());
    }

    public void addReference(Reference reference) {
        references.put(reference.getId(), reference);
    }

    public void removeReference(Reference reference) {
        references.remove(reference.getId());
    }

    public String getName(){
      return this.name.getStringName();
    }

    public void setName(CatalogName name){
      this.name = name;
    }
}
