package br.ufrn.ceres.bsi.questions;

import br.ufrn.ceres.bsi.questions.dao.UserService;
import br.ufrn.ceres.bsi.questions.dao.exceptions.NonexistentEntityException;
import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Endereco;
import br.ufrn.ceres.bsi.questions.model.Usuario;


public class Main {

    /**
     * M�todo main para testar os conceitos.
     * @param args
     */
    public static void main(String[] args) {

        Endereco endereco = new Endereco();
        endereco.setCity("Caic�");
        endereco.setCountry("Brasil");
        endereco.setStreet("Presidente Kennedy");
        endereco.setSuburb("Acampamento");

        Usuario user1 = new Usuario();
        user1.setUsername("tacianosilva");
        user1.setFirstname("Taciano");
        user1.setLastname("Silva");
        user1.setEmail("tacianosilva@gmail.com");
        user1.setPassword("12345");
        user1.setAddress(endereco);

        Usuario user2 = new Usuario();
        user2.setUsername("xuxa");
        user2.setFirstname("Xuxa");
        user2.setLastname("????");
        user2.setEmail("xuxa@gmail.com");
        user2.setPassword("12345");
        user2.setAddress(endereco);

        UserService service = new UserService(JPAUtil.EMF);
        service.create(user1);
        service.create(user2);

        System.out.println(service.findUser(user1.getId()));
        System.out.println(service.findUser(user2.getId()));

        try {
			service.destroy(user1.getId());
		} catch (NonexistentEntityException e) {
			e.printStackTrace();
		}

        System.out.println(service.findUser(user1.getId()));
        System.out.println(service.findUser(user2.getId()));

    }
}