package com.vaixapp.repositorios;

import com.vaixapp.model.Caso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class RepositorioCasos {

    public static List<Caso> listarTodosLosCasos(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();
        List<Caso> listadoDeCasos = em.createQuery("FROM Caso").getResultList();
        return listadoDeCasos;
    }

    public static Caso buscarCaso(Long id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();
        return em.find(Caso.class, id);
    }
    public static void agregarCaso(Caso caso){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(caso);
        em.getTransaction().commit();
    }
    public static void actualizarCaso(Caso caso){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(caso);
        em.getTransaction().commit();

    }
}
