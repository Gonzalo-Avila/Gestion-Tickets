package com.vaixapp.repositorios;

import com.vaixapp.model.Caso;
import com.vaixapp.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RepositorioClientes {

    public static List<Cliente> listarTodosLosClientes(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();
        List<Cliente> listadoDeClientes = em.createQuery("FROM Cliente").getResultList();
        return listadoDeClientes;
    }

    public static Cliente buscarCliente(Long id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();
        return em.find(Cliente.class, id);
    }

    public static void agregarCliente(Cliente cliente){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

}
