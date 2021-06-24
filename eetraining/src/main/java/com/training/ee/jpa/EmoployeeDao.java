package com.training.ee.jpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EmoployeeDao {

    @PersistenceContext(unitName = "eetraining")
    private EntityManager em;


    //    @PersistenceUnit(unitName = "eetraining")
    //    private EntityManagerFactory entityManagerFactory;

    //    public void test() {
    //        EntityManager createEntityManagerLoc = entityManagerFactory.createEntityManager();
    //        createEntityManagerLoc.close();
    //    }
    public void add(final Employee employee) {
        this.em.persist(employee);
        // employee.setName("ali");
    }


    //    public void addJavaVersion(final Employee employee) {
    //        this.em.getTransaction()
    //               .begin();
    //        try {
    //            this.em.persist(employee);
    //            this.em.getTransaction()
    //                   .commit();
    //        } catch (Exception eLoc) {
    //            this.em.getTransaction()
    //                   .rollback();
    //        }
    //
    //    }


}
