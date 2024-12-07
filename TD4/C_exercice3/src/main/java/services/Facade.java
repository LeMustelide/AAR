package services;

import entities.Categorie;
import entities.Gestionnaire;
import entities.Produit;
import entities.Vente;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;

    /**
     * Renvoie le produit dont l'id est fourni. et null si non trouvé.
     * @param idProduit
     * @return
     */
    public Produit findById(int idProduit)
    {
        return em.find(Produit.class,idProduit);
    }

    /**
     * Renvoie le nom du produit correspondant à la plus grosse ligne de vente
     * @return
     */
    public String  nomProduitPlusGrosseLigne()
    {
        Query q = em.createQuery("Select l.produit.nomProduit From LigneVente l Where l.quantite=(Select Max(lv.quantite) From LigneVente lv)");
        return (String) q.getSingleResult();
    }

    /**
     * Renvoie le produit dont les ventes sont les plus grandes en nombre d'unité (en quantité)
     * VOUS NE POURREZ PAS LE FAIRE DIRECTEMENT EN JPQL OU SQL : PASSEZ PAR UNE VUE DANS LA BD ET UNE REQUETE NATIVE
     * OU PAR UN PEU DE TRAITEMENT EN JAVA...
     * @return
     */
    public Produit plusGrosseVenteQuantite()
    {
        return em.createQuery("Select p From Produit p Order By p.ventes.size Desc",Produit.class).setMaxResults(1).getSingleResult();
    }

    /**
     * Renvoie le produit dont les ventes génèrent le plus gros chiffre d'affaire (quantité * prix unitaire)
     * VOUS NE POURREZ PAS LE FAIRE DIRECTEMENT EN JPQL OU SQL : PASSEZ PAR UNE VUE DANS LA BD ET UNE REQUETE NATIVE
     * OU PAR UN PEU DE TRAITEMENT EN JAVA...
     * @return
     */
    public Produit plusGrosseVenteMontant() {

        return em.createQuery("Select p From Produit p Order By p.ventes.size Desc",Produit.class).setMaxResults(1).getSingleResult();
    }

    /**
     * Renvoie la liste des produits dont le stock est inférieur ou égal à stockMini
     * @param stockMini
     * @return
     */
    public List<Produit> stockSous(int stockMini) {
        return em.createQuery("Select p From Produit p Where p.stock<=:stockMini",Produit.class).setParameter("stockMini",stockMini).getResultList();
    }
    /**
     * Renvoie la liste des ventes comportant le produit dont l'id est en paramètre
     * @param idProduit
     * @return
     */
    public List<Vente> ventesDe(int idProduit) {
        return null;
    }

      /**
     * Renvoie la liste ** dates de commande *** des ventes comportant le produit dont l'id est en paramètre
     * @param idProduit
     * @return
     */
    public List<LocalDate> datesVentesDe(int idProduit) {
        return null;
    }

    /**
     * Renvoie la liste de sproduits qui n'ont jamais été vendus (aucune vente)
     * @return
     */
    public List<Produit> produitsNonVendus() {
        return null;
    }

    /**
     * Renvoie les gestionnaires qui ont déjà passé des demandes d'approvisionnement pour le produit en paramètre
     * @param idProduit
     * @return
     */
    public List<Gestionnaire> acheteurDe(int idProduit){
        return null;
    }

    /**
     * Renvoie le produit le moins cher de la catégorie indiquée.
     * @param idCategorie
     * @return
     */
    public Produit moinsCherDe(int idCategorie) {
        return null;
    }

    /**
     * Renvoie la catégorie du produit indiqué.
     * @param idProduit
     * @return
     */
    public Categorie categorieDe(int idProduit) {
        return null;
    }
}
