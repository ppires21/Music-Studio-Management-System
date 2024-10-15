package frontend;
import backend.Administrador;
import backend.Album;
import backend.Instrumento;
import backend.ListaAlbuns;
import backend.ListaInstrumentos;
import backend.ListaMusicas;
import backend.ListaRequisicoes;
import backend.ListaSessoes;
import backend.ListaUtilizadores;
import backend.Musica;
import backend.Musico;
import backend.Produtor;
import backend.Requisicao;
import backend.Sessao;
import backend.Utilizador;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


public class Programa {
        
        
                            // INICIALIZAÇÕES NECESSÁRIAS- Objetos
                            
        static ListaUtilizadores lu = new ListaUtilizadores();    
        static ListaAlbuns la = new ListaAlbuns();
        static ListaInstrumentos li = new ListaInstrumentos();
        static ListaRequisicoes lr = new ListaRequisicoes();
        static ListaSessoes ls = new ListaSessoes();
        static ListaMusicas lm = new ListaMusicas();
        static Album al = new Album();
        static Produtor p1= new Produtor();
        static Musico m1 = new Musico();
        static Requisicao r1=new Requisicao();
        static Instrumento i1 = new Instrumento();
        static Sessao s1 = new Sessao();
                            
                            //INICIALIZAÇÕES NECESSÁRIAS- Variáveis utilizadas
        static String user, pass;     
        static int choice;    
        
    //--------------------------------------------------------------------------CENAS ATOA--------------------------------------------------------------
    public final static void clearConsolenotIDE(){
    try
    {
        final String os = System.getProperty("os.name");
        
        if (os.contains("Windows"))
        {
            Runtime.getRuntime().exec("cls");
        }
        else
        {
            Runtime.getRuntime().exec("clear");
        }
    }
    catch (final IOException e)
    {
        //  Handle any exceptions.
    }
}
    
    public final static void clearConsole(){
    for (int i = 0; i < 50; ++i) System.out.println();
}
    
    public static Produtor retornauserprod(Utilizador u){  
        return (Produtor)u;
    }
    
    public static Musico retornausermus(Utilizador u){
        return (Musico)u;
    }
    
    public static LocalDate adicionadata(String texto){
        
        LocalDate data = null;
         //do{

           // try{
                data = LocalDate.parse(texto);
            //} catch (Exception e) {
             //   System.out.println("não é uma data válida");
            //}
        //} while (data == null);

        return data;
    }
    
   
   
    //--------------------------------------------------------------------------LOGIN-------------------------------------------------------------------
    
    public static void login() throws Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println("\n\nBem vindo ao controlmusic");        
        int repeat=0;
        do{
            System.out.print("\nUsername: ");
            user= input.next();
            System.out.print("Password: ");
            pass= input.next();
            

            if(lu.verificauser(user, pass) == true)
            {
                clearConsole();
                System.out.println("O login foi feito com sucesso. Bem vindo "+lu.retornauser(user, pass).getNomeverdadeiro()+".");
                repeat=1;
            }
            else 
            {
                System.out.println("\n\nErro. Tente novamente");
                repeat=0;
            }                                                                             
    } while(repeat==0);
        
        if (lu.retornauser(user, pass) instanceof Administrador)
        {
            menuadminprincipal();
        }
        else if (lu.retornauser(user, pass) instanceof Produtor)
        {
            menuprodprincipal();
        }
   
