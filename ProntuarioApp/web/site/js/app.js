/* global App, when */

var app = angular.module('AppModule', ['ngRoute', 'PacienteModule','MedicacoesModule'])

.controller('AppController', function($scope, $rootScope, $location) {
    $rootScope.pacienteSelecionado = null;
    
    // listagem no escopo maior da aplicação;
    // disponível a todos os controllers
    $scope.listaPaciente = [];
    $scope.listaMedicacao = [];
    
    // gerar uma chave falsa para o registro
    $scope.getFakeID = function () {
         return Math.floor((Math.random() * 10000) + 500);
    };

    // função para redir de página disponível a todos os controllers
    $scope.redir = function (onde) {
         $location.path(onde);
    };
})

.config(function ($routeProvider) {
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
                
        // Medicação
        when('/historico-medicacoes', {
            templateUrl:'partials/historico-medicacoes.html',
            controller: 'MedicacoesController'
        }).
        // 3 Revisao da Saúde
        when('/revisao-saude', {
            templateUrl:'partials/revisao-saude.html',
            controller: 'RevisaoSaudeController'
        }).
        when('/cardio', {
            templateUrl:'partials/revisao-saude.html',
            controller: 'RevisaoSaudeController'
        }).
                
        when('/gineco', {
            templateUrl:'partials/revisao-saude.html',
            controller: 'RevisaoSaudeController'
        }).
                
        when('/uro', {
            templateUrl:'partials/revisao-saude.html',
            controller: 'RevisaoSaudeController'
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
});