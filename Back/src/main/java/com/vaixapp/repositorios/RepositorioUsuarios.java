package com.vaixapp.repositorios;

import com.vaixapp.model.Cliente;
import com.vaixapp.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RepositorioUsuarios {

    public static List<Usuario> listarTodosLosUsuarios(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();
        List<Usuario> listadoDeUsuarios = em.createQuery("FROM Usuario").getResultList();
        return listadoDeUsuarios;
    }

    public static Usuario buscarUsuario(Long id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();
        return em.find(Usuario.class, id);
    }
}