        else if(lu.retornauser(user, pass) instanceof Musico)
        {
            menumusprincipal();
        }
        
    }
    
    //--------------------------------------------------------------------------MENUADMIN---------------------------------------------------------------
    
    public static void menuadminprincipal() throws Exception{
        Scanner input=new Scanner (System.in);
        
        clearConsole();
        System.out.println("Insira a opção desejada: \n\n");
        System.out.println("--------------------------------");
        System.out.println("1- Gerir requisições de Albuns");
        System.out.println("2- Gerir requisições de Instrumentos");
        System.out.println("3- Gerir utilizadores");        //Depois leva para a página em que se pode adicionar ou apagar            
        System.out.println("4- Gerir albuns");
        System.out.println("5- Gerir instrumentos");
        System.out.println("6- Todas as músicas da editora");
        System.out.println("7- Estatísticas");
        System.out.println("8- Terminar sessão");
        System.out.println("--------------------------------");
        
        choice=567894;
            do{
                try{
                    if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
                        choice=input.nextInt();
                }catch(Exception E){menuadminprincipal();}
                
            }while(choice>8 || choice<1);  
            
            switch(choice)
            {
                case 1: 
                    menuadmingerirrequisiçõesAlbuns();
                break;
                
                case 2:
                    menuadmingerirrequisiçõesInstrumentos();
                break;
                
                case 3:
                    menuadmingerirutilizadores();
                break;
                
                case 4:
                    menuadmingeriralbuns();
                break;
                
                case 5:
                    menuadmingeririnstrumentos();
                break;   
                
                case 6:
                    menuadmintodasasmusicas();
                break;
                
                case 7:
                    menuadminestatisticas();
                break;
                
                case 8:
                    menuadminterminarsessao();
                break;
                    
            }
          
    }          
                                                                                           //Requisições de albuns- menu- feito
    public static void menuadmingerirrequisiçõesAlbuns() throws Exception {        
        Scanner input=new Scanner (System.in);
        
        System.out.println("-----------------------------------");
        System.out.println("Requisições de Albuns:\n");
        System.out.println("1- Pedidos de requisição pendentes");
        System.out.println("2- Ver todos- Por estado");
        System.out.println("3- Voltar atrás");
        System.out.println("-----------------------------------");

        choice=567894;
        
        do{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente requisições admin:");
            choice=input.nextInt();
            
        } while(choice<1 || choice>3); 
        
        switch(choice){
            case 1:
                submenuadminpedrequisiçaoalbuns();
            break;
            
            case 2:
                submenuadmintodasrequisiçoesalbuns();
            break;
            
            case 3: 
                menuadminprincipal();
            break;
        }
        
    }
    
     public static void menuadmingerirrequisiçõesInstrumentos() throws IOException, ClassNotFoundException, Exception{       
         Scanner input=new Scanner (System.in);
        
        System.out.println("-----------------------------------");
        System.out.println("Requisições de Instrumentos:\n");
        System.out.println("1- Pedidos de requisição pendentes");
        System.out.println("2- Ver todos- Por estado");
        System.out.println("3- Voltar atrás");
        System.out.println("-----------------------------------");

        choice=567894;

        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente requisições admin:");
            choice=input.nextInt();
            }catch(Exception E){menuadmingerirrequisiçõesInstrumentos();}
        } while(choice<1 || choice>3); 
        
        switch(choice){
            case 1:
                submenuadminpedrequisiçaoinstrumentos();
            break;
            
            case 2:
                submenuadmintodasrequisiçoesinstrumentos();
            break;
            
            case 3: 
                menuadminprincipal();
            break;
        }
    }
    
    public static void submenuadminpedrequisiçaoinstrumentos() throws IOException, ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        //System.out.println(lr.verificaseexiste(idd));
        carregadados();
        System.out.println();
        System.out.println(lr.listarreqpendentesinst());
        System.out.println();
        
        
        System.out.println("1- Aceitar pedido");
        System.out.println("2- Recusar pedido");
        System.out.println("3- Voltar atrás");
        int idd = 0;
        
        choice=567894;
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
            choice=input.nextInt();
            }catch(Exception E){submenuadminpedrequisiçaoinstrumentos();}
        }while(choice<1 || choice>3); 
        
        switch(choice){
            case 1:
                
                System.out.print("Id da requisição a ser aceite: ");
                idd=input.nextInt();
                
                System.out.println(lr.verificaseexiste(idd));
                
                lr.aceitarRequisiçao(idd);                
                i1.construtorimprovisado(lr.getNomeinstrumento(idd));             // cria o instrumento para adicionar         
                ls.adicionaInstrumento(idd, i1);                                  // adiciona o instrumento à sessão
                li.instrumentoreqaceite(lr.getmusRequisiçao(idd), lr.getNomeinstrumento(idd));      //adiciona músico ao instrumento e diminui a sua quantidade disponivel
                lr.getmusRequisiçao(idd).adicionaInstrumentoMusico(li.getInstrumento(lr.getNomeinstrumento(idd)));  //adiciona o instrumento ao músico
                
                
                guardadados();
                System.out.println("Requisição aceite com sucesso!");
                input.nextLine();
                menuadmingerirrequisiçõesInstrumentos();
                
            break;
            
            case 2:
                System.out.print("Id da requisição a ser recusada: ");
                try{
                    idd=input.nextInt();
                }catch(Exception E){submenuadminpedrequisiçaoinstrumentos();}
                
                lr.recusarRequisiçao(idd); 
                guardadados();
                System.out.println("Requisição recusada com sucesso!");
                input.nextLine();
                menuadmingerirrequisiçõesInstrumentos();
                
            break;
            
            case 3:
                menuadminprincipal();
            break;
          
        }
    }
     
    public static void submenuadmintodasrequisiçoesinstrumentos() throws ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        carregadados();
        
        System.out.println();
        System.out.println(lr.listarreqinst());
        System.out.println();
        
        input.nextLine();
        menuadmingerirrequisiçõesInstrumentos();
    }
              
    public static void menuadmingerirutilizadores() throws Exception{
        Scanner input=new Scanner (System.in);
        
        //Ir para o menu de gestão de utlizadores - aparece logo todos os utilizadores e depois em baixo as opções
        System.out.println("Gerir utilizadores\n");
        System.out.println("1- Adicionar utilizador");
        System.out.println("2- Remover utilizador");
        System.out.println("3- Ver todos os utilizadores");
        System.out.println("4- Voltar atrás");
        
        choice=567894;
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente gerir albuns:");
            choice=input.nextInt();
            }catch(Exception E){menuadmingerirutilizadores();}
        } while(choice<1 || choice>4);
        switch(choice){
            case 1:
                menuadminadicionarutilizador();
            break;
            
            case 2:
                submenuadminremoverutilizador();
            break;
            
            case 3:
                submenuadminlistarutilizadores();
            break;
            
            case 4:
                menuadminprincipal();
            break;
        }
        
    }
    
    public static void menuadmingeriralbuns() throws Exception{
        Scanner input=new Scanner (System.in);
        
        carregadados();
        System.out.println();
        System.out.println(la.listarAlbuns());
        System.out.println();
    
        System.out.println("1- Adicionar album/single");
        System.out.println("2- Remover album");
        System.out.println("3- Voltar atrás");
        
        choice=567894;
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente gerir albuns:");
            choice=input.nextInt();
            }catch(Exception E){menuadmingeriralbuns();}
        } while(choice<1 || choice>3);
        switch(choice){
            case 1:
                submenuadminadicionaralbum();
            break;
            
            case 2:
                submenuadminremoveralbum();
            break;
            
            case 3:
                menuadminprincipal();
            break;
        }
    }   //da void           
    
    public static void menuadmingeririnstrumentos() throws Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println("--------------------------------");
        System.out.println("Gerir Instrumentos\n");
        System.out.println("1- Ver instrumentos");
        System.out.println("2- Adicionar instrumento");
        System.out.println("3- Retirar instrumento");
        System.out.println("4- Voltar atrás");
        System.out.println("--------------------------------");
        
        
        choice=567894;
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente gerir albuns:");
            choice=input.nextInt();
            }catch(Exception E){menuadmingeririnstrumentos();}
        } while(choice<1 || choice>4);
        
        switch(choice){
            
            case 1:
                submenuadminverinstrumentos();
            break;
            
            case 2:
                submenuadminadicionarinstrumento();
            break;
            
            case 3:
                submenuadminremoverinstrumento();
            break;
            
            case 4:
                menuadminprincipal();
            break;
        }     
    }         
    
    public static void menuadmintodasasmusicas() throws Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println();
        System.out.println(lm.listartodasasmusicas());
        System.out.println();
        
        input.nextLine();
        menuadminprincipal();
    }
       
    public static void menuadminestatisticas() throws Exception{                                    
        Scanner input=new Scanner (System.in);
        
        double medpersessconcl=0;
        
        if(la.size()==0){      
            medpersessconcl=0;
        }
        else{       
        }
        
        System.out.println("--------------------------------------");
        System.out.println("   Estatísticas totais\n");     //Mostrar estas estatísticas 
        System.out.println("Total de albuns em edição: "+la.calcemedicao());
        System.out.println("Total de albuns concluidos: "+la.calcconcluido());
        System.out.println("Total de sessões por concluir: "+ls.calcsessoesporconcluir());
        System.out.println("Total de sessões concluidas: "+ls.calcsessoesconcluidas());
        if(ls.calcsessoesporconcluir()==0 && ls.calcsessoesconcluidas()==0)
        System.out.println("Média de percentagem de sessões de gravação concluidas: Não disponível");
        else
        System.out.println("Média de percentagem de sessões de gravação concluidas: "+la.calcmedpercessconcluidas()+"%");
        System.out.println("Número de total de Produtores registados: "+lu.getnprodutores());
        System.out.println("Numero total de Músicos registados: "+lu.getnmusicos());
        System.out.println("--------------------------------------");

        
        System.out.println("\n1- Escolher mês específico para estatísticas");
        System.out.println("2- Voltar atrás");
        
        choice=567894; 
        
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente requisições admin:");
            choice=input.nextInt();
            }catch(Exception E){menuadminestatisticas();}
        } while(choice<1 || choice>2); 
        
        switch(choice){
            case 1:
                choice=567894; 
                
                int mmonth=567894;
                int yyear=567894;
                
                System.out.println("Insira o ano: ");
                
                do{
                    try{
                        choice=567894;
                    if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
                        input.nextLine();
                    yyear=input.nextInt();
                    }catch(Exception E){menuadminestatisticas();}
                }while(yyear>2023 || yyear<1970);
                
                 System.out.println("Insira o mês: ");
               
                do{
                    mmonth=567894;
                    try{
                    if (mmonth != 567894) System.out.println("Inserção errada. Tente novamente:");
                        mmonth=input.nextInt();
                    }catch(Exception E){mmonth=13;}
                }while(mmonth>12 || mmonth<1);
                
          
                System.out.println("----------------------------------------------------------");
                System.out.println("   Estatísticas do mês "+mmonth+"/"+yyear);     //Mostrar estas estatísticas 
                System.out.println("\nTotal de albuns em edição: "+la.calcemediçaomes(yyear, mmonth));
                System.out.println("Total de albuns editados: "+la.calcconcluidomes(yyear, mmonth));
                System.out.println("Total de sessões por concluir: "+ls.calcsessoesporconcluirmes(yyear, mmonth));
                System.out.println("Total de sessões concluidas: "+ls.calcsessoesporconcluirmes(yyear, mmonth));
                System.out.println("Média de percentagem de sessões de gravação concluidas: "+la.calcmedpercsessconclmes(yyear, mmonth));
                System.out.println("----------------------------------------------------------");
                
                input.nextLine();               
                menuadminprincipal();
            break;
            
            case 2:
                menuadminprincipal();               
            break;
        }  
    }
    
    public static void menuadminterminarsessao() throws Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println("Tem a certeza que pretende mudar de utilizador?\n");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        
        choice=567894;
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
            choice=input.nextInt();
            }catch(Exception E){menuadminterminarsessao();}
        }while(choice>2 || choice<1); 
        
        switch(choice){
            case 1:
                login();
            break;
            
            case 2:
                menuadminprincipal();
            break;
        }
    }
                                                                                                                //EXTRA
    public static void submenuadminpedrequisiçaoalbuns() throws IOException, ClassNotFoundException, Exception                                                              {
        Scanner input=new Scanner (System.in);
        
        carregadados();
        System.out.println(lr.listarreqpendentesalb());
        System.out.println();
        
        
        System.out.println("1- Aceitar pedido");
        System.out.println("2- Recusar pedido");
        System.out.println("3- Voltar atrás");
        int idd = 0;
        choice=567894;
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
            choice=input.nextInt();
             }catch(Exception E){submenuadminpedrequisiçaoalbuns();}
        }while(choice<1 || choice>3); 
        
        switch(choice){
            case 1:
                
                carregadados();
                
                System.out.print("Id da requisição a ser aceite: ");
                try{
                idd=input.nextInt();
                 }catch(Exception E){submenuadminpedrequisiçaoalbuns();}
                
                
                al.transformareqemalbum(lr.getRequisiçao(idd));
                la.adicionar(al);
                lu.adicionaalbumprod(lr.getProdquefez(idd), al);               
                lr.aceitarRequisiçao(idd);
                
            
                guardadados();
                System.out.println("Requisição aceite com sucesso!");
                input.nextLine();
                menuadmingerirrequisiçõesAlbuns();
                
            break;
            
            case 2:
                System.out.print("Id da requisição a ser recusada: ");
                try{
                idd=input.nextInt();
                 }catch(Exception E){submenuadminpedrequisiçaoalbuns();}
                
                lr.recusarRequisiçao(idd);         
                guardadados();
                System.out.println("Requisição recusada com sucesso!");
                input.nextLine();
                menuadmingerirrequisiçõesAlbuns();
                
            break;
            
            case 3:
                menuadminprincipal();
            break;
          
        }
        
        
    }
                                                                                                    //EXTRA
    public static void submenuadmintodasrequisiçoesalbuns() throws Exception{                                                          
        Scanner input=new Scanner (System.in);
        carregadados();
        
        System.out.println(lr.listarreqalb());
        
        input.nextLine();
        menuadmingerirrequisiçõesAlbuns();
        
    }

    public static void menuadminadicionarutilizador() throws Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println("Que tipo de utilizador deseja adicionar?");
        System.out.println("1- Produtor");
        System.out.println("2- Músico");
        System.out.println("3- Voltar atrás");
        
        choice=567894;
        
        do{
            try{
                if (choice != 567894) System.out.println("Inserção errada. Tente novamente:\n");
                choice=input.nextInt();
                }catch(Exception E){menuadminadicionarutilizador();}
            }while(choice>3 || choice<1);   
            switch(choice)
            {
                case 1: 
                    submenuadminadicionarprodutor();
                break;
                    
                case 2:
                    submenuadicionarmusico();
                break;
                
                case 3:
                    menuadmingeriralbuns();
                break;         
            }    
    }
    
    public static void submenuadminadicionarprodutor() throws IOException, Exception{
        Scanner input=new Scanner (System.in);
        String userr;
        
        System.out.println("Nome do novo produtor:");
        String nomm = input.nextLine();
        int ver=0;
        do{
            if(ver==1) System.out.println("Username já existente. Defina um novo");
            System.out.println("Username:");
            userr = input.nextLine();
            
            if(lu.verificauserporuser(userr)==true) ver=1;             
        } while(ver==1);
        
        System.out.println("Palavra passe: ");
        String passs = input.nextLine();
        
        p1.construtorimprovisado(userr, passs, nomm);
        lu.adicionarUtilizador(p1);
        guardadados();
        
        System.out.println("\nConta criada! \n");
        input.nextLine();
        login();
    }
    
    public static void submenuadicionarmusico() throws IOException, Exception{
        Scanner input=new Scanner (System.in);
        String userr, nomm = null;
        
        System.out.println("Nome do novo músico:");
        try{
        nomm = input.nextLine();
        }catch(Exception E){submenuadicionarmusico();}
        int ver=0;
        do{
            if(ver==1) System.out.println("Username já existente. Defina um novo");
            System.out.println("Username:");
            userr = input.nextLine();
            
            if(lu.verificauserporuser(userr)==true) ver=1;             
        } while(ver==1);
        
        System.out.println("Palavra passe: ");
        String passs = input.nextLine();
        
        m1.construtorimprovisado(userr, passs, nomm);
        lu.adicionarUtilizador(m1);
        guardadados();
        
        login();
        
    }
    
    public static void submenuadminremoverutilizador() throws Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println("Qual o user do utilizador que pretende eliminar?");
        String userr = input.nextLine();
        System.out.println("Insira a sua palavra passe para confirmar:");
        String passs = input.nextLine();
       
        if(lu.retornauser(userr, passs) instanceof Administrador)
        {
            System.out.println("Tentativa de remoção bloqueada. Não é permitido remover o administrador");
            System.out.println("O administrador é fundamental para a execução do programa.");
            input.nextLine();
            menuadminprincipal();
        }
        else{
            if (passs.equals(lu.retornauser(user, pass).getPalavrapasse())) lu.removerUtilizador( lu.retornauserporuser(userr) );
            else {
                System.out.println("Palavra passe errada. Tente mais tarde");
                login();
            }
            guardadados();

            menuadminprincipal();
        } 
    }
    
    public static void submenuadminlistarutilizadores() throws Exception{
        Scanner input=new Scanner (System.in);
        
        carregadados();
        
        System.out.println(lu.listarusers());
        input.nextLine();
        
        menuadminprincipal();
        
    }
    
    public static void submenuadminadicionaralbum() throws Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println("Nome Album:");
        String nome = input.nextLine();
        System.out.println("Data do album (YYYY-MM-DD): ");
        String dat = input.nextLine();
        System.out.println("Tipo do Album: ");
        String tipo = input.nextLine();
        
        System.out.println();
        System.out.println(lu.listarusersprod());
        System.out.println();
        
        System.out.println("Qual o produtor a que deseja associar?");
        String prodass;
        choice=12;
        do{
            if(choice==1) System.out.println("Esse produtor não existe. Insira novamente");
            prodass = input.nextLine();
            choice=1;
        }while(lu.retornaprodporuser(prodass) == null);
        
        al.construtorimprovisado(nome, tipo, retornauserprod(lu.retornaprodporuser(prodass)), adicionadata(dat));
        la.adicionar(al);  
        lu.adicionaalbumprod((Produtor)lu.retornaprodporuser(prodass), al);
        guardadados();
        
        System.out.println("\nAlbum criado com sucesso!\n");
        input.nextLine();
        
        menuadmingeriralbuns();
        
    }

    
    public static void submenuadminremoveralbum() throws Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println("Qual o album que pretende remover?");
        String rem = input.nextLine();
        la.remover(la.getAlbum(rem));
        guardadados();
        
        menuadmingeriralbuns();
    }
    
    public static void submenuadminverinstrumentos() throws IOException, ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        
        
        carregadados();
        
        System.out.println(li.listarInstrumentos());
        input.nextLine();
        
        menuadmingeririnstrumentos();
    }
   
    public static void submenuadminadicionarinstrumento() throws Exception{     //Colocar aqui os files, alterar também para adicionar com quantidade diferente de 0
        Scanner input=new Scanner (System.in);
        String fich = "Instrumentos.dat";
        li.lerInstrumentos(fich);
        
        
        System.out.print("Nome instrumento: ");
        String nomeinst=input.nextLine();
        if(li.encontraInstrumento(nomeinst)==true){
             li.incrementaQuantidade(li.getInstrumento(nomeinst));
        }   
        else {
            i1.construtorimprovisado(nomeinst);
            li.adicionar(i1);
        }
        
        guardadados();
        System.out.println("\nInstrumento adicionado com sucesso!");
        input.nextLine();
        System.out.println();
        menuadmingeririnstrumentos();
    }
    
    public static void submenuadminremoverinstrumento() throws Exception{      //adicionar files a isto também
        Scanner input=new Scanner (System.in);
        
        System.out.println("Nome instrumento");
        boolean found = true;
        do{
            String nomeinst=input.nextLine();
            if(li.encontraInstrumento(nomeinst)==true){
                 System.out.println("Deseja retirar uma unidade ou todos os instrumentos desse tipo?\n");
                 System.out.println("1- Retirar uma unidade");
                 System.out.println("2- Retirar todos");
                 //input.nextLine();
                 choice=567894;
                 do{
                     try{
                    if (choice != 567894) System.out.println("Inserção errada. Tente novamente");
                    choice=input.nextInt();
                    }catch(Exception E){submenuadminremoverinstrumento();}
                 }while(choice<1 || choice>2);

                 switch(choice){
                     case 1:
                        li.decrementaQuantidade(li.getInstrumento(nomeinst));
                     break;

                     case 2:
                         li.remover(li.getInstrumento(nomeinst));
                     break;
                 }     
            }   
            else{
                System.out.println("Instrumento não encontrado\n");
                found = false;
            }
        }while(found==false);
        guardadados();     
        System.out.println("\nInstrumento retirado com sucesso!\n");
        input.nextLine();
        menuadmingeririnstrumentos();
    }
    
    
    //--------------------------------------------------------------------------MENUPROD----------------------------------------------------------------
    
    public static void menuprodprincipal() throws IOException, ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        
        clearConsole();
        System.out.println("----------------------------------------------------------");
            System.out.println("Inserir a opção desejada: \n\n");        //VER melhor como deve ficar o menu das sessões e albuns
            System.out.println("1- Gerir albuns e sessões"); 
            System.out.println("2- Calendário de sessões");         // Ver todas as sessões
            System.out.println("3- Sobre mim");
            System.out.println("4- Terminar sessão");
            System.out.println("----------------------------------------------------------");
            
            choice = 567894;
            
            do{
                if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
                choice=input.nextInt();
            }while(choice<1 || choice>4);
            
                switch(choice)
                {
                    case 1:
                        menuprodgeriralbunsesessoes();
                    break;
                    
                    case 2: 
                        menuprodcalendariosessoes();
                    break;
                    
                    case 3:     //Sobre mim
                        menuprodsobremim();                     //fazer o backend para isto
                    break;
                    
                    case 4:
                        menuprodterminarsessao();
                    break;
                }            
        }
    
    public static void menuprodgeriralbunsesessoes() throws IOException, ClassNotFoundException, Exception{   //Mostrar albuns desse produtor e as sessões 
        Scanner input=new Scanner (System.in);

        carregadados();
       
        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println(" 1- Fazer pedido de adicionar album");
        System.out.println(" 2- Editar album");      //edita um album, nada de sessões
        System.out.println(" 3- Albuns por aceitar");      
        System.out.println(" 4- Albuns em produção");
        System.out.println(" 5- Todos os albuns ");        //Podemos colocar também a quantidade dos produzidos e dos albuns em produção
        System.out.println(" 6- Todas as sessões");
        System.out.println(" 7- Editar sessão");
        System.out.println(" 8- Sessões para um determinado dia");
        System.out.println(" 9- Adicionar sessão");
        System.out.println("10- Remover sessão");
        System.out.println("11- Todas as sessões por concluir");        
        System.out.println("12- Voltar atrás");
        System.out.println("----------------------------------------------------------");
        System.out.println();
        
        choice=567894;
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
            choice=Integer.parseInt(input.nextLine());
            }catch(Exception e){menuprodgeriralbunsesessoes();}
        }while(choice<1 || choice>12);
        
        switch(choice){
            case 1:
                menuprodadicionaralbum();
            break;
            
            case 2:
                menuprodeditaralbum();
            break;
            
       //     case 3:
         //       menuprodiniciaralbum();
           // break;
            
            case 3:
                menuprodalbunspendentes();
            break;
            
            case 4:
                menuprodalbunsemproducao();
            break;
            
            case 5:
                menuprodtodososalbuns();
            break;
            
            case 6:
                menuprodtodasassessoes();
            break;
            
            case 7:
                menuprodeditarsessao();
            break;
            
            case 8:
                menuprodsessaoparaumdia();
            break;
            
            case 9:
                menuprodadicionarsessao();
            break;
            
            case 10:
                menuprodremoversessao();
            break;
            
            case 11:
                menuprodtodasassessoesporconcluir();
            break;
            
            case 12:
                menuprodprincipal();
            break;
        }
    }

      
    public static void menuprodcalendariosessoes() throws IOException, ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        carregadados();
        
        System.out.println();
        System.out.println(ls.listarSessoesprod((Produtor) lu.retornauser(user, pass)));
        System.out.println();
        input.nextLine();
        menuprodprincipal();
       
    }
                                                        
    public static void menuprodsobremim() throws ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println("----------------------------------------------------------");
        System.out.println("Nome: "+lu.retornauser(user, pass).getNomeverdadeiro());
        System.out.println("Nome de utilizador: "+lu.retornauser(user, pass).getUserlogin());
        System.out.println("Password: "+lu.retornauser(user, pass).getPalavrapasse());
        System.out.println("----------------------------------------------------------\n\n");
        
        boolean verpass;
        boolean verpasss;
        
        System.out.println("1- Editar");
        System.out.println("2- Sair");
        choice = 567894;
        
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente.");
            choice=input.nextInt();
             }catch(Exception E){menuprodsobremim();}
            
        } while(choice<1 || choice>2);
        
        switch(choice){
            case 1:
                System.out.println("----------------------------------------------------------");
                System.out.println("1- Alterar o meu nome ");
                System.out.println("2- Alterar palavra passe ");
                System.out.println("3- Voltar atrás ");
                System.out.println("----------------------------------------------------------");
                choice = 567894;
                do{
                    try{
                    if (choice != 567894) System.out.println("Inserção errada. Tente novamente.");
                    choice=input.nextInt();
                     }catch(Exception E){menuprodsobremim();}
                }while(choice<1 || choice>3);
                String newpass=null;
                switch(choice){
                    case 1:
                        System.out.print("Novo nome: ");
                        input.nextLine();
                        String name = input.nextLine();
                        System.out.print("Insira a sua palavra-passe atual: ");
                        verpass=true;
                        int count=0;
                        do{
                            if(verpass==false) System.out.println("Palavra passe errada. Insira novamente:");
                            newpass = input.next();
                            verpass=false;                           
                            ++count;
                            if(count==3) login();
                        }while(!lu.retornauserporuser(user).getPalavrapasse().equals(newpass));
                        lu.retornauserporuser(user).setNomeverdadeiro(name);
                        System.out.println("Nome alterado com sucesso!");
                        input.nextLine();
                        menuprodprincipal();                       
                    break;
                    
                    case 2:
                        System.out.print("Palavra passe antiga: ");
                        input.nextLine();
                        String oldpass;
                        verpasss=true;
                        count=0;
                        do{
                            if(verpasss==false) System.out.println("Palavra passe errada. Tente novamente.");
                            oldpass = input.nextLine();
                            verpasss=false;
                            ++count;
                            if(count==3) login();
                        }while(!oldpass.equals(lu.retornauser(user, pass).getPalavrapasse()));
                        String newpass1;
                        String newpass2;
                        do{
                            System.out.print("Nova pass:");
                            newpass1=input.nextLine();

                            System.out.print("Insira novamente a nova pass:");
                            newpass2=input.nextLine();
                            
                        }while(!newpass1.equals(newpass2));
                        lu.retornauser(user, pass).setPalavrapasse(newpass1);
                        System.out.println("Palavra passe atualizada com sucesso!");
                        input.nextLine();
                        String fich="Utilizadores.dat";
                        lu.gravarUtilizadores(fich);
                        login();
                        
                    break;
                    
                    case 3:
                        menuprodprincipal();
                    break;
   
                }
        }
        input.nextLine();
        menuprodprincipal();
    }
        
    public static void menuprodeditaralbum() throws IOException, ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println();
        System.out.println(la.listarAlbunsprod((Produtor) lu.retornauser(user, pass)));
        System.out.println();
        
        System.out.println("Qual o album que deseja editar?");
        String albin = input.nextLine();
        System.out.println();
        
        System.out.println("O que deseja editar em "+albin+"?");
        System.out.println("1- Estado");
        System.out.println("2- Adicionar musica ao album");
        System.out.println("3- Alterar tipo de album");
        System.out.println("4- Editar numero de sessoes do album");
        System.out.println("5- Voltar atrás");
        
        choice = 567894;
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente produtor:");
            choice=input.nextInt();
            }catch(Exception e){menuprodeditaralbum();}
            switch(choice){
                
                case 1:
                    
                    System.out.println("Novo estado: ");       
                    System.out.println("1- Concluido");
                    System.out.println("2- Por concluir");
                    int state=0;
                    do{
                        try{
                    if (state != 0) System.out.println("Inserção errada. Insira novamente:");
                    state = input.nextInt();
                    }catch(Exception e){menuprodeditaralbum();}
                }while(state<1 || state>2);
                    
                    if(state==1){
                        la.setEstado(true, albin);                    
                    }
                    else if(state==2){
                        la.setEstado(true, albin);
                            menuprodgeriralbunsesessoes();
                        }
                    
                    guardadados();
                    menuprodgeriralbunsesessoes();
                    
                break;
                
                case 2:
                    boolean mais=false;
                    boolean maismusicos=false;
                    double dur=0;
                    Musica muzzz = new Musica();
                    do{
                        System.out.println("Nome da música");
                        input.nextLine();
                        String nome = input.nextLine();
                        
                        System.out.println("Duração da música: ");
                        try{
                         
                            dur = input.nextDouble();
                        }catch(Exception e){menuprodgeriralbunsesessoes();}
                        String mus;
                        
                        System.out.println();
                        System.out.println(lu.listarusersmus());
                        System.out.println();
                        
                        System.out.println("Músico: ");
                        do{
                            
                            do{
                                input.nextLine();
                                mus = input.nextLine();

                            }while(lu.retornamusico(mus).equals(null));
                            
                            
                            muzzz.construtorimprovisado(nome, dur, (Musico) lu.retornamusporuser(mus), la.getAlbum(albin));         //  COLOCAR AQUI A ORDEM CERTA
                            muzzz.adicionaDonoMusica((Musico) lu.retornauserporuser(mus));  //adiciona o músico à música
                            retornausermus(lu.retornauserporuser(mus)).adicionaalbum(la.getAlbum(albin));    ////adiciona o músico ao album
                            retornausermus(lu.retornauserporuser(mus)).adicionaMusicaaoMusico(muzzz);
                            lm.adicionar(muzzz);    //Coloca aquele album dado como string nos albuns associados daquele musico 
                            la.getAlbum(albin).adicionamusicosasessao();    //adiciona os músicos à sessão  de gravação desse album
                            
                            System.out.println("Deseja adicionar mais algum musico?");
                            System.out.println("1- Sim");
                            System.out.println("2- Não");
                            
                            choice=567894;
                            do{
                                try{
                                if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
                                choice=input.nextInt();
                                }catch(Exception e){menuprodgeriralbunsesessoes();}
                                
                            }while(choice<1 || choice>2);
                            
                            if(choice==1) maismusicos=true;
                            else if (choice==2) maismusicos=false;
                            
                        }while(maismusicos == true);
                        
                        System.out.println("Deseja adicionar mais alguma música?");
                        System.out.println("1- Sim");
                        System.out.println("2- Não");
                        choice=567894;
                            do{
                                try{
                                if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
                                    choice=input.nextInt();
                                }catch(Exception e){menuprodgeriralbunsesessoes();}
                            }while(choice<1 || choice>2);
                                
                            if(choice==1) mais=true;
                            else if (choice==2) mais=false;
                        
                    }while(mais==true);
                    
                    guardadados();
                   
                    menuprodgeriralbunsesessoes();
                    
                break;
                     
                case 3:
                    System.out.println("Insira o novo tipo:");
                    input.nextLine();
                    String tipp = input.nextLine();
                    la.setTipoalbum(albin, tipp);
                    guardadados();
                    System.out.println("Album editado com sucesso! ");
                    input.nextLine();
                    menuprodgeriralbunsesessoes();
                break;
                
                case 4:
                    System.out.println("Insira o numero de sessoes do album:");
                    int nsess = input.nextInt();
                    la.setnSessoesAlbum(la.getAlbum(albin), nsess);
                    System.out.println("\nNúmero de sessões definido\n");
                    menuprodgeriralbunsesessoes();
                break;
                
                case 5:
                    menuprodgeriralbunsesessoes();
                break;
            }
            
        }while(choice<1 || choice > 5);    
    }
    
    public static void menuprodeditarsessao() throws ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
         
        System.out.println();
        System.out.println(ls.listarSessoesprod((Produtor) lu.retornauser(user, pass)));
        System.out.println();
        
        //if(!ls.listarSessoesprod((Produtor) lu.retornauser(user, pass)).equals(ls.listarSessoesprod((Produtor) lu.retornauser(user, pass)))){
        
        int idd=0;
        
        System.out.print("Id da sessão a alterar: ");
       boolean ex=true;
        do{
            try{
                if(ex==false) System.out.println("Sessão não existente. Insira um id válido");
                //input.nextLine();
                idd=input.nextInt();
                input.nextLine();
                ex=false;
            }catch(Exception e) {idd=-7;}
        }while(ls.retornasessaoid(idd)==null);
        
        System.out.println("O que pretende editar?\n");
        System.out.println("1- Estado da sessão");
        System.out.println("2- Data da sessão");
        System.out.println("3- Descrição da sessão");
        System.out.println("4- Associar a outro album");
        System.out.println("5- Voltar atrás");
        
        choice=567894;
        do{
            if(choice != 567894) System.out.println("Inserção inválida. Tente novamamente");
            try{
                input.nextLine();
                choice=input.nextInt();
            }catch(Exception e){choice=-2;};           
        }while(choice<1 || choice>5);
        
        switch(choice){
            case 1:
                System.out.println("Estado a atribuir: \n");
                System.out.println("1- Realizada");
                System.out.println("2- Não realizada");
                System.out.println("3- Voltar atrás");
                
                choice=567894;
                do{
                    if(choice != 567894) System.out.println("Inserção inválida. Tente novamamente");
                    try{
                        choice=input.nextInt();
                    }catch(Exception e){choice=-2;};           
                }while(choice<1 || choice>5);
                
                switch(choice){
                    case 1:
                        ls.retornasessaoid(idd).setEstado(true);
                        la.setEstadosessaoAlbum(ls.retornasessaoid(idd).getAlbumasergravado(), ls.retornasessaoid(idd), true);       
                        guardadados();
                    break;
                    
                    case 2:
                        ls.retornasessaoid(idd).setEstado(false);
                        la.setEstadosessaoAlbum(ls.retornasessaoid(idd).getAlbumasergravado(), ls.retornasessaoid(idd), false); 
                        guardadados();
                    break;
                    
                    case 3:
                        menuprodeditarsessao();
                    break;
                }
                
            break;
            
            case 2:
                System.out.println();
                System.out.println("Data antiga: "+ls.retornasessaoid(idd).getDatasessao().toString());
                System.out.println();
                System.out.print("Nova data: ");
                String dat = input.nextLine();
                
                ls.retornasessaoid(idd).setDatasessao(adicionadata(dat));
                la.setDatasessaoAlbum(ls.retornasessaoid(idd).getAlbumasergravado(), ls.retornasessaoid(idd), adicionadata(dat));
                
                guardadados();
        
            break;
            
            case 3:          
                System.out.println();
                System.out.println("Descrição antiga: "+ls.retornasessaoid(idd).getDescrição());
                System.out.println();
                System.out.print("Nova descrição: ");
                String descr = input.nextLine();
                ls.retornasessaoid(idd).setDescrição(descr);
                la.setDescriçãosessaoAlbum(ls.retornasessaoid(idd).getAlbumasergravado(), ls.retornasessaoid(idd), descr);
                
                guardadados();
                
            break;
        
            
            case 4:
                System.out.println();
                System.out.println("Album a que estava associada: "+ls.retornasessaoid(idd).getAlbumasergravado().getNomealbum());
                System.out.println(la.listarAlbunsprodpen((Produtor) lu.retornauser(user, pass)));
                System.out.print("Novo album a associar: ");
                String nommm;
                do{
                    nommm = input.nextLine();
                }while(la.getAlbum(nommm) != null);
                
                la.trocasessao(ls.retornasessaoid(idd).getAlbumasergravado(), la.getAlbum(nommm), ls.retornasessaoid(idd));
                
                guardadados();             
            break;
                        
            case 5:
                menuprodgeriralbunsesessoes();
            break;
        }
        
        System.out.println();
        System.out.println("Alteração concluida com sucesso!");
        input.nextLine();
        
        menuprodgeriralbunsesessoes();
    //}
    }
                                                                            //EXTRA
    public static void menuprodadicionaralbum() throws IOException, Exception{        
        Scanner input=new Scanner (System.in);
        
        System.out.println("Nome Album:");
        String nome = input.nextLine();
        System.out.println("Data do album (YYYY-MM-DD): ");
        String dat = input.nextLine();
        System.out.println("Tipo do Album: ");
        String tipo = input.nextLine();
        
        r1.construtorimprovisadoalb(nome, tipo, (Produtor) lu.retornauser(user, pass), adicionadata(dat)); //requisição do tipo album  
        r1.setIdrequisiçao(lr.getlastid() + 1); 
        lr.adicionar(r1);   
        guardadados();
        
        System.out.println("Pedido de album concretizado com sucesso!");
        input.nextLine();
        menuprodgeriralbunsesessoes();
    }
                                                            //EXTRA- colocar aqui os albuns que ainda faltam ser aceites pelo admin
    public static void menuprodalbunspendentes() throws ClassNotFoundException, Exception{       
        Scanner input=new Scanner (System.in);
        carregadados();
        
        System.out.println();
        System.out.println(lr.listarreqpendentesalb());
        System.out.println();
        
        input.nextLine();
        menuprodgeriralbunsesessoes();
    }
                                                                                
    public static void menuprodalbunsemproducao() throws ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        carregadados();
        
        System.out.println(la.listarAlbunsemprodprod((Produtor) lu.retornauser(user, pass)));
        input.nextLine();
        menuprodgeriralbunsesessoes();
    }
    
    
    public static void menuprodtodososalbuns() throws ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        carregadados();
        
        
        System.out.println(la.listarAlbunsprod((Produtor)lu.retornauser(user, pass)));
        
        input.nextLine();
        menuprodgeriralbunsesessoes();
    }
                                                                                //ESTA FALTA
    public static void menuprodtodasassessoes() throws IOException, ClassNotFoundException, Exception{  //Abrir todas as sessoes de gravação por dias. Quando for para escolher o dia, filtrar o dia para o escolhido pelo utilizador
        Scanner input=new Scanner (System.in);
        
        carregadados();
        
        System.out.println();
        System.out.println(ls.listarSessoesprod((Produtor) lu.retornauser(user, pass)));     
        System.out.println();
        
        input.nextLine();
        menuprodgeriralbunsesessoes();
    }
    
    public static void menuprodsessaoparaumdia() throws ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        String dat;
        
        System.out.println("Data desejada para visualizar sessões: ");
        dat = input.nextLine();
        
        System.out.println();
        System.out.println(ls.listarsessoesparadia(adicionadata(dat)));
        System.out.println();
        
        input.nextLine();
        menuprodgeriralbunsesessoes();
    }
    
    public static void menuprodadicionarsessao() throws IOException, ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        boolean mais=false;
        carregadados();
        
        System.out.println(la.listarAlbunsprod((Produtor)lu.retornauser(user, pass)));
        String albb="", datt="", descrr="";
        String mus="";
        //try{
            System.out.println("Pretende adicionar uma sessão a que album?");
            albb = input.nextLine();
            System.out.print("Data da sessão(YYYY-MM-DD): ");
            datt = input.nextLine();
            System.out.print("Descrição da sessão: ");
            descrr = input.nextLine();
         
            s1.construtorimprovisado(descrr, adicionadata(datt), la.getAlbum(albb), (Produtor) lu.retornauser(user, pass));
            s1.setIdsessao(ls.getlastid() + 1);
            ls.adicionar(s1);      //adiciona a sessão à lista de sessões
            la.getAlbum(albb).adicionassessaoAlbum(s1);                     //adiciona a sessão ao album
            
            System.out.println();
            System.out.println();
            System.out.println(lu.listarusersmus());
            System.out.println();
            
        
            int ids1 = ls.getUltimaSessao().getIdsessao();
            
               
        do{
            do{
                if(!mus.equals("")) System.out.println("Utilizador inválido. Insira novamente");
                System.out.println("Musico para a sessão: ");
                mus=input.nextLine();            
            }while(lu.retornamusico(mus)==null);
     
        
            s1.adicionamusico(lu.retornamusico(mus));                                //adicionar músico à sessão      
            ls.adicionarMusicoSessaopId(ids1, lu.retornamusico(mus));                //alterar para adicionar músico  à sessão na lista de sessões                                          
            la.getAlbum(albb).adicionamusicoassociado(lu.retornamusico(mus));        //adiciona músico à sessão do album
            (lu.retornamusico(mus)).adicionamussessao(lu.retornamusico(mus), ids1);        //Adiciona à sessão do músico    Erro na adicionamussessao
            (lu.retornamusporuser(mus)).adicionaSessaoaoMusico(s1);    //adiciona a sessão ao músico
            
            
                            
            
            guardadados();
            
            System.out.println("Deseja adicionar mais um músico à sessão?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            
            choice=567894;
            do{
                try{
                if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
                choice=input.nextInt();
                }catch(Exception e){menuprodgeriralbunsesessoes();}

            }while(choice<1 || choice>2);
            
            if(choice==1) mais=true;
            else mais=false; 
            }while(mais==true);
        
        guardadados();
                   
        //}catch(Exception E){menuprodadicionarsessao();}
        
        System.out.println("Sessão adicionada com sucesso! ");
        input.nextLine();
        
        menuprodgeriralbunsesessoes(); 
    }
    
    public static void menuprodremoversessao() throws IOException, ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        
        carregadados();
        
        System.out.println(la.listarAlbunsprod((Produtor)lu.retornauser(user, pass)));
        
        System.out.println("Pretende eliminar uma sessão referente a que album?");  
        String albb = input.nextLine();
        
        String mostra="";
        for(Object s : la.getAlbum(albb).getSessoesgravacao()){
            mostra+=s.toString();
            mostra+="\n";
        }
        System.out.println(mostra);
        int rem=0;
        try{
            System.out.println("Qual a sessão que pretende remover? ");
            rem = input.nextInt();
        }catch(Exception E){menuprodremoversessao();}
        la.getAlbum(albb).removesessaoAlbum(rem);
        ls.remover(ls.retornasessaoid(rem));
        
        
        guardadados();
        
        System.out.println("Sessão removida com sucesso! ");
        input.nextLine();
        
        menuprodgeriralbunsesessoes(); 
    }
    
    public static void menuprodtodasassessoesporconcluir() throws IOException, ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        
        carregadados();
        
        System.out.println();
        System.out.println(ls.listarSessoespconcluirprod((Produtor) lu.retornauser(user, pass)));     
        System.out.println();
        
        input.nextLine();
        menuprodgeriralbunsesessoes();     
    }
    
    public static void menuprodterminarsessao() throws Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println("Tem a certeza que pretende mudar de utilizador?\n");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        
        choice=567894;
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
            choice=input.nextInt();
            }catch(Exception E){menuprodterminarsessao();}
        }while(choice>2 || choice<1); 
        
        switch(choice){
            case 1:
                login();
            break;
            
            case 2:
                menuprodprincipal();
            break;
        }
    }
    
    
    //------------------------------------------------------MENUMUS-------------------------------------------
    
    public static void menumusprincipal() throws Exception{
        Scanner input=new Scanner (System.in);
        clearConsole();
                
        System.out.println("----------------------------------------------------------");
        System.out.println("Insira a opção desejada: \n");
        System.out.println("1- Meus albuns");  
        System.out.println("2- Minhas músicas");
        System.out.println("3- Calendário de sessões");
        System.out.println("4- Sobre mim");
        System.out.println("5- Terminar sessão");
        System.out.println("----------------------------------------------------------");
        
        choice = 567894;
        
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente.");
            choice=input.nextInt();
            }catch(Exception E){menumusprincipal();}
        } while(choice<1 || choice>5);
        
        switch(choice){
            case 1:
                menumusmeusalbuns();
            break;
            
            case 2:
                menumusminhasmusicas();
            break;
            
            case 3:
                menumuscalendariosess();
            break;
            
            case 4:
                menumussobremim();
            break;
            
            case 5:
                menumusterminarsessao();
            break;
        }
        
        
    }
   
    public static void menumusmeusalbuns() throws IOException, ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        carregadados();
      
        if(la.listarAlbunsmus((Musico) lu.retornauser(user, pass)) ==""){
            System.out.println("Ainda não tem albuns atribuidos");
            input.nextLine();       
            menumusprincipal();
        }
        else{
            System.out.println();
            System.out.println(la.listarAlbunsmus((Musico) lu.retornauser(user, pass)));;
            System.out.println();
            
            input.nextLine();
        
            menumusprincipal();
        }   
    }
    
    public static void menumusminhasmusicas() throws IOException, ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        carregadados();
        if(((Musico) lu.retornauser(user, pass)).getMusicasdoMusico().isEmpty()){
            System.out.println("Ainda não tem musicas associadas");
            input.nextLine();       
            menumusprincipal();
        }
        else{
            carregadados();
            System.out.println(lm.listamusicasmus((Musico) lu.retornauser(user, pass)));
            input.nextLine();
            menumusprincipal();
        }
    }
    
    public static void menumuscalendariosess() throws IOException, ClassNotFoundException, Exception{
        Scanner input=new Scanner (System.in);
        
        carregadados();
        System.out.println();
        System.out.println(((Musico) lu.retornauser(user, pass)).listarSessoesmus());
        System.out.println();
        
        
        System.out.println(((Musico) lu.retornauser(user, pass)).listarInstrumentosmus());
        System.out.println();
        
        
//--------------------------------------------------------------------REQUISIÇÃO DE INSTRUMENTO------------------------------------------
        
        
        System.out.println("Pretende fazer alguma requisição de instrumento para alguma sessão?\n");
        System.out.println("1- Fazer pedido de Instrumento");
        System.out.println("2- Sair");
        
        choice=567894;
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
            choice=input.nextInt();
            }catch(Exception E){menumuscalendariosess();}
        }while(choice<1 || choice>2); 
        
        int idd=0;
        
        switch(choice){
            
            case 1:
                String inst="";
                try{
                    System.out.println("Qual a sessão para que pretende fazer a requisição do instrumento?");
                    idd=input.nextInt();
                    System.out.println("Qual o nome do instrumento que pretende adicionar?");
                    input.nextLine();
                    inst=input.nextLine();
                }catch(Exception E){menumuscalendariosess();}
                
                r1.construtorimprovisadoinstr(inst, 1, lu.retornamusporuser(user), ls.retornasessaoid(idd));
                r1.setIdrequisiçao(lr.getlastid() + 1); 
                lr.adicionar(r1);
                guardadados();
                
                System.out.println("Requisição feita com sucesso!");
                input.nextLine();
                menumusprincipal();
                
            break;
            
            case 2:
                menumusprincipal();
            break;
    }
        
    }
    
    public static void menumussobremim() throws Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println("----------------------------------------------------------");
        System.out.println("Nome: "+lu.retornauser(user, pass).getNomeverdadeiro());
        System.out.println("Nome de utilizador: "+lu.retornauser(user, pass).getUserlogin());                     
        System.out.println("----------------------------------------------------------");
        
        
        System.out.println("1- Editar");
        System.out.println("2- Sair");
        choice = 567894;
        boolean verpass;
        boolean verpasss;
        
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente.");
            choice=input.nextInt();
             }catch(Exception E){menumussobremim();}
            
        } while(choice<1 || choice>2);
                
        switch(choice){
            case 1:
                System.out.println("----------------------------------------------------------");
                System.out.println("1- Alterar o meu nome ");
                System.out.println("2- Alterar palavra passe ");
                System.out.println("3- Voltar atrás ");
                System.out.println("----------------------------------------------------------");
                choice = 567894;
                
                do{
                    try{
                    if (choice != 567894) System.out.println("Inserção errada. Tente novamente.");
                    choice=input.nextInt();
                     }catch(Exception E){menumussobremim();}
                }while(choice<1 || choice>3);
                String newpass=null;
                switch(choice){
                    case 1:
                        System.out.print("Novo nome: ");
                        input.nextLine();
                        String name = input.nextLine();
                        System.out.print("Insira a sua palavra-passe atual: ");
                        verpass=true;
                        int count=0;
                        do{
                            if(verpass==false) System.out.println("Palavra passe errada. Insira novamente:");  
                            newpass = input.next();
                            verpass=false;                           
                            ++count;
                            if(count==3) login();
                        }while(!lu.retornauserporuser(user).getPalavrapasse().equals(newpass));
                        lu.retornauserporuser(user).setNomeverdadeiro(name);
                        System.out.println("Nome alterado com sucesso!");
                        input.nextLine();
                        menumusprincipal();                       
                       
                        
                    break;
                    
                    
                    case 2:
                        System.out.print("Palavra passe antiga: ");
                        input.nextLine();
                        String oldpass;
                        verpasss=true;
                        count=0;
                        do{
                            if(verpasss==false) System.out.println("Palavra passe errada. Tente novamente.");
                            oldpass = input.nextLine();
                            verpasss=false;
                            ++count;
                            if(count==3) login();
                        }while(!oldpass.equals(lu.retornauser(user, pass).getPalavrapasse()));
                        String newpass1;
                        String newpass2;
                        do{
                            System.out.print("Nova pass:");
                            newpass1=input.nextLine();

                            System.out.print("Insira novamente a nova pass:");
                            newpass2=input.nextLine();
                            
                        }while(!newpass1.equals(newpass2));
                        lu.retornauser(user, pass).setPalavrapasse(newpass1);
                        System.out.println("Palavra passe atualizada com sucesso!");
                        input.nextLine();
                        String fich="Utilizadores.dat";
                        lu.gravarUtilizadores(fich);
                        login();
                        
                    break;
                    
                    case 3:
                        menumusprincipal();
                    break;
                }
                
                
            break;
            
            case 2:
                menumusprincipal();
            break;
        }
            
    }
    
    public static void menumusterminarsessao() throws Exception{
        Scanner input=new Scanner (System.in);
        
        System.out.println("Tem a certeza que pretende mudar de utilizador?\n");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        
        choice=567894;
        do{
            try{
            if (choice != 567894) System.out.println("Inserção errada. Tente novamente:");
            choice=input.nextInt();
             }catch(Exception E){menumusterminarsessao();}
        }while(choice>2 || choice<1); 
        
        switch(choice){
            case 1:
                login();
            break;
            
            case 2:
                menumusprincipal();
            break;
        }
    }
    
    
    //--------------------------------------------------------------------------CARREGAR DADOS ---------------------------------------------------------
    
    public static void carregadados() throws IOException, ClassNotFoundException{
        lu.lerUtilizadores("Utilizadores.dat");
        li.lerInstrumentos("Instumentos.dat");
        la.lerAlbuns("Albuns.dat");
        lr.lerRequisiçoes("Requisicoes.dat");
        ls.lerSessoes("Sessoes.dat"); 
        lm.lerMusicas("Musicas.dat");
    }
    
    public static void guardadados() throws IOException{
        lu.gravarUtilizadores("Utilizadores.dat");
        li.gravarInstrumentos("Instumentos.dat");
        la.gravarAlbuns("Albuns.dat");
        lr.gravarRequisiçoes("Requisicoes.dat");
        ls.gravarSessoes("Sessoes.dat"); 
        lm.gravarMusicas("Musicas.dat");
    }
    
    
    //--------------------------------------------------------------------------MAIN--------------------------------------------------------------------
    
    public static void main (String [] args) throws Exception{
        
                            // INICIALIZAÇÕES NECESSÁRIAS  
        Administrador a1 = new Administrador("admin", "passwd", "Administrador");

        
        
        
        lu.adicionarUtilizador(a1);


        
        
        carregadados();
        //guardadados();
        
        login();

        }   //pertence ao main
}   //pertence à class (último sempre)