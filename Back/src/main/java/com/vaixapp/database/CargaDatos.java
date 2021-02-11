package com.vaixapp.database;

import com.vaixapp.model.Caso;
import com.vaixapp.model.Contacto;
import com.vaixapp.model.Cliente;
import com.vaixapp.model.Usuario;
import com.vaixapp.model.enums.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CargaDatos {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vaix_db");
        EntityManager em = factory.createEntityManager();

        //Carga contactos
        Contacto contacto1 = new Contacto();
        contacto1.setNombre("Pablo");
        contacto1.setApellido("Gonzalez");
        contacto1.setEmail("pablogonzalez@gmail.com");
        contacto1.setTelefono("1594958482");
        contacto1.setInformacion("Operario de deposito de Ferpamar");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Marina");
        contacto2.setApellido("Rodriguez");
        contacto2.setEmail("marinaperez@hotmail.com");
        contacto2.setTelefono("1539581223");
        contacto2.setInformacion("Hija del dueño de Ferpamar");

        Contacto contacto3 = new Contacto();
        contacto3.setNombre("German");
        contacto3.setApellido("Gomez");
        contacto3.setEmail("germangomez@yahoo.com.ar");
        contacto3.setTelefono("1515029592");
        contacto3.setInformacion("Administrativo en Waiver");

        Contacto contacto4 = new Contacto();
        contacto4.setNombre("Maria");
        contacto4.setApellido("Peralta");
        contacto4.setEmail("mariaperalta@gmail.com");
        contacto4.setTelefono("1511459963");
        contacto4.setInformacion("Administrativa en Waiver");

        Contacto contacto5 = new Contacto();
        contacto5.setNombre("Mario");
        contacto5.setApellido("Ramirez");
        contacto5.setEmail("marioramirez@gmail.com");
        contacto5.setTelefono("1552953363");
        contacto5.setInformacion("Dueño de Waiver");

        Contacto contacto6 = new Contacto();
        contacto6.setNombre("Oscar");
        contacto6.setApellido("Benitez");
        contacto6.setEmail("oscarbenitez@gmail.com");
        contacto6.setTelefono("1505926365");
        contacto6.setInformacion("Dirige su propio estudio");

        //Carga empresas
        Cliente cliente1 = new Cliente();
        List<Contacto> contactos1 = new ArrayList<>();
        contactos1.add(contacto1);
        contactos1.add(contacto2);
        cliente1.setRazonSocial("Ferpamar");
        cliente1.setContactos(contactos1);
        cliente1.setDireccion("Libertador 1900 5ºC");
        cliente1.setEncargado(contacto2);
        cliente1.setInformacion("Empresa dedicada a la venta de insumos escolares");

        Cliente cliente2 = new Cliente();
        List<Contacto> contactos2 = new ArrayList<>();
        contactos2.add(contacto3);
        contactos2.add(contacto4);
        contactos2.add(contacto5);
        cliente2.setRazonSocial("Waiver");
        cliente2.setContactos(contactos2);
        cliente2.setDireccion("Ayacucho 3000 PB");
        cliente2.setEncargado(contacto5);
        cliente2.setInformacion("Empresa dedicada a logistica de aduanas");

        Cliente cliente3 = new Cliente();
        List<Contacto> contactos3 = new ArrayList<>();
        contactos3.add(contacto6);
        cliente3.setRazonSocial("Estudio Benitez");
        cliente3.setContactos(contactos3);
        cliente3.setDireccion("Santa Fe 2500 1º B");
        cliente3.setEncargado(contacto6);
        cliente3.setInformacion("Estudio contable");

        //Carga usuarios
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Gonzalo");
        usuario1.setApellido("Avila");
        usuario1.setEmail("gonzalo.avila@vaix.com");
        usuario1.setRol(TipoUsuario.TECNICO);
        usuario1.setTelefono("1534993753");
        usuario1.setUsername("Goner");
        usuario1.setUsername("123456");
        usuario1.setFechaAlta(LocalDateTime.now());

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Martin");
        usuario2.setApellido("Perez");
        usuario2.setEmail("martin.perez@vaix.com");
        usuario2.setRol(TipoUsuario.ADMIN);
        usuario2.setTelefono("1511134445");
        usuario2.setUsername("martin");
        usuario2.setUsername("123456");
        usuario2.setFechaAlta(LocalDateTime.now());

        //Carga de casos
        Caso caso1 = new Caso();
        caso1.setTitulo("Problema con mail");
        caso1.setDescripcion("El usuario afirma que no está pudiendo enviar ni recibir correos");
        caso1.setFechaApertura(LocalDateTime.now());
        caso1.setCliente(cliente1);
        caso1.setEstado(EstadoDeCaso.PENDIENTE);
        caso1.setTecnicoAsignado(usuario1);
        caso1.setCategoria(CategoriaCaso.MAIL);
        caso1.setPrioridad(PrioridadCaso.ALTA);

        Caso caso2 = new Caso();
        caso2.setTitulo("Server caido");
        caso2.setDescripcion("No funcionan los servicios desde la mañana.");
        caso2.setFechaApertura(LocalDateTime.now());
        caso2.setCliente(cliente2);
        caso2.setEstado(EstadoDeCaso.PENDIENTE);
        caso2.setTecnicoAsignado(usuario2);
        caso2.setCategoria(CategoriaCaso.SERVIDORES);
        caso2.setPrioridad(PrioridadCaso.URGENTE);

        Caso caso3 = new Caso();
        caso3.setTitulo("No hay red");
        caso3.setDescripcion("Los usuarios afirman no poderse conectar a internet ni a los recursos locales");
        caso3.setFechaApertura(LocalDateTime.now());
        caso3.setCliente(cliente2);
        caso3.setEstado(EstadoDeCaso.PENDIENTE);
        caso3.setTecnicoAsignado(usuario2);
        caso3.setCategoria(CategoriaCaso.RED);
        caso3.setPrioridad(PrioridadCaso.ALTA);


        Caso caso4 = new Caso();
        caso4.setTitulo("Problema con impresora");
        caso4.setDescripcion("El usuario no está pudiendo imprimir los reportes");
        caso4.setFechaApertura(LocalDateTime.now());
        caso4.setCliente(cliente3);
        caso4.setEstado(EstadoDeCaso.PENDIENTE);
        caso4.setTecnicoAsignado(usuario1);
        caso4.setCategoria(CategoriaCaso.IMPRESORAS);
        caso4.setPrioridad(PrioridadCaso.BAJA);

        em.getTransaction().begin();
        em.persist(contacto1);
        em.persist(contacto2);
        em.persist(contacto3);
        em.persist(contacto4);
        em.persist(contacto5);
        em.persist(contacto6);

        em.persist(usuario1);
        em.persist(usuario2);

        em.persist(cliente1);
        em.persist(cliente2);
        em.persist(cliente3);

        em.persist(caso1);
        em.persist(caso2);
        em.persist(caso3);
        em.persist(caso4);
        em.getTransaction().commit();
    }
}
