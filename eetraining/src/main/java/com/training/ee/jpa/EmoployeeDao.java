package com.training.ee.jpa;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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


    public Employee find(final Long employeeIdParam) {
        return this.em.find(Employee.class,
                            employeeIdParam);
    }


    public List<Employee> findByName(final String employeeNameParam) {
        TypedQuery<Employee> createQueryLoc = this.em.createQuery("select e from Employee e where e.name=:abc",
                                                                  Employee.class);
        createQueryLoc.setParameter("abc",
                                    employeeNameParam);
        List<Employee> resultListLoc = createQueryLoc.getResultList();
        return resultListLoc;
    }

    public List<Employee> findByNameAndSurnameNamed(final String employeeNameParam,
                                                    final String employeeSurnameParam) {
        TypedQuery<Employee> createQueryLoc = this.em.createNamedQuery("find_by_name_and_surname",
                                                                       Employee.class);
        createQueryLoc.setParameter(1,
                                    employeeNameParam);
        createQueryLoc.setParameter(2,
                                    employeeSurnameParam);
        List<Employee> resultListLoc = createQueryLoc.getResultList();
        return resultListLoc;
    }

    public List<Employee> findByNameNamed(final String employeeNameParam) {
        TypedQuery<Employee> createQueryLoc = this.em.createNamedQuery("find_by_name",
                                                                       Employee.class);
        createQueryLoc.setParameter("abc",
                                    employeeNameParam);
        List<Employee> resultListLoc = createQueryLoc.getResultList();
        return resultListLoc;
    }

    public List<Employee> findByNameNative(final String employeeNameParam) {
        Query createQueryLoc = this.em.createNativeQuery("select * from calisan e where e.isim=:abc",
                                                         Employee.class);
        createQueryLoc.setParameter("abc",
                                    employeeNameParam);
        List<Employee> resultListLoc = createQueryLoc.getResultList();
        return resultListLoc;
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
