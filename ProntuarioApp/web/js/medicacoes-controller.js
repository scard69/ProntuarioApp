angular.module('MedicacoesModule', ['AppModule']).
        controller('MedicacoesController', ['$scope', '$rootScope', function ($scope, $rootScope) {
                $scope.medicacao = {};
                $scope.paciente = null;
                
                if ($rootScope.pacienteSelecionado !== null) {
                    $scope.paciente = $rootScope.pacienteSelecionado;
                    $scope.medicacao.pacienteId = $scope.paciente.id;
                }
                
                $scope.excluir = function (key) {
                    for (var i = 0; i < $scope.listaMedicacao.length; i++) {
                        if ($scope.listaMedicacao[i].id === key) {
                            $scope.listaMedicacao.splice(i, 1);
                        }
                    }
                };

                $scope.salvar = function () {
                    if (!$scope.medicacao.nomeComercial || !$scope.medicacao.dose || !$scope.medicacao.frequencia || !$scope.medicacao.principioAtivo) {
                        alert('Campos obrigatórios não foram preenchidos!');
                        return;
                    }

                    $scope.medicacao.id = $scope.getFakeID();
                    $scope.listaMedicacao.push($scope.medicacao);
                    $scope.redir('/historico-medicacoes');
                };
                
                $scope.pesquisa = function(medicacao) {
                    if ($scope.paciente !== null) {
                        if (medicacao.pacienteId == $scope.paciente.id) {
                            return true;
                        }
                    }
                    return false;
                };
                
                $scope.selecionaPaciente = function() {
                    $rootScope.pacienteSelecionado = $scope.paciente;
                };
}]);
