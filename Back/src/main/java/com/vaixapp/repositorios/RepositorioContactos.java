package com.vaixapp.repositorios;


import com.vaixapp.model.Cliente;
import com.vaixapp.model.Contacto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RepositorioContactos {

    public static List<Contacto> listarTodosLosContactos(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();
        List<Contacto> listadoDeContactos = em.createQuery("FROM Contacto").getResultList();
        return listadoDeContactos;
    }

    public static Contacto buscarContacto(Long id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();
        return em.find(Contacto.class, id);
    }

    public static void agregarContacto(Contacto contacto){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(contacto);
        em.getTransaction().commit();
    }

}
