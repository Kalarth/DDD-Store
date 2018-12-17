package fr.ubordeaux.ao.domain.model;

import java.util.Set;
import fr.ubordeaux.ao.domain.type.CatalogName;
public interface Catalog {
    int size();
    Set<Reference> getOwnReferences();
    Set<Reference> getAllReferences();
    void getAllReferences_recursive(Set<Reference> result);
    Reference findReferenceById(String id);
    void addSubCatalog(Catalog catalog);
    void addReference(Reference reference);
    void removeReference(Reference reference);
    String getName();
    void setName(CatalogName name);

}
