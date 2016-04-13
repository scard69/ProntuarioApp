angular.module('AppModule', ['ngRoute', 'ClienteModule'])

.controller('AppController', ['$scope', '$location', function($scope, $location) {

    // listagem no escopo maior da aplicação;
    // disponível a todos os controllers
    $scope.listaCliente = [
        {
            id:100,
            nome: 'Daenerys Targaryen',
            email: 'targaryen@gmail.com'
        },
        {
            id:200,
            nome: 'Jon Snow',
            email: 'snow@gmail.com'
        },
        {
            id:300,
            nome: 'Cersei Baratheon',
            email: 'cersei@got.com'
        }
    ];

    // gerar uma chave falsa para o registro
    $scope.getFakeID = function () {
         return Math.floor((Math.random() * 10000) + 500);
    };

    // função para redir de página disponível a todos os controllers
    $scope.redir = function (onde) {
         $location.path(onde);
    }
}])

.config(['$routeProvider', function ($routeProvider) {        
    $routeProvider.
    	// CLIENTE
        when('/cliente-novo', {
            templateUrl: 'partials/cliente-novo.html',
            controller: 'ClienteController'
        }).
        when('/cliente-lista', {
            templateUrl: 'partials/cliente-lista.html',
            controller: 'ClienteController'
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
}])

;       