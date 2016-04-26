angular.module('AppModule', ['ngRoute', 'PacienteModule','MedicacoesModule'])

.controller('AppController', ['$scope', '$location', function($scope, $location) {

    // listagem no escopo maior da aplicação;
    // disponível a todos os controllers
    $scope.listaPaciente = [
        {
            id:100,
            nome: 'Antonio Silva',
            email: 'antonios@gmail.com',
            dataNascimento: '07/09/1950',
            contato: '51-91123456',
            sexo: 'M',
            escolaridade:'',
            profissao:'',
            ocupacao: '',
            endereco:{
                logadouro:'Rua A',
                numero:'123',
                bairro:'bairro1',
                cidade:'Porto Alegre',
                cep:'90020-100',
                estado:'RS'
            }
        },
        {
            id:200,
            nome: 'Jon Snow',
            email: 'snow@ymail.com',
            dataNascimento: '07/09/1950',
            contato: '51-91123456',
            sexo: 'M',
            escolaridade:'',
            profissao:'',
            ocupacao: '',
            endereco:{
                logadouro:'',
                numero:'',
                bairro:'',
                cidade:'',
                cep:'',
                estado:''
            }
        },
        {
            id:003,
            nome: 'Cersei Baratheon',
            email: 'cersei@got.com',
            dataNascimento: '07/09/1950',
            contato: '51-91123456',
            sexo: 'F',
            escolaridade:'',
            profissao:'',
            ocupacao: '',
            endereco:{
                logadouro:'',
                numero:'',
                bairro:'',
                cidade:'',
                cep:'',
                estado:''
            }
        }
    ];
    
    $scope.listaMedicacao = [
        {
            id : 100,
            pacienteId: 100,
            data: '01/01/2017',
            nomeComercial: 'Dipirona',
            principioAtivo: 'teste',
            indicacoes: 'teste',
            dose: '10mg',
            frequencia: '6 x 6 horas',
            observacoes: 'paciente deve tomar em jejum'
        },
        {
            id : 200,
            pacienteId: 200,
            data: '02/02/2017',
            nomeComercial: 'Dipirona2',
            principioAtivo: 'teste2',
            indicacoes: 'teste2',
            dose: '12mg',
            frequencia: '2 x 2 horas',
            observacoes: 'paciente deve tomar em jejum - 2'
        },
                {
            id : 300,
            pacienteId: 003,
            data: '03/03/2017',
            nomeComercial: 'Dipirona3',
            principioAtivo: 'teste3',
            indicacoes: 'teste3',
            dose: '13mg',
            frequencia: '3 x 3 horas',
            observacoes: 'paciente deve tomar em jejum - 3'
        }
    ];
    

      // gerar uma chave falsa para o registro
    $scope.getFakeID = function () {
         return Math.floor((Math.random() * 10000) + 500);
    };

    // função para redir de página disponível a todos os controllers
    $scope.redir = function (onde) {
         $location.path(onde);
    };
}])

.config(['$routeProvider', function ($routeProvider) {        
    $routeProvider.
    	// Paciente
        when('/paciente-novo', {
            templateUrl: 'partials/paciente-novo.html',
            controller: 'PacienteController'
        }).

        // Nova Medicacao
        when('/nova-medicacao',{
            templateUrl: 'partials/nova-medicacao.html',
            controller: 'MedicacoesController'
        }).

        when('/paciente-lista', {
            templateUrl: 'partials/paciente-lista.html',
            controller: 'PacienteController'
        }).

        when('panel2',{
            templateUrl: 'partials/paciente-lista.html',
            controller: 'PacienteController' 
        }).
                
        // Medicação
        when('/historico-medicacoes', {
            templateUrl:'partials/historico-medicacoes.html',
            controller: 'MedicacoesController'
        }).
        when('/nova-medicacao',{
            templateUrl: 'partials/nova-medicacao.html',
            controller: 'MedicacoesController'

        }).
    	// PADRÃO
        when('/', {
            templateUrl: 'partials/saudacao.html',
            controller: 'AppController'
        }).
        when('/404', {
            templateUrl: 'partials/404.html'
        }).
        // PÁGINA NÃO PREVISTA - 404 
        otherwise({
            redirectTo: '/404'
        });
}]); 