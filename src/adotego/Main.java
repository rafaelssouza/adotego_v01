package adotego;

import adotego.modelos.Endereco;
import adotego.modelos.Usuario;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Usuario u =  new adotego.controller.UsuarioController().find(1);
       
        System.out.println(u);
    }
    
    public static void testInsert(){
         Usuario u = new Usuario();
        Calendar data = Calendar.getInstance();

        u.setNome("thomaz");
        u.setCpf("3223232");
        u.setEmail("fdjfoidjfod");
        u.setTelefone_celular("2121");
        u.setTelefone_fixo("23232");
        u.setData_nascimento(data);

        Endereco end = new Endereco();
        end.setBairro("campeche");
        end.setCep("88048390");
        end.setNumero(2);
        end.setCidade("fplois");
        end.setRua("jades");
        end.setUf("sc");
        u.setEndereco(end);
          new adotego.controller.UsuarioController().salvar(u);
    }
}
