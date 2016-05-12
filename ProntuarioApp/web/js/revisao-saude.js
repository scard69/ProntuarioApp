// adicionado o AppModule para 'herdar' a lista de clientes
angular.module('RevisaoSaudeModule', ['AppModule']).
        controller('RevisaoSaudeController', ['$scope', '$rootScope', function ($scope, $rootScope) {
                
                $scope.revisaoSaude = {};
                $scope.paciente = null;                                             
}]);

