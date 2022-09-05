package br.com.shoppinglist.application;

import br.com.shoppinglist.model.Lista;
import br.com.shoppinglist.service.ListaDeCompraService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Integer opcao = 0;
        do{
            consoleMostrarMenuPrinciapl();
            opcao = Integer.parseInt(sc.nextLine());
            switch (opcao){
                case 1:
                    System.out.println(" +-- Buscando listas de compras --------+ ");
                    System.out.println(" ");
                    getListas();
                    System.out.println(" ");
                    consoleMostrarMiniMenu();
                    opcao = validarMiniMenu(sc);
                    break;
                case 2:
                    System.out.println(" +-- Criar lista de compras ------------+ ");
                    criarLista(sc);
                    System.out.println(" ");
                    consoleMostrarMiniMenu();
                    opcao = validarMiniMenu(sc);
                    break;
                case 0:
                    System.out.println("saindo...");
                    break;
                default:
                    System.out.println("opção não reconhecida, selecione uma nova opção");
                    System.out.println(" ");
                    break;
            }
        }while (opcao != 0);
    }

    public static void criarLista(Scanner sc){
        System.out.println(" +--------------------------------------+ ");
        System.out.println(" +-- Escreva o nome da nova lista ------+ ");
        String desc = sc.nextLine();
        System.out.println(" Criando... ");
        System.out.println(" ");

        ListaDeCompraService service = new ListaDeCompraService();
        Lista lista = new Lista();
        lista.setDesc(desc);
        service.criarListaDeCompras(lista);
    }

    public static void getListas(){
        ListaDeCompraService service = new ListaDeCompraService();
        List<Lista> listas = service.buscarListasDeCompras();
        int i = 1;
        for(Lista l : listas){
            System.out.println(" Lista - " + i + l.toString());
            i++;
        }
    }

    public static void consoleMostrarMenuPrinciapl(){
        System.out.println(" +--------------------------------------+ ");
        System.out.println(" +-------  Listas de Compras  ----------+ ");
        System.out.println(" ");
        System.out.println(" +-- MENU [Escolha uma opção] ----------+ ");
        System.out.println(" +-- [ 1 ] Buscar listas de compras ----+ ");
        System.out.println(" +-- [ 2 ] Criar lista de compras ------+ ");
        // próximo menu a ser incluído  ->  System.out.println(" +-- [ 3 ] Incluir itens em uma lista --+ ");
        System.out.println(" +-- [ 0 ] Sair ------------------------+ ");
        System.out.println(" +--------------------------------------+ ");
    }

    public static void consoleMostrarMiniMenu(){
        System.out.println(" ");
        System.out.println(" +-- MENU [Escolha uma opção] ----------+ ");
        System.out.println(" +-- [ 1 ] Voltar ao menu principal ----+ ");
        System.out.println(" +-- [ 0 ] Sair ------------------------+ ");
        System.out.println(" +--------------------------------------+ ");
    }

    public static Integer validarMiniMenu(Scanner sc){
        Integer opcao = Integer.parseInt(sc.nextLine());
        if(opcao > 1 || opcao < 0){
            System.out.println("opção não reconhecida, saindo...");
            return 0;
        }else if(opcao == 0){
            System.out.println("saindo...");
        }
        return opcao;
    }
}
